

CREATE TABLE OrdemServico (
seq int NOT NULL AUTO_INCREMENT,
data_ini varchar (10),
sla int, 
data_fim varchar(10),
status varchar(20),
id_cli int(11),
cod_tec int(11),
num_serv int,
PRIMARY KEY (seq,id_cli),
FOREIGN KEY ( id_cli) REFERENCES cliente ( id ),
FOREIGN KEY ( cod_tec) REFERENCES tecnico (cod),
FOREIGN KEY (num_serv) REFERENCES servico (num)
)
