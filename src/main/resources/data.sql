CREATE TABLE if not exists car (
id int auto_increment primary key,
    name varchar(255),
    production_year int,
    color varchar(255)
);

CREATE TABLE if not exists bike (
id int auto_increment primary key,
    name varchar(255),
    years_production int
);

CREATE TABLE if not exists parking (
id int auto_increment primary key
);


--INSERT INTO car (color, name, production_year) VALUES ('green','BMW', 1999);
--INSERT INTO car (color, name, production_year) VALUES ('red','Audi', 1980);
--INSERT INTO car (color, name, production_year) VALUES ('yellow','Opel', 1994);
--INSERT INTO car VALUES (1, 'blue', 'Mercedes', 2000);

--INSERT INTO bike (id, name, years_production) VALUES (1,'Honda', 2000);
--INSERT INTO bike (id, name, years_production) VALUES (2,'Yamaha', 2010);
--INSERT INTO bike (id, name, years_production) VALUES (3,'Suzuki', 2017);
