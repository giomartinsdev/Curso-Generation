CREATE DATABASE DB_ESCOLAPEQUENOSPASSOS
CREATE TABLE tb_alunos(
id BIGINT AUTO_INCREMENT NOT NULL,
nome VARCHAR(255) NOT NULL,
sobrenome VARCHAR(255) NOT NULL,
nome_responsavel VARCHAR(255) NOT NULL,
tel_responsavel BIGINT NOT NULL,
nota_media DECIMAL(10,2) NOT NULL,
PRIMARY KEY(id));

INSERT INTO tb_alunos (nome, sobrenome, nome_responsavel, tel_responsavel, nota_media)
VALUES 
    ('João', 'Silva', 'Maria Silva', 123456789, 8.50),
    ('Pedro', 'Santos', 'Ana Santos', 987654321, 7.25),
    ('Mariana', 'Oliveira', 'José Oliveira', 555555555, 9.50),
    ('Lucas', 'Ferreira', 'Carla Ferreira', 111111111, 6.75),
    ('Ana', 'Ribeiro', 'Luís Ribeiro', 999999999, 8.25),
    ('Paulo', 'Gomes', 'Rita Gomes', 777777777, 7.50),
    ('Sofia', 'Martins', 'Daniel Martins', 888888888, 9.25),
    ('Carlos', 'Rodrigues', 'Marta Rodrigues', 666666666, 6.50);
    
SELECT * FROM tb_alunos where nota_media > 7;
SELECT * FROM tb_alunos where nota_media < 7;

UPDATE
	tb_alunos
SET
	nome_responsavel = "Jorge Santos"
WHERE
	nome_responsavel = "Ana Santos";


