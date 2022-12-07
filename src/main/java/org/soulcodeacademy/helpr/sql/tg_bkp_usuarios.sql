create database db_bkp_full_usuarios;

create table db_bkp_full_usuarios.table_bkp_usuarios_full(
	idBkp_usuarios_full integer primary key auto_increment,
    dtype_bkp_full varchar(31) not null,
    id_bkp_full integer,
    cpf_bkp_full varchar(11) unique not null,
    email_bkp_full varchar(120) unique not null,
    nome_bkp_full varchar(120) not null,
    perfil_bkp_full varchar(255) not null,
    senha_bkp_full varchar(255) not null,
    telefone_bkp_full varchar(25),
    foto_bkp_full varchar(255),
    idCargo_bkp_full integer
);

desc usuarios;

use helpr;

drop table table_bkp_usuarios_full;

drop trigger usuarios_bkp_full;

delimiter //

create trigger usuarios_bkp_full
after update on usuarios
for each row
begin
	insert into db_bkp_full_usuarios.table_bkp_usuarios_full (idBkp_usuarios_full, dtype_bkp_full, id_bkp_full, cpf_bkp_full, email_bkp_full, nome_bkp_full, perfil_bkp_full, senha_bkp_full, telefone_bkp_full, foto_bkp_full, idCargo_bkp_full) values (null, old.dtype, old.id, old.cpf, old.email, old.nome, old.perfil, old.senha, old.telefone, old.foto, old.id_cargo);
end//

delimiter ;

select * from usuarios;

select * from db_bkp_full_usuarios.table_bkp_usuarios_full;

update usuarios set dtype = 'dataScience' where id = 1;
update usuarios set email = 'datascience@soulcode.com' where id = 2;
UPDATE usuarios SET dtype = 'Dono' WHERE id = 2;





