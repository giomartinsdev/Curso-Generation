/*ATIVIDADE 01

Crie um banco de dados para um serviço de um Games Online.
O nome do Banco de dados deverá ter o seguinte nome db_generation_game_online.
O sistema trabalhará com as informações dos personagens do jogo.
O sistema trabalhará com 2 tabelas tb_personagens e tb_classes, que deverão estar relacionadas.
*/


CREATE DATABASE db_generation_game_online;

-- 1 Crie a tabela tb_classes e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar os personagens do Game Online.

CREATE TABLE tb_classes(
	id bigint auto_increment primary key,
	classe varchar(255) not null,
	exp bigint not null
);

-- 2 Crie a tabela tb_personagens e determine 4 atributos, além da Chave Primária, relevantes aos personagens do Game Online.
-- Não esqueça de criar a Foreign Key da tabela tb_classes na tabela tb_personagens.
CREATE TABLE tb_personagens(
	id bigint auto_increment primary key,
	nome varchar(255),
	altura decimal(5,2),
	genero ENUM('Masculino', 'Feminino', 'Outro'),
	idade bigint,
	ataque bigint not null,
	defesa bigint not null,
	classe_id bigint not null,
	foreign key (classe_id) references tb_classes(id)
);

-- 4 Insira 5 registros na tabela tb_classes.

INSERT INTO tb_classes (classe, exp) VALUES
('Guerreiro', 1000),
('Mago', 1500),
('Ladrão', 800),
('Clerigo', 1200),
('Arqueiro', 1100);


-- 5 Insira 8 registros na tabela tb_personagens, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_classes.
INSERT INTO tb_personagens (nome, altura, genero, idade, ataque, defesa, classe_id) VALUES
('Herói 1', 1.80, 'Masculino', 30, 2000, 800, 1),
('Feiticeira 1', 1.65, 'Feminino', 2500, 800, 60, 2),
('Ladrão 1', 1.70, 'Masculino', 28, 1000, 700, 3),
('Clerigo 1', 1.75, 'Masculino', 35, 900, 1000, 4),
('Arqueiro 1', 1.78, 'Masculino', 27, 1100, 7050, 5),
('Herói 2', 1.85, 'Masculino', 32, 1300, 850, 1),
('Feiticeira 2', 1.70, 'Feminino', 28, 850, 650, 2),
('Ladrão 2', 1.68, 'Masculino', 26, 9050, 705, 3),
('Clerigo 2', 1.77, 'Masculino', 33, 9002, 980, 4),
('Arqueiro 2', 1.79, 'Masculino', 29, 11005, 720, 5),
('Herói 3', 1.82, 'Masculino', 31, 12500, 820, 1),
('Feiticeira 3', 1.68, 'Feminino', 26, 8800, 700, 2),
('Ladrão 3', 1.66, 'Masculino', 27, 970, 7700, 3),
('Clerigo 3', 1.76, 'Masculino', 34, 940, 9600, 4),
('Arqueiro 3', 1.81, 'Masculino', 30, 1102, 7800, 5);


-- 6 Faça um SELECT que retorne todes os personagens cujo poder de ataque seja maior do que 2000.

SELECT * FROM tb_personagens WHERE ataque > 2000;

-- 7 Faça um SELECT que retorne todes os personagens cujo poder de defesa esteja no intervalo 1000 e 2000.

SELECT * FROM tb_personagens WHERE defesa BETWEEN 1000 and 2000;

-- 8 Faça um SELECT utilizando o operador LIKE, buscando todes os personagens que possuam a letra C no atributo nome.

SELECT * FROM tb_personagens WHERE nome LIKE '%c%';

-- 9 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_personagens com os dados da tabela tb_classes.

SELECT * FROM tb_personagens inner join tb_classes on tb_personagens.classe_id = tb_classes.id;

-- 10 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_personagens com os dados da tabela tb_classes,
-- onde traga apenas os personagens que pertençam a uma classe específica (Exemplo: Todes os personagens da classe dos arqueiros).

SELECT * FROM tb_personagens inner join tb_classes on tb_personagens.classe_id = tb_classes.id
WHERE tb_classes.classe = "Ladrão";




