create table homework.ORDERS_1 (
                                   id serial primary key,
                                   date timestamptz,
                                   customer_id int,
                                   product_name varchar,
                                   amount int,
                                   foreign key (customer_id) references homework.CUSTOMERS_1(id)
);