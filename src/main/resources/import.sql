-- Inserir dados na tabela Pessoa (incluindo Médicos e Pacientes)
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Medico', '123456789', 'Claudio', NULL);
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Paciente', NULL, 'Brendo', '12345-6789');
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Medico', '987654321', 'Flavia', NULL);
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Paciente', NULL, 'Nicoly', '98765-4321');
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Medico', '777777777', 'Nelma', NULL);
INSERT INTO Pessoa (Tipo_Pessoa, CRM, Nome, Telefone) VALUES('Paciente', NULL, 'Jhuly', '88888-8888');

-- Inserir dados na tabela Consulta (considerando que os pacientes e médicos foram criados anteriormente)
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(1, 2, 100.0, '2023-11-07', 'Gripado');
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(3, 4, 50.0, '2023-09-10', 'Febre');
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(5, 6, 75.0, '2023-04-30', 'Desnutrição');
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(3, 2, 70.0, '2024-01-30', 'Dengue');
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(1, 4, 65.0, '2024-04-25', 'Chikungunya');
INSERT INTO Consulta (Id_Medico, Id_Paciente, Valor, Data, Observacao) VALUES(5, 6, 20.0, '2024-05-01', 'Verme');