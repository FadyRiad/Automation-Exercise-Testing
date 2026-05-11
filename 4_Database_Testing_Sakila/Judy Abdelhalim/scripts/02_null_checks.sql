-- ============================================
-- Sakila DB Testing - 02: NULL Checks
-- ============================================

USE sakila;

-- TC07: NULL check on all primary keys
SELECT 'actor'     AS tbl, COUNT(*) AS null_pks FROM actor     WHERE actor_id IS NULL
UNION ALL SELECT 'film',     COUNT(*) FROM film      WHERE film_id IS NULL
UNION ALL SELECT 'customer', COUNT(*) FROM customer  WHERE customer_id IS NULL
UNION ALL SELECT 'rental',   COUNT(*) FROM rental    WHERE rental_id IS NULL
UNION ALL SELECT 'payment',  COUNT(*) FROM payment   WHERE payment_id IS NULL
UNION ALL SELECT 'inventory',COUNT(*) FROM inventory WHERE inventory_id IS NULL
UNION ALL SELECT 'staff',    COUNT(*) FROM staff     WHERE staff_id IS NULL
UNION ALL SELECT 'store',    COUNT(*) FROM store     WHERE store_id IS NULL;
-- Expected: all 0

-- TC08: NULL check on FKs in film_actor
SELECT * FROM film_actor
WHERE actor_id IS NULL OR film_id IS NULL;
-- Expected: 0 rows

-- TC09: NULL check on FKs in rental
SELECT * FROM rental
WHERE customer_id IS NULL
   OR inventory_id IS NULL
   OR staff_id IS NULL;
-- Expected: 0 rows

-- TC10: NULL check on FKs in payment
SELECT * FROM payment
WHERE customer_id IS NULL
   OR rental_id IS NULL
   OR staff_id IS NULL
   OR amount IS NULL;
-- Expected: 0 rows

-- TC11: NULL check on customer required fields
SELECT customer_id, first_name, last_name, email, address_id
FROM customer
WHERE first_name IS NULL
   OR last_name IS NULL
   OR address_id IS NULL;
-- Expected: 0 rows

-- TC12: NULL check on film required fields
SELECT film_id, title, language_id, rental_duration, rental_rate
FROM film
WHERE title IS NULL
   OR language_id IS NULL
   OR rental_duration IS NULL
   OR rental_rate IS NULL;
-- Expected: 0 rows

-- TC13: Count currently rented films (return_date IS NULL - this is normal)
SELECT COUNT(*) AS currently_rented
FROM rental
WHERE return_date IS NULL;
-- Note: NULL return_date = film not returned yet. This is expected behavior.
