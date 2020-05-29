insert into pessoa(id, nome, tipo, nascimento) values (1, 'João', 'PRETENDENTE', '1958-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (2, 'Maria', 'DEPENDENTE', '1989-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (3, 'José', 'DEPENDENTE', '2015-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (4, 'Angela', 'DEPENDENTE', '2015-12-3')

insert into pessoa(id, nome, tipo, nascimento) values (5, 'Isadora', 'PRETENDENTE', '19992-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (6, 'Isabela', 'DEPENDENTE', '1982-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (7, 'Isabel', 'DEPENDENTE', '1999-12-30')
insert into pessoa(id, nome, tipo, nascimento) values (8, 'Isaura', 'DEPENDENTE', '2013-12-3')

insert into renda(id, valor, pessoa) values (1, 150, 1)
insert into renda(id, valor, pessoa) values (2, 200, 2)
insert into renda(id, valor, pessoa) values (3, 0, 3)
insert into renda(id, valor, pessoa) values (4, 0, 4)

insert into renda(id, valor, pessoa) values (5, 2200, 5)
insert into renda(id, valor, pessoa) values (6, 850, 6)
insert into renda(id, valor, pessoa) values (7, 680, 7)
insert into renda(id, valor, pessoa) values (8, 500, 8)

insert into status_familia(id, tipo, status) values (1, '0', 'Cadastro válido')
insert into status_familia(id, tipo, status) values (2, '1', 'Já possui uma casa')
insert into status_familia(id, tipo, status) values (3, '2', 'Selecionada em outro processo de seleção')
insert into status_familia(id, tipo, status) values (4, '3', 'Cadastro incompleto')
