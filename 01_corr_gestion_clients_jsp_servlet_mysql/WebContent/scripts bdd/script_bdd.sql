create database if not exists db_jsp_servlet;

create table clients (  id_client integer primary key auto_increment,
					    nom varchar(50),
                        prenom varchar(50),
                        adresse varchar(50),
                        ville varchar(50),
                        code_postal varchar(50),
                        telephone varchar(50)
					  );
                      
create table conseiller ( id_conseiller integer primary key auto_increment,
					      nom varchar(50),
                          mail varchar(50),
                          mot_de_passe varchar(50)
					  );
                      

INSERT INTO `db_jsp_servlet`.`clients` (`nom`, `prenom`, `adresse`, `ville`, `code_postal`, `telephone`) VALUES ('Arsenault', 'Alexandrin ', '41, rue Descartes', '67200', 'STRASBOURG', '0354653248');
INSERT INTO `db_jsp_servlet`.`clients` (`nom`, `prenom`, `adresse`, `ville`, `code_postal`, `telephone`) VALUES ('Caouette', 'Forrest', '27, rue Marguerite', '94350', 'VILLIERS-SUR-MARNE', '0106546837');

INSERT INTO `db_jsp_servlet`.`conseiller` (`nom`, `mail`, `mot_de_passe`) VALUES ('Madeleine Chauvin', 'MadeleineChauvin@teleworm.us', 'peiw0eeSoo');
