USE sakila;

-- TC01: Count all main tables
SELECT 'actor'     AS table_name, COUNT(*) AS total FROM actor
UNION ALL SELECT 'film',          COUNT(*) FROM film
UNION ALL SELECT 'customer',      COUNT(*) FROM customer
UNION ALL SELECT 'rental',        COUNT(*) FROM rental
UNION ALL SELECT 'payment',       COUNT(*) FROM payment
UNION ALL SELECT 'inventory',     COUNT(*) FROM inventory
UNION ALL SELECT 'staff',         COUNT(*) FROM staff
UNION ALL SELECT 'store',         COUNT(*) FROM store
UNION ALL SELECT 'category',      COUNT(*) FROM category
UNION ALL SELECT 'address',       COUNT(*) FROM address
UNION ALL SELECT 'city',          COUNT(*) FROM city
UNION ALL SELECT 'country',       COUNT(*) FROM country
UNION ALL SELECT 'language',      COUNT(*) FROM language;
-- Expected: actor=200, film=1000, customer=599, rental=16044, payment=16049

-- TC02: Check for duplicate actors (same first + last name)
SELECT first_name, last_name, COUNT(*) AS count
FROM actor
GROUP BY first_name, last_name
HAVING COUNT(*) > 1;
-- Expected: 0 rows

-- TC03: Check for duplicate films (same title)
SELECT title, COUNT(*) AS count
FROM film
GROUP BY title
HAVING COUNT(*) > 1;
-- Expected: 0 rows

-- TC04: Check for duplicate film-actor links (same actor in same film twice)
SELECT film_id, actor_id, COUNT(*) AS count
FROM film_actor
GROUP BY film_id, actor_id
HAVING COUNT(*) > 1;
-- Expected: 0 rows

-- TC05: Top 10 actors by number of films (logical range check)
SELECT a.actor_id, a.first_name, a.last_name,
       COUNT(fa.film_id) AS total_films
FROM actor a
LEFT JOIN film_actor fa ON a.actor_id = fa.actor_id
GROUP BY a.actor_id, a.first_name, a.last_name
ORDER BY total_films DESC
LIMIT 10;
-- Expected: top actors have 30-40 films

-- TC06: Top 10 customers by rental count
SELECT customer_id, COUNT(*) AS rental_count
FROM rental
GROUP BY customer_id
ORDER BY rental_count DESC
LIMIT 10;
-- Check for unusually high counts
