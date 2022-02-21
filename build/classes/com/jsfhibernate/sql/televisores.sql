/* SQL Command To Create Database */
CREATE DATABASE IF NOT EXISTS jsfhibercrud;

/* SQL Command To Use The Database */
USE jsfhibercrud;

/* DROP Any Exisiting Table In The Database With Name As "Student" */
DROP TABLE IF EXISTS televisor;

/* SQL Command To Create The Table In A Database */
CREATE TABLE televisor (
	id int NOT NULL,
	Tipo VARCHAR(100) NOT NULL,
	So VARCHAR(100) NOT NULL,
	Preco float NOT NULL,
	Tamanho int NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
