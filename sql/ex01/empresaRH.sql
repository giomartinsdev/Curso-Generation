CREATE TABLE tb_funcionarios(
    id BIGINT AUTO_INCREMENT,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    telefone int not null,
    email varchar(255) not null,
    PRIMARY KEY(id)
);

alter table tb_funcionarios add salario decimal(10,2) not null;

insert into tb_funcionarios(nome, sobrenome, telefone, email, salario)
values("Giovanni","Martins", 980957143, "giovanni@gmail.com", 2223.87);

insert into tb_funcionarios(nome, sobrenome, telefone, email, salario)
values("Elias","Moura", 980953453, "eliasM@gmail.com", 1223.22);

insert into tb_funcionarios(nome, sobrenome, telefone, email, salario)
values("Raquel","Eliza", 985903453, "raquel@gmail.com", 1023.55);

insert into tb_funcionarios(nome, sobrenome, telefone, email, salario)
values("Gabriel","Assis", 989503453, "gabriel@gmail.com", 3324.86);

insert into tb_funcionarios(nome, sobrenome, telefone, email, salario)
values("Ricardo","Galvão", 989503354, "ricardo@gmail.com", 982.12);

select * from tb_funcionarios where salario > 2000;

select * from tb_funcionarios where salario < 2000;

UPDATE
  tb_funcionarios
SET
  salario = 1000.98
WHERE
  salario < 1000

