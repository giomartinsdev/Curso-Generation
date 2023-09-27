/*
Atividade 5

Crie um banco de dados para um serviço de uma loja de Material de Construção.
O nome do Banco de dados deverá ter o seguinte nome db_construindo_vidas.
O sistema trabalhará com as informações dos produtos comercializados pela empresa.
O sistema trabalhará com 2 tabelas tb_produtos e tb_categorias, que deverão estar relacionadas.
*/

create database db_construindo_vidas;

use db_construindo_vidas;

-- 1 Crie a tabela tb_categorias e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar os produtos.
create table tb_categorias(
    id bigint auto_increment primary key,
    nome varchar(100) not null unique,
    descricao varchar(255)
);

-- 2 Crie a tabela tb_produtos e determine 4 atributos, além da Chave Primária, relevantes aos produtos da farmácia.
-- 3 Não esqueça de criar a Foreign Key da tabela tb_categorias na tabela tb_produtos.

create table tb_produtos(
    id bigint auto_increment primary key,
    nome varchar(100) not null unique,
    valor decimal(8,2) not null,
    estoque bigint not null,
    categoria_id bigint not null,
    foreign key (categoria_id) references tb_categorias(id)
);

-- 4 Insira 5 registros na tabela tb_categorias.

INSERT INTO tb_categorias (nome, descricao)
VALUES
    ('Eletrônicos', 'Produtos eletrônicos diversos'),
    ('Roupas', 'Roupas de moda masculina e feminina'),
    ('Alimentos', 'Produtos alimentícios'),
    ('Móveis', 'Móveis para casa e escritório'),
    ('Esportes', 'Equipamentos esportivos');


-- 5 Insira 8 registros na tabela tb_produtos, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_categorias.

INSERT INTO tb_produtos (nome, valor, estoque, categoria_id)
VALUES
    ('Smartphone', 799.99, 100, 1),
    ('Notebook', 1299.99, 50, 1),
    ('Camiseta', 69.99, 200, 2),
    ('Calça Jeans', 99.99, 150, 2),
    ('Arroz', 5.99, 500, 3),
    ('Sofá', 499.99, 30, 4),
    ('Bola de Futebol', 19.99, 100, 5),
    ('Raquete de Tênis', 59.99, 50, 5);


-- 6 Faça um SELECT que retorne todes os produtos cujo valor seja maior do que R$ 100,00.

select * from tb_produtos p
inner join tb_categorias c
on p.categoria_id = c.id
where p.valor > 100;

-- 7 Faça um SELECT que retorne todes os produtos cujo valor esteja no intervalo R$ 70,00 e R$ 150,00.
select * from tb_produtos p
inner join tb_categorias c
on p.categoria_id = c.id
where p.valor between 70 and 150;

-- 8 Faça um SELECT utilizando o operador LIKE, buscando todes os produtos que possuam a letra C no atributo nome.
select * from tb_produtos p
inner join tb_categorias c
on p.categoria_id = c.id
where p.nome like "%c%";

-- 9 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_produtos com os dados da tabela tb_categorias.
select * from tb_produtos p
inner join tb_categorias c
on p.categoria_id = c.id;

-- 10 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_produtos com os dados da tabela tb_categorias,
-- onde traga apenas os produtos que pertençam a uma categoria específica (Exemplo: Todes os produtos que pertencem a categoria hidráulica).
select * from tb_produtos p
inner join tb_categorias c
on p.categoria_id = c.id
where c.nome = "Eletrônicos";