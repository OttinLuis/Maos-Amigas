package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.dto.UsuarioDTO;
import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.mapper.UsuarioMapper;
import com.ottoluis.MaosAmigas.models.Role;
import com.ottoluis.MaosAmigas.models.Usuario;
import com.ottoluis.MaosAmigas.projection.UserDetailsProjection;
import com.ottoluis.MaosAmigas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario", id));
        return UsuarioMapper.toDto(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> resultado = usuarioRepository.searchUserAndRolesByEmail(username);

        if (resultado.size() == 0){ // se a lista estiver vazia cai no exception
            throw new UsernameNotFoundException("Usuario näo encontrado");
        }
        Usuario usuario = new Usuario(); //cria um novo usuario(vazio)
        usuario.setEmail(username); //coloca o email encontrado na consulta
        usuario.setSenha(resultado.get(0).getPassword()); // coloca a senha e pega o primeiro resultado da lista
        for (UserDetailsProjection projection : resultado ){   //percorre os resultados
            usuario.addRole(new Role(projection.getRoleId(), projection.getAuthority())); //cria a role, e adiciona a role ao usuario
        }
        return usuario; //retorna o usuario
    }
}
