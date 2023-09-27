/*
Atividade 2

Crie um banco de dados para um serviço de uma Pizzaria.
O nome do Banco de dados deverá ter o seguinte nome db_pizzaria_legal.
O sistema trabalhará com as informações dos produtos comercializados pela empresa.
O sistema trabalhará com 2 tabelas tb_pizzas e tb_categorias, que deverão estar relacionadas.
*/

CREATE DATABASE db_pizzaria_legal;

USE db_pizzaria_legal;

-- 1 Crie a tabela tb_categorias e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar as pizzas.

CREATE TABLE tb_categorias(
id bigint auto_increment primary key,
nome_categoria varchar(255),
popularidade int
);

-- 2 Crie a tabela tb_pizzas e determine 4 atributos, além da Chave Primária, relevantes aos produtos da pizzaria.
-- 3 Não esqueça de criar a Foreign Key da tabela tb_categorias na tabela tb_pizzas.

CREATE TABLE tb_pizzas(
id bigint auto_increment primary key,
nome_pizza varchar(255),
descricao text,
tipo enum("doce", "salgado"),
preco decimal (8,2),
categoria_id bigint,
foreign key (categoria_id) references tb_categorias(id)
);

-- 4 Insira 5 registros na tabela tb_categorias.
INSERT INTO tb_categorias(nome_categoria, popularidade)
VALUES
('Margherita', 5),
('Pepperoni', 4),
('Vegetariana', 3),
('Frango com Catupiry', 4);


-- 5 Insira 8 registros na tabela tb_pizzas, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_categorias.
INSERT INTO tb_pizzas (nome_pizza, descricao, tipo, preco, categoria_id)
VALUES
    ('Pizza Margherita', 'Molho de tomate, muçarela, manjericão fresco.', 'salgado',80.99, 1),
    ('Pizza Pepperoni', 'Molho de tomate, pepperoni, queijo, orégano.', 'salgado', 50.00, 2),
    ('Pizza Vegetariana', 'Molho de tomate, pimentões, cebola, azeitonas.', 'salgado', 100.99, 3),
    ('Pizza Frango com Catupiry', 'Molho de tomate, frango desfiado, catupiry.', 'salgado', 65.99, 4);


-- 6 Faça um SELECT que retorne todas as pizzas cujo valor seja maior do que R$ 45,00.
SELECT * FROM tb_pizzas WHERE preco > 45.00;

-- 7 Faça um SELECT que retorne todas as pizzas cujo valor esteja no intervalo R$ 50,00 e R$ 100,00.
SELECT * FROM tb_pizzas WHERE preco between 50.00 AND 100.00;

-- 8 Faça um SELECT utilizando o operador LIKE, buscando todas as pizzas que possuam a letra M no atributo nome.
SELECT * FROM tb_pizzas WHERE nome_pizza LIKE '%m%';

-- 9 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_pizzas com os dados da tabela tb_categorias.
SELECT * FROM tb_pizzas INNER JOIN tb_categorias ON tb_pizzas.categoria_id = tb_categorias.id;

-- 10 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_pizzas com os dados da tabela tb_categorias,
-- onde traga apenas as pizzas que pertençam a uma categoria específica (Exemplo: Todas as pizzas que são doce).
SELECT * FROM tb_pizzas INNER JOIN tb_categorias ON tb_pizzas.categoria_id WHERE tipo = "salgado";