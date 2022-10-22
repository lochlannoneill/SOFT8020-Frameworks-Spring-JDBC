create table director (
    directorId int primary key,
    fname varchar(30),
    lname varchar(30),
    stillActive boolean
);

create table movie (
    movieId int primary key,
    title varchar(64),
    releaseDate varchar(32),
    earnings double,
    directorId int,
    foreign key (directorId) references director (directorId) on delete cascade
);
