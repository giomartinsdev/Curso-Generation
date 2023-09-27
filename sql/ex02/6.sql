/* Atividade 6

Crie um banco de dados para uma plataforma de Cursos Online (EAD).
O nome do Banco de dados deverá ter o seguinte nome db_curso_da_minha_vida.
O sistema trabalhará com as informações dos produtos comercializados pela empresa.
O sistema trabalhará com 2 tabelas tb_cursos e tb_categorias, que deverão estar relacionadas.

*/

CREATE DATABASE db_curso_da_minha_vida;
use db_curso_da_minha_vida;
/*
1- Crie a tabela tb_categorias e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar os produtos.
2- Crie a tabela tb_cursos e determine 4 atributos, além da Chave Primária, relevantes aos produtos.
3- Não esqueça de criar a Foreign Key da tabela tb_categorias na tabela tb_cursos.
*/

CREATE Table tb_categorias(
	categoria_id bigint auto_increment primary key,
    nome varchar(255) not null,
    descricao text,
    imagem_url varchar(255)
);

CREATE Table tb_cursos(
    curso_id bigint auto_increment primary key,
    nome varchar(255) not null,
    descricao text,
    valor decimal(10,2),
    duracao_horas int,
    categoria_id bigint,
    foreign key (categoria_id) references tb_categorias(categoria_id)
);


-- 4 Insira 5 registros na tabela tb_categorias.
INSERT INTO tb_categorias (nome, descricao, imagem_url) VALUES
('Programação', 'Cursos de programação para iniciantes e avançados.', 'https://example.com/programming.jpg'),
('Design Gráfico', 'Cursos de design gráfico e criação de mídia visual.', 'https://example.com/graphic_design.jpg'),
('Marketing Digital', 'Cursos sobre estratégias de marketing digital.', 'https://example.com/marketing_digital.jpg'),
('Línguas Estrangeiras', 'Cursos para aprender línguas estrangeiras.', 'https://example.com/languages.jpg'),
('Gestão de Projetos', 'Cursos sobre gerenciamento de projetos.', 'https://example.com/project_management.jpg');


-- 5 Insira 8 registros na tabela tb_cursos, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_categorias.
INSERT INTO tb_cursos (nome, descricao, duracao_horas, valor,categoria_id) VALUES
('Introdução à Programação em Python', 'Curso introdutório de programação em Python.', 40, 500,1),
('Design de Logotipos Profissionais', 'Aprenda a criar logotipos profissionais.', 30, 1500, 2),
('Estratégias de Marketing nas Redes Sociais', 'Maximize seu alcance nas redes sociais.', 20, 5500, 3),
('Inglês para Iniciantes', 'Aprenda o básico do inglês.', 60, 8500, 4),
('Gestão de Projetos Ágeis', 'Curso avançado de gestão de projetos ágeis.', 50, 600, 5),
('Desenvolvimento Web Avançado', 'Aprofunde seus conhecimentos em desenvolvimento web.', 45, 900, 1),
('Adobe Photoshop Masterclass', 'Torne-se um especialista em Photoshop.', 35, 1000, 2),
('SEO e Marketing de Conteúdo', 'Domine as técnicas de SEO e marketing de conteúdo.', 25, 500, 3);

-- 6 Faça um SELECT que retorne todes os cursos cujo valor seja maior do que R$ 500,00.

SELECT * FROM tb_cursos WHERE valor > 500;

-- 7 Faça um SELECT que retorne todes os cursos cujo valor esteja no intervalo R$ 600,00 e R$ 1000,00.

SELECT * FROM tb_cursos WHERE valor BETWEEN 600 and 1000;

-- 8 Faça um SELECT utilizando o operador LIKE, buscando todes os cursos que possuam a letra J no atributo nome.

SELECT * FROM tb_cursos WHERE nome LIKE "%J%";

-- 9 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_cursos com os dados da tabela tb_categorias.

SELECT * FROM tb_cursos inner join tb_categorias on tb_cursos.categoria_id = tb_categorias.categoria_id;

-- 10 Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_cursos com os dados da tabela tb_categorias,
-- onde traga apenas os produtos que pertençam a uma categoria específica (Exemplo: Todes os cursos que pertencem a categoria Java).

SELECT * FROM tb_cursos inner join tb_categorias on tb_cursos.categoria_id = tb_categorias.categoria_id
WHERE tb_categorias.nome = 'Programação';

