CREATE TABLE biblias(
    id SERIAL PRIMARY KEY,
    versao VARCHAR(255)
);

CREATE TABLE livros(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    id_biblia INTEGER,
        CONSTRAINT fk_livros_biblia
        FOREIGN KEY (id_biblia)
        REFERENCES biblias(id)
);

CREATE TABLE capitulos(
    id SERIAL PRIMARY KEY,
    capitulo INTEGER,
    id_livro INTEGER,
        CONSTRAINT fk_capitulos_livro
        FOREIGN KEY (id_livro)
        REFERENCES livros(id)
);

CREATE TABLE versiculos(
    id SERIAL PRIMARY KEY,
    versiculo INTEGER,
    texto VARCHAR,
    id_capitulo INTEGER,
        CONSTRAINT fk_versiculos_capitulo
        FOREIGN KEY (id_capitulo)
        REFERENCES capitulos(id)
);

CREATE TABLE temas(
    id SERIAL PRIMARY KEY,
    tema VARCHAR
);

CREATE TABLE versiculo_tema(
    versiculo_id INTEGER,
    tema_id INTEGER
);


INSERT INTO biblias(versao) VALUES ('KJA');

INSERT INTO livros (nome, id_biblia)
VALUES
    ('Gênesis', 1),
    ('Êxodo', 1),
    ('Levítico', 1),
    ('Números', 1),
    ('Deuteronômio', 1),
    ('Josué', 1),
    ('Juízes', 1),
    ('Rute', 1),
    ('1 Samuel', 1),
    ('2 Samuel', 1),
    ('1 Reis', 1),
    ('2 Reis', 1),
    ('1 Crônicas', 1),
    ('2 Crônicas', 1),
    ('Esdras', 1),
    ('Neemias', 1),
    ('Ester', 1),
    ('Jó', 1),
    ('Salmos', 1),
    ('Provérbios', 1),
    ('Eclesiastes', 1),
    ('Cânticos', 1),
    ('Isaías', 1),
    ('Jeremias', 1),
    ('Lamentações', 1),
    ('Ezequiel', 1),
    ('Daniel', 1),
    ('Oséias', 1),
    ('Joel', 1),
    ('Amós', 1),
    ('Obadias', 1),
    ('Jonas', 1),
    ('Miquéias', 1),
    ('Naum', 1),
    ('Habacuque', 1),
    ('Sofonias', 1),
    ('Ageu', 1),
    ('Zacarias', 1),
    ('Malaquias', 1),
    ('Mateus', 1),
    ('Marcos', 1),
    ('Lucas', 1),
    ('João', 1),
    ('Atos', 1),
    ('Romanos', 1),
    ('1 Coríntios', 1),
    ('2 Coríntios', 1),
    ('Gálatas', 1),
    ('Efésios', 1),
    ('Filipenses', 1),
    ('Colossenses', 1),
    ('1 Tessalonicenses', 1),
    ('2 Tessalonicenses', 1),
    ('1 Timóteo', 1),
    ('2 Timóteo', 1),
    ('Tito', 1),
    ('Filemom', 1),
    ('Hebreus', 1),
    ('Tiago', 1),
    ('1 Pedro', 1),
    ('2 Pedro', 1),
    ('1 João', 1),
    ('2 João', 1),
    ('3 João', 1),
    ('Judas', 1),
    ('Apocalipse', 1);


-- Antigo Testamento

INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,50),1;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,40),2;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,27),3;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,36),4;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,34),5;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,24),6;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,21),7;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),8;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,31),9;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,24),10;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,22),11;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,25),12;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,29),13;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,36),14;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,10),15;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,13),16;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,10),17;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,42),18;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,150),19;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,31),20;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,12),21;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,8),22;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,66),23;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,52),24;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,5),25;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,48),26;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,12),27;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,14),28;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),29;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,9),30;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,1),31;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),32;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,7),33;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),34;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),35;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),36;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,2),37;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,14),38;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),39;

-- Novo Testamento

INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,28),40;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,16),41;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,24),42;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,21),43;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,28),44;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,16),45;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,16),46;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,13),47;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,6),48;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,6),49;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),50;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),51;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,5),52;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),53;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,6),54;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,4),55;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),56;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,1),57;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,13),58;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,5),59;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,5),60;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,3),61;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,5),62;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,1),63;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,1),64;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,1),65;
INSERT INTO capitulos(capitulo, id_livro) SELECT generate_series(1,22),66;

-- Inderindo versículos

INSERT INTO versiculos (versiculo, texto, id_capitulo) VALUES
(30, 'Eu e o Pai somos um.', 1039),
(3, 'E a vida eterna é esta: que te conheçam a Ti, o Único Deus verdadeiro, e a Jesus Cristo, a quem enviaste.', 1046),
(6, 'para nós, contudo, há um único Deus, o Pai, de quem tudo procede e para quem vivemos; em um só Senhor, Jesus Cristo, por intermédio de quem tudo o que há veio a existir, e por meio de quem também vivemos.', 1102),
(5, 'Porque há um só Deus e um só Mediador entre Deus e o ser humano, Cristo Jesus, homem.', 1143),
(13, 'Entretanto, ninguém ao ser tentado deverá dizer: "Estou sendo tentado por Deus". Ora, Deus não pode ser tentado pelo mal, e a nenhuma pessoa tenta.', 1171);

--Temas

INSERT INTO temas(tema)VALUES
('Unitarismo'),
('Guarda do Sábado');

--Relação entre tema e versiculo
INSERT INTO versiculo_tema (versiculo_id, tema_id) VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(5,1);

