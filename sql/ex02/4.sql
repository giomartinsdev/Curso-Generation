/*
Atividade 4

Crie um banco de dados para um serviço de um Açougue ou de um Hortifruti.
O nome do Banco de dados deverá ter o seguinte nome db_cidade_das_carnes ou cidade_dos_vegetais.
O sistema trabalhará com as informações dos produtos comercializados pela empresa.
O sistema trabalhará com 2 tabelas tb_produtos e tb_categorias, que deverão estar relacionadas.

*/


create database db_cidade_das_carnes;

use db_cidade_das_carnes;

-- 1 Crie a tabela tb_categorias e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar os produtos.

create table tb_categorias(
	id bigint auto_increment not null primary key,
    nome varchar(255) not null,
    descricao varchar(255)
);


-- 2 Crie a tabela tb_produtos e determine 4 atributos, além da Chave Primária, relevantes aos produtos da farmácia.
-- 3 Não esqueça de criar a Foreign Key da tabela tb_categorias na tabela tb_produtos.

create table tb_produtos(
	id bigint auto_increment not null primary key,
    nome varchar(255) not null,
    valor decimal(10,2) not null,
    quantidade bigint not null,
    categoria_id bigint not null,
    foreign key (categoria_id) references tb_categorias(id)
);


-- 4 Insira 5 registros na tabela tb_categorias.
insert into tb_categorias (nome, descricao) values
("Suina", "Carne suína do sul."),
("Bovina", "Carne Bovina da Europa."),
("Ave", "Aves criadas na China."),
("Exótica", "Sua origem é secreta."),
("Cordeiro", "Criados em grandes montanhas.");

-- 5 Insira 8 registros na tabela tb_produtos, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_categorias.
insert into tb_produtos (nome, valor, quantidade, categoria_id) values
("Filé Mignon",60.00,20,2),
("Costela de Boi",45.50,15,2),
("Linguiça Toscana",18.75,30,1),
("Bacon Defumado",22.90,25,1),
("Peito de Frango",45.50,40,3),
("Perna de Peru",45.75,18,3),
("Pernil de Cordeiro",55.60,10,5),
("Carne de Avestruz",80,8,4);

-- 6 Faça um SELECT que retorne todes os produtos cujo valor seja maior do que R$ 50,00.
select * from tb_produtos where valor > 50.00;

-- 7 Faça um SELECT que retorne todes os produtos cujo valor esteja no intervalo R$ 50,00 e R$ 150,00.
select * from tb_produtos where valor between 50.00 and 150.00;

-- 8 Faça um SELECT utilizando o operador LIKE, buscando todes os produtos que possuam a letra C no atributo nome.
select * from tb_produtos where nome like "%c%";

-- 9 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_produtos com os dados da tabela tb_categorias.
select * from tb_produtos
inner join tb_categorias
on tb_produtos.categoria_id = tb_categorias.id;

-- Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_produtos com os dados da tabela tb_categorias,
-- onde traga apenas os produtos que pertençam a uma categoria específica (Exemplo: Todes os produtos que pertencem a categoria aves ou frutas).
select * from tb_produtos
inner join tb_categorias
on tb_categorias.id = tb_produtos.categoria_id
where tb_produtos.categoria_id = 3;