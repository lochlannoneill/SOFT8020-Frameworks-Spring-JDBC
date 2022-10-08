create table director (
    directorId int primary key,
    fname varchar(30),
    lname varchar(30),
    stillActive boolean
);

create table movie (
    movieId int primary key,
    title varchar(64),
    date_released varchar(32),
    earnings double,
    directorId int--make this a foreign key
);
