create table director (
    director_id int primary key,
    fname varchar(30),
    lname varchar(30),
    still_active boolean
);

create table movie (
    movie_id int primary key,
    title varchar(64),
    release_data varchar(32),
    earnings double,
    director int --make this a foreign key
);
