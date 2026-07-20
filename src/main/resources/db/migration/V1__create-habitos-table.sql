-- Extensão necessária para gerar UUID no banco
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE usuario (
                         id      UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         nome    VARCHAR(255) NOT NULL,
                         email   VARCHAR(255) NOT NULL UNIQUE,
                         senha   VARCHAR(255) NOT NULL
);

CREATE TABLE habito (
                        id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                        nome           VARCHAR(255) NOT NULL,
                        data_ativacao  DATE NOT NULL DEFAULT CURRENT_DATE,
                        fk_usuario     UUID NOT NULL,
                        CONSTRAINT fk_habito_usuario
                            FOREIGN KEY (fk_usuario) REFERENCES usuario(id)
);

CREATE TABLE habito_completo (
                                 id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                 fk_habito       UUID NOT NULL,
                                 data_conclusao  DATE NOT NULL,
                                 CONSTRAINT fk_completo_habito
                                     FOREIGN KEY (fk_habito) REFERENCES habito(id)
                                         ON DELETE CASCADE,
                                 CONSTRAINT uq_habito_data
                                     UNIQUE (fk_habito, data_conclusao)
);