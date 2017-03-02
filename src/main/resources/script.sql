-- 
set @cnt = 0;
insert into Atributo
select (@cnt:=@cnt+1) as id, a.nome, '' as valor from atributo a;



set @cnt = 0;
select (@cnt:=@cnt+1), c.nome, c.hierarquia from categoria c order by c.hierarquia;

