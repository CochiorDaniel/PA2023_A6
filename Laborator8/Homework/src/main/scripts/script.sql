CREATE TABLE dbpa;

CREATE TABLE albums (
  id int not null primary key auto_increment,
  release_year varchar(25),
  title varchar(25) ,
  artist varchar(25),
);

CREATE TABLE artists (
  id int primary key auto_increment,
  name varchar(25),
);

CREATE TABLE genres (
  name varchar(25),
  id int primary key auto_increment
);

CREATE TABLE bonds (
    id_album  INT NOT NULL,
    id_genre  INT NOT NULL,
    CONSTRAINT id_album FOREIGN KEY (id_album)
    REFERENCES albums(id),
    CONSTRAINT id_genre FOREIGN KEY (id_genre)
    REFERENCES genre(id)
);