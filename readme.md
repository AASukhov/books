# Тестовое задание

База данных с таблицей book:

```
create table book (
    id number not null,
    title varchar2(150) not null,
    author varchar2(150) not null,
    description varchar2(150),
    constraint book_pk primary key(id)
);
```

Тестовые данные:
```
insert into book (id, title, author, description)
values (1, 'Crime and Punishment', 'F. Dostoevsky', null),
       (2, 'Anna Karenina', 'L. Tolstoy', null),
       (3, 'The Brothers Karamazov', 'F. Dostoevsky', null),
       (4, 'War and Peace', 'L. Tolstoy', null),
       (5, 'Dead Souls', 'N. Gogol', null);
```

Необходимо реализовать контроллер с 4мя endpoints:

1. endpoint, возвращающий список всех книг, которые содержатся в таблице book, отсортированный в обратном алфавитном 
   порядке значения колонки book.title;
2. endpoint добавления новой книги в таблицу book;
3. endpoint, возвращающий список всех книг, сгруппированных по автору книги (book.author);

База данных PostgreSQL инициируется при помощи flyway.

Тестирование:
1. GET запрос - http://localhost:8081/books/list-reversed - выводит список книг из базы данных в обратном алфавитном 
   порядке значения колонки book.title в формате JSON;
2. GET запрос - http://localhost:8081/books/list - выводит список книг из базы данных в формате JSON;
3. POST запрос - http://localhost:8081/books/new - добавляет новую книгу в таблицу book: 
   
@RequestBody (корректное тело запроса):
```
{
  "id" : "6",
  "title" : "Gens",
  "author" : "L. Tolstoy",
  "description" : null
}
```
Ответ: 200 OK - New book successfully added

@RequestBody (некорректное тело запроса):
```
{
  "id" : "7",
  "title" : "Gens",
  "description" : null
}
```
Ответ: 400 BAD REQUEST - An error occurred while adding new book;

4. GET запрос - http://localhost:8081/books/group-by-author - выводит список книг, сгруппированных по автору книги 
   book.author (при помощи stream API);