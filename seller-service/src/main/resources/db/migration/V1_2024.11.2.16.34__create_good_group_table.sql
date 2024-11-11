CREATE TABLE IF NOT EXISTS good_category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO good_category (name) VALUES
    ('Электроника'),
    ('Одежда'),
    ('Дом и сад'),
    ('Книги'),
    ('Игрушки и хобби'),
    ('Мебель'),
    ('Автомобильные товары'),
    ('Красота и здоровье'),
    ('Спорт и отдых'),
    ('Продукты питания');
