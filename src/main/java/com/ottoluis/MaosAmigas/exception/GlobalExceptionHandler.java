package com.ottoluis.MaosAmigas.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 - Recurso não encontrado
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleNaoEncontrado(
            RecursoNaoEncontradoException ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.NOT_FOUND, "Não Encontrado",
                ex.getMessage(), request, null);
    }

    // 409 - Conflito (ex: e-mail duplicado)
    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<ErroResponse> handleDuplicado(
            RecursoDuplicadoException ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.CONFLICT, "Conflito",
                ex.getMessage(), request, null);
    }

    // 422 - Violação de regra de negócio
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroResponse> handleRegraDeNegocio(
            RegraDeNegocioException ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.UNPROCESSABLE_ENTITY, "Regra de Negócio Violada",
                ex.getMessage(), request, null);
    }

    // 400 - Erros de validação do @Valid (Bean Validation)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> handleValidacao(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<String> detalhes = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .toList();

        return construirResposta(HttpStatus.BAD_REQUEST, "Erro de Validação",
                "Um ou mais campos estão inválidos", request, detalhes);
    }

    // 409 - Violação de integridade no banco (ex: e-mail único, chave estrangeira)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponse> handleIntegridade(
            DataIntegrityViolationException ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.CONFLICT, "Conflito de Dados",
                "A operação viola uma restrição de integridade do banco de dados",
                request, null);
    }

    // 405 - Método HTTP não suportado (ex: PATCH numa rota que só aceita PUT)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErroResponse> handleMetodoNaoSuportado(
            HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.METHOD_NOT_ALLOWED, "Método Não Permitido",
                ex.getMessage(), request, null);
    }

    // 500 - Qualquer outra exceção não tratada (fallback de segurança)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleGenerico(
            Exception ex, HttpServletRequest request) {

        return construirResposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro Interno",
                "Ocorreu um erro inesperado. Tente novamente mais tarde.",
                request, null);
    }

    private ResponseEntity<ErroResponse> construirResposta(
            HttpStatus status, String erro, String mensagem,
            HttpServletRequest request, List<String> detalhes) {

        ErroResponse body = new ErroResponse(
                LocalDateTime.now(),
                status.value(),
                erro,
                mensagem,
                request.getRequestURI(),
                detalhes
        );

        return ResponseEntity.status(status).body(body);
    }
}