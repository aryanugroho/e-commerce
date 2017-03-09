-- ETL
set @cnt = 0;
insert into Atributo
select (@cnt:=@cnt+1) as id, a.nome as valor from atributo a;

set @cnt = 0;
insert into Categoria
select (@cnt:=@cnt+1), c.nome from categoria c order by c.hierarquia;

select (@cnt:=@cnt+1), c.hierarquia from categoria c
where c.hierarquia is not null;

select * from categoriaatributo ca
join atributo a on a.id = ca.Atributo_Id
join categoria c on c.id = ca.Categoria_Id;


set @cnt = 0;
insert into Produto
select (@cnt:=@cnt+1), now(), p.descricao, '', p.nome, 1 from produto p;

select * from Produto;

insert into ProdutoCategoria
select pp.id, cc.id from produto p
join categoria c on p.Categoria_Id = c.id
join Categoria cc on c.nome = cc.nome
join Produto pp on pp.nome = p.nome;

select * from ProdutoCategoria;

select * from produto;

