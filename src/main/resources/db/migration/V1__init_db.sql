CREATE TABLE IF NOT EXISTS book (
    id INTEGER NOT NULL,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    description VARCHAR(150),
    PRIMARY KEY (id)
);

INSERT INTO book (id, title, author, description)
VALUES (1, 'Crime and Punishment', 'F. Dostoevsky', null),
       (2, 'Anna Karenina', 'L. Tolstoy', null),
       (3, 'The Brothers Karamazov', 'F. Dostoevsky', null),
       (4, 'War and Peace', 'L. Tolstoy', null),
       (5, 'Dead Souls', 'N. Gogol', null);