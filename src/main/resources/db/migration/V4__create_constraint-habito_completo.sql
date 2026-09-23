ALTER TABLE habito_completo
ADD CONSTRAINT uk_habito_completo_habito_data UNIQUE (fk_habito, data_conclusao);