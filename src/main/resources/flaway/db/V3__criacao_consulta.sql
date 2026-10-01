CREATE TABLE consulta_tb (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    psicologo_id BIGINT NOT NULL,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    link_atendimento VARCHAR(500),

    CONSTRAINT fk_consulta_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario_tb(id),

    CONSTRAINT fk_consulta_psicologo
        FOREIGN KEY (psicologo_id) REFERENCES suporte_psicologico_tb(id)
);