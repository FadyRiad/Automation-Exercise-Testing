-- Count Validation
USE sakila;

SELECT * FROM actor;

USE sakila;

SELECT COUNT(*) AS total_actors
FROM actor;

SELECT COUNT(*) AS total_films
FROM film;

-- Null Checks

SELECT *
FROM actor
WHERE first_name IS NULL
OR last_name IS NULL;

SELECT *
FROM customer
WHERE email IS NULL;


-- Constraint Check


DELETE FROM actor
WHERE actor_id = 1;