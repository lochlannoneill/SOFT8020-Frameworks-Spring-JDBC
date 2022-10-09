insert into director(directorId, fname, lname, stillActive) values
    (1, 'Lochlann', 'O''Neill', true),
    (2, 'Cliona', 'McGuane', true),
    (3, 'Sean', 'McSweeney', false);

insert into movie(movieId, title, releaseDate, earnings, directorId) values
    (1, 'The Lord of the Rings: The Fellowship of the Ring', 'December 19, 2001', 897700000.0, 1),
    (2, 'The Last Samurai', 'January 9, 2004', 456800000.0, 1),
    (3, 'Kung Fu Panda', 'July 4, 2008', 631700000.0, 2),
    (4, 'Ace Ventura: Pet Detective', 'February 4, 1994', 107200000.0, 3),
    (5, 'Dumb and Dumber', 'Februaru 3, 1995', 247000000.0, 2);