
CREATE TABLE endereco (
id int(11),
logradouro varchar (50),
numero int, 
bairro varchar(50),
cidade varchar(50),
estado varchar(50),
FOREIGN KEY ( id ) REFERENCES cliente ( id ) 
)