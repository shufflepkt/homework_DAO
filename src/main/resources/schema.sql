create table homework.CUSTOMERS_1 (
                                    id serial primary key,
                                    name varchar(50),
                                    surname varchar(50),
                                    age int,
                                    phone_number varchar(50)
);

create table homework.ORDERS_1 (
                                 id serial primary key,
                                 date timestamptz,
                                 customer_id int,
                                 product_name varchar,
                                 amount int,
                                 foreign key (customer_id) references homework.CUSTOMERS_1(id)
);