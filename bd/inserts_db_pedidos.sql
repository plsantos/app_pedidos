use pedidos;


insert into produto (descricao, unidade_medida, valor_unitario, status) values('Mesa Quadrada', '1 metro',250.00, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Toalha de mesa Quadrada', '2 metros',80.00, true);
insert into produto (descricao, unidade_medida, valor_unitario, status) values('Prato decoração redondo', '40cm',120.00, true);

desc produto;
select * from produto;

insert into cliente (tipo, documento, nome) values('PF', '03773748908','Carlos Alberto');
select * from cliente;


insert into pedido (data, rua, numero, bairro, cidade, cep, cliente_id) values('2021-11-04', 'Rua Manga Rosa','18','Arvoreiro', 'Mangabeira', '20555580', 1);
select * from pedido;

insert into itens_pedido (pedido_idpedido, produto_id, quantidade, valor_total) values(1,1,2, 500.01);
select * from itens_pedido;

alter table pedido modify column cidade varchar(40) not null;
alter table produto modify column valor_unitario double(5,2) not null;


desc pedido;