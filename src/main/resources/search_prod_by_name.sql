select product_name from netology.customers as C
join netology.orders as O on C.id = O.customer_id
where lower(C."name") = lower(:name);