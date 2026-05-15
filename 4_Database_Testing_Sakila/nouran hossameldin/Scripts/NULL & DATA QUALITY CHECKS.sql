-- ============================================
-- Sakila DB QA - 02: NULL & Data Quality Checks
-- ============================================

USE sakila;

-- TC07: NULL IDs summary check
SELECT 'actor' AS table_name, SUM(actor_id IS NULL) AS null_ids FROM actor
UNION ALL
SELECT 'film', SUM(film_id IS NULL) FROM film
UNION ALL
SELECT 'customer', SUM(customer_id IS NULL) FROM customer;

-- TC08: Actor missing data
SELECT *
FROM actor
WHERE first_name IS NULL OR last_name IS NULL;

-- TC09: Film missing critical fields
SELECT *
FROM film
WHERE title IS NULL OR language_id IS NULL OR rental_rate IS NULL;

-- TC10: Rental integrity check
SELECT *
FROM rental
WHERE customer_id IS NULL
   OR inventory_id IS NULL
   OR staff_id IS NULL;

-- TC11: Payment completeness check
SELECT *
FROM payment
WHERE amount IS NULL OR payment_date IS NULL;

-- TC12: Customer completeness check
SELECT *
FROM customer
WHERE email IS NULL OR address_id IS NULL;

-- TC13: Active rentals (business valid NULL)
SELECT COUNT(*) AS active_rentals
FROM rental
WHERE return_date IS NULL;