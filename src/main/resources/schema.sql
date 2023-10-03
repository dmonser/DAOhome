create schema netology;

create table netology.CUSTOMERS(
    id bigserial primary key,
    "name" varchar(255) not null,
    surname varchar(255) not null,
    age int not null,
    phone_number varchar(15)
);

create table netology.ORDERS(
    id bigserial primary key,
    "date" varchar(255),
    customer_id int not null references netology.customers (id),
    product_name varchar(255) not null,
    amount int not null
);