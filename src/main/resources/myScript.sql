select product_name
from homework.orders_1 o
         inner join homework.customers_1 c on o.customer_id = c.id
where lower(c."name") =