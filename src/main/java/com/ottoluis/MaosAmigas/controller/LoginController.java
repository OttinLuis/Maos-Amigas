
package com.ottoluis.MaosAmigas.controller;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;
    private final long jwtDurationSeconds;

    public LoginController(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder,
            JWKSource<SecurityContext> jwkSource,
            @Value("${security.jwt.duration}") long jwtDurationSeconds) {

        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtEncoder = new NimbusJwtEncoder(jwkSource);
        this.jwtDurationSeconds = jwtDurationSeconds;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (request.email() == null || request.senha() == null
                || request.email().isBlank() || request.senha().isBlank()) {
            return ResponseEntity.badRequest().body(
                    Map.of("mensagem", "Informe o e-mail e a senha."));
        }

        try {
            String email = request.email().trim();

            UserDetails usuario =
                    userDetailsService.loadUserByUsername(email);

            if (!passwordEncoder.matches(
                    request.senha(), usuario.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "mensagem",
                                "E-mail ou senha inválidos."));
            }

            Instant agora = Instant.now();
            Instant expiracao = agora.plusSeconds(jwtDurationSeconds);

            List<String> authorities = usuario.getAuthorities()
                    .stream()
                    .map(authority -> authority.getAuthority())
                    .toList();

            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .subject(usuario.getUsername())
                    .issuedAt(agora)
                    .expiresAt(expiracao)
                    .claim("username", usuario.getUsername())
                    .claim("authorities", authorities)
                    .build();

            JwsHeader header = JwsHeader
                    .with(SignatureAlgorithm.RS256)
                    .build();

            String token = jwtEncoder.encode(
                            JwtEncoderParameters.from(header, claims))
                    .getTokenValue();

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "accessToken", token,
                    "tokenType", "Bearer",
                    "expiresIn", jwtDurationSeconds
            ));

        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "mensagem",
                            "E-mail ou senha inválidos."));
        }
    }

    public record LoginRequest(String email, String senha) {
    }
}