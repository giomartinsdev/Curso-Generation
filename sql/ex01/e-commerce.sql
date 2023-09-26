create database DB_ECOMMERCE;

create table tb_produtos(
id BIGINT AUTO_INCREMENT not null,
nome VARCHAR(255) not null,
valor decimal(10,2) not null,
descricao VARCHAR(255),
data_de_entrada DATETIME not null,
quantidade int not null,
PRIMARY KEY(id)
);


insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("IPHONE 15", 1.32, "500GB", CURRENT_TIMESTAMP, 15);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("MAC PRO", 50224.32, "2023", CURRENT_TIMESTAMP, 3);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("COMPUTADOR POSITIVO", 1234.14, "4GBRAM DDR3", CURRENT_TIMESTAMP, 43);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("GELADEIRA CONSUL", 5000.78, "FROST FREE", CURRENT_TIMESTAMP, 5);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("TECLADO MECANICO", 523.55, "REDDRAGON", CURRENT_TIMESTAMP, 50);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("MONITOR", 324.32, "22.1 fox", CURRENT_TIMESTAMP, 15);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("CADEIRA DE ESCRITORIO", 10020.45, "SUPERCHAIRCO", CURRENT_TIMESTAMP, 5);
insert into tb_produtos(nome, valor, descricao, data_de_entrada, quantidade)
values("TV LG", 5224.32, "45polegadas smartvFull", CURRENT_TIMESTAMP, 15);

select * from tb_produtos where valor > 500;
select * from tb_produtos where valor < 500;

UPDATE
  tb_produtos
SET
  valor = 11232.32
WHERE
  nome = "IPHONE 15"
