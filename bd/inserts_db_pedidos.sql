use pedidos;

INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME)VALUES('pf','123456','natasha');
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME)VALUES('pf','123562','Carol');
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME)VALUES('pj','123455556','Paula');
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME)VALUES('pf','562486','Giovanna');

INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO,VALOR_TOTAL,BAIRRO,ESTADO,CEP,CIDADE,NUMERO,RUA)VALUES('2021-01-01',1,TRUE,100,'teste','123','teste','teste','teste','12345-000');
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO,VALOR_TOTAL,BAIRRO,ESTADO,CEP,CIDADE,NUMERO,RUA)VALUES('2022-01-01',2,FALSE,200,'Federação','40230109','Salvador','bahia','168','Mata Maroto');
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO,VALOR_TOTAL,BAIRRO,ESTADO,CEP,CIDADE,NUMERO,RUA)VALUES('2021-04-01',3,TRUE,300,'Alto das Pombas','40230109','Salvador','bahia','16','Sobradinho');
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO,VALOR_TOTAL,BAIRRO,ESTADO,CEP,CIDADE,NUMERO,RUA)VALUES('2019-01-21',4,FALSE,400,'Cabula','40230111','Salvador','bahia','160','Sergio de Carvalho');

drop table produto;
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Orgulho e preconceito, Autor: Jane Austen',45.13,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Ruínas de Minaster, Autor: Raianne Viana',49.90,FALSE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Hibisco roxo, Autor: Chimamanda Ngozi Adichie',28.90,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Harry Potter, Autor: JK.Rowling',29.92,FALSE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('O menino do dedo verde, Autor: Maurice Duron', 32.98,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('A batalha do apocalipse, Autor: Eduardo Spohr', 32.90,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('O penultimo olhar, Autor: Miró da Muribeca', 35.00,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Pedagogia da autonomia, Autor: Paulo Freire', 19.95,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('O Pequeno Príncipe, Autor: A. Saint-Exupéry;', 24.90,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Adivinhe Se Puder, Autor: Eva Furnari', 35.94,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Jardim secreto, Autor: Johanna Basford', 21.89,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Bleach - vol. 1, Autor: Tite Kubo', 48.99,TRUE);
select * from produto;

INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID,VALOR_TOTAL)VALUES(1,1,1,23.50);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID,VALOR_TOTAL)VALUES(4,2,2,500);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID,VALOR_TOTAL)VALUES(3,3,3,400);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID,VALOR_TOTAL)VALUES(2,4,4,500);

select * from CLIENTE e ;
select * from PEDIDO e ;
select * from PRODUTO e ;
select * from ITENS_PEDIDO e ;