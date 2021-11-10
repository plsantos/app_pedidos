use pedidos;


insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro Harry Potter', 'Box 5 unds',250.99, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro de Odontologia', '255 p�ginas',80.05, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro de Java', '489 p�ginas',520.88, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro matem�tica 1', '121 p�ginas',100.07, false);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro hist�ria 3 porquinhos', '40 p�ginas',25.15, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Livro culin�ria', '91 p�ginas',83.51, true);

desc produto;
select * from produto;

insert into cliente (tipo, documento, nome, rua, numero, bairro, cidade, cep) values('PF', '03773748908','Carlos Alberto', 'Rua Amarela', 12, 'Azul', 'Arco-�ris', '20000-230' );
insert into cliente (tipo, documento, nome, rua, numero, bairro, cidade, cep) values('PF', '03773748908','Carlos Alberto', 'Rua Verde', 18, 'Caramelo', 'C�u', '50333-580');

select * from cliente;


insert into pedido (data, cliente_id, situacao) values('2021-11-04', 1, false);
insert into pedido (data, cliente_id, situacao) values('2021-12-14',2, true);

select * from pedido;

insert into itens_pedido (pedido_idpedido, produto_id, quantidade, valor_total) values(1,1,2, 500.01);
select * from itens_pedido;

alter table cliente modify column cidade varchar(40) not null;
alter table cliente modify column numero int not null;

alter table pedido add column situacao boolean not null;



desc ;