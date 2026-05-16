USE sakila;
-- count validation
select 'actor'        as tbl, count(*) as total from actor
union all select 'film',          count(*) from film
union all select 'customer',      count(*) from customer
union all select 'rental',        count(*) from rental
union all select 'payment',       count(*) from payment
union all select 'inventory',     count(*) from inventory
union all select 'staff',         count(*) from staff
union all select 'store',         count(*) from store
union all select 'category',      count(*) from category
union all select 'address',       count(*) from address
union all select 'city',          count(*) from city
union all select 'country',       count(*) from country
union all select 'language',      count(*) from language;

-- duplicates
select 'actor'        as tbl, count(*) - count(distinct concat(first_name, last_name)) as dups from actor
union all select 'film',       count(*) - count(distinct title)                                  from film
union all select 'film_actor', count(*) - count(distinct concat(film_id, actor_id))              from film_actor
union all select 'customer',   count(*) - count(distinct concat(first_name, last_name, email))   from customer
union all select 'category',   count(*) - count(distinct name)                                   from category
union all select 'language',   count(*) - count(distinct name)                                   from language
union all select 'city',       count(*) - count(distinct city)                                   from city
union all select 'country',    count(*) - count(distinct country)                                from country
union all select 'rental',     count(*) - count(distinct rental_id)                              from rental
union all select 'payment',    count(*) - count(distinct payment_id)                             from payment
union all select 'inventory',  count(*) - count(distinct inventory_id)                           from inventory
union all select 'staff',      count(*) - count(distinct email)                                  from staff
union all select 'store',      count(*) - count(distinct store_id)                               from store;

-- null checks
select 'actor > name'          as field, count(*) as nulls from actor     where first_name  is null or last_name    is null
union all select 'address > city_id',     count(*) from address   where city_id     is null or address     is null
union all select 'city > country_id',     count(*) from city      where country_id  is null or city        is null
union all select 'customer > email',      count(*) from customer  where first_name  is null or last_name   is null or email is null or address_id is null
union all select 'film > title/lang',     count(*) from film      where title       is null or language_id is null or rental_rate is null
union all select 'inventory > fks',       count(*) from inventory where film_id     is null or store_id    is null
union all select 'payment > fks',         count(*) from payment   where customer_id is null or staff_id    is null or amount is null or rental_id is null
union all select 'rental > fks',          count(*) from rental    where customer_id is null or inventory_id is null or staff_id is null
union all select 'staff > fks',           count(*) from staff     where address_id  is null or store_id    is null
union all select 'store > fks',           count(*) from store     where address_id  is null or manager_staff_id is null
union all select 'language > name',       count(*) from language  where name        is null
union all select 'category > name',       count(*) from category  where name        is null
union all select 'country > name',        count(*) from country   where country     is null;

select count(*) as still_rented from rental where return_date is null;

-- constraint checks
delete from actor    where actor_id    = 1;  
delete from film     where film_id     = 1;  
delete from customer where customer_id = 1;  
delete from language where language_id = 1;  
delete from city     where city_id     = 1;  
delete from country  where country_id  = 1;  

insert into rental  (rental_date, inventory_id, customer_id, staff_id)
values (now(), 1, 99999, 1);                

insert into payment (customer_id, staff_id, rental_id, amount, payment_date)
values (1, 1, 99999, 5.99, now());           
