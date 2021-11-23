use pedidos;

INSERT INTO ENDERECO(BAIRRO, CEP,CIDADE ,NUMERO,RUA)VALUES('teste','123','teste','teste','12345-000');
INSERT INTO ENDERECO(BAIRRO, CEP,CIDADE ,NUMERO,RUA)VALUES('Federação','40230109','Salvador','168','Mata Maroto');
INSERT INTO ENDERECO(BAIRRO, CEP,CIDADE ,NUMERO,RUA)VALUES('Alto das Pombas','40230109','Salvador','16','Sobradinho');
INSERT INTO ENDERECO(BAIRRO, CEP,CIDADE ,NUMERO,RUA)VALUES('Cabula','40230111','Salvador','160','Sergio de Carvalho');


INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME,ENDERECO_ID)VALUES('pf','123456','natasha',1);
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME,ENDERECO_ID)VALUES('pf','123562','Carol',2);
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME,ENDERECO_ID)VALUES('pj','123455556','Paula',3);
INSERT INTO CLIENTE(TIPO,DOCUMENTO,NOME,ENDERECO_ID)VALUES('pf','562486','Giovanna',4);

INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO)VALUES('2021-01-01',1,TRUE);
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO)VALUES('2022-01-01',2,FALSE);
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO)VALUES('2021-04-01',3,TRUE);
INSERT INTO PEDIDO(DATA,CLIENTE_ID,SITUACAO)VALUES('2019-01-21',4,FALSE);

INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('livro44444',30.50,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Um Dia',50.00,FALSE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Gabriela',20.00,TRUE);
INSERT INTO PRODUTO(DESCRICAO,VALOR,STATUS)VALUES('Cerimônia Mortal',30.50,FALSE);

INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID)VALUES(1,1,1);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID)VALUES(4,2,2);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID)VALUES(3,3,3);
INSERT INTO ITENS_PEDIDO(QUANTIDADE_PRODUTO,PRODUTO_ID,PEDIDO_ID)VALUES(2,4,4);


select * from endereco e ;
select * from CLIENTE e ;
select * from PEDIDO e ;
select * from PRODUTO e ;
select * from ITENS_PEDIDO e ;