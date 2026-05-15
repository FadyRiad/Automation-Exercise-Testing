-- ============================================
-- Sakila DB QA - 01: Data Volume Validation
-- ============================================

USE sakila;

-- TC01: Table sizes overview
SELECT table_name, table_rows
FROM information_schema.tables
WHERE table_schema = 'sakila'
ORDER BY table_rows DESC;

-- TC02: Core entity counts
SELECT 'film' AS entity, COUNT(*) AS total FROM film
UNION ALL SELECT 'actor', COUNT(*) FROM actor
UNION ALL SELECT 'customer', COUNT(*) FROM customer
UNION ALL SELECT 'rental', COUNT(*) FROM rental
UNION ALL SELECT 'payment', COUNT(*) FROM payment;

-- TC03: Duplicate actors check
SELECT first_name, last_name, COUNT(*) AS occurrences
FROM actor
GROUP BY first_name, last_name
HAVING COUNT(*) > 1;

-- TC04: Duplicate film titles
SELECT title, COUNT(*) AS occurrences
FROM film
GROUP BY title
HAVING COUNT(*) > 1;

-- TC05: Duplicate actor-film relationships
SELECT actor_id, film_id, COUNT(*) AS cnt
FROM film_actor
GROUP BY actor_id, film_id
HAVING COUNT(*) > 1;

-- TC06: Top actors by film count
SELECT actor_id, COUNT(film_id) AS films_count
FROM film_actor
GROUP BY actor_id
ORDER BY films_count DESC
LIMIT 10;