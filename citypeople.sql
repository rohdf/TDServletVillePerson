DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;

CREATE TABLE country (
        id_pays INT NOT NULL AUTO_INCREMENT,
        name VARCHAR (50),
        president VARCHAR(100),
        inhabitants INT,
       PRIMARY KEY(id_pays),
       INDEX pays_name (name)
)engine=innodb ;

CREATE TABLE city (
        id_city INT NOT NULL AUTO_INCREMENT,
        id_pays INT,
        name VARCHAR (50),
        mayor VARCHAR(100),
        inhabitants INT,
        postalcode INT(6),
               FOREIGN KEY pays_city (id_pays) references country  (id_pays) ON DELETE CASCADE ,
       PRIMARY KEY(id_city),
       INDEX city_name (name)
)engine=innodb ;

CREATE TABLE person (
        id_person INT NOT NULL AUTO_INCREMENT,
        id_city INT,
        firstname VARCHAR (50),
        lastname VARCHAR (50),
        emails VARCHAR(100),
        phone VARCHAR(20),
	date_naissance date,
       PRIMARY KEY(id_person),
       FOREIGN KEY person_city (id_city) references city (id_city) ON DELETE SET null,
       INDEX person_lastname(lastname)
)engine=innodb;


insert into country values (0,'Le Vieil Empire', 'La Reine', 1000000);
insert into country values (0,'Hexagone', 'Le Président', 10000000);


insert into city values (0, 1, 'Longbourn', 'Lord Edward', 1000, 3365);
insert into city values (0, null, 'Port Royal', 'Barbe Noire', 1000, 3365);
insert into city values (0, 2, 'Yonville', 'M.Flaubert', 1000, 3365);
insert into city values (0, 1, 'Buckshaw', 'Colonel de Luce', 1000, 3365);

insert into person values (0, null, 'Elizabeth', 'Bennet', 'lizzy_s_prejudice@devon.evon.shire.uk', '088 377 999', '1732-05-12');
insert into person values (0, 3, 'Emma','Bovary' , 'arsenic_romantique@fleurbleue.fr', '01 54 54 54 70', '1828-07-08');
insert into person values (0, 4, 'Flavia', 'de Luce', 'gladys@buckshaw.uk', '333 845 732', '1951-09-25');
insert into person values (0, 4, 'Ophelia', 'de Luce', 'hatemysister@buckshaw.uk', '333 845 732', '1948-02-02');


