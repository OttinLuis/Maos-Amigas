CREATE TABLE suporte_psicologico_tb (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    crp VARCHAR(50) NOT NULL UNIQUE
);