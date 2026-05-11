-- ============================================
-- Sakila DB Testing - 03: Constraint Checks
-- ============================================
USE sakila;

-- TC14: Try to delete an actor who has films -> should FAIL with ERROR 1451
-- First verify this actor exists in film_actor
SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = 1;
SELECT COUNT(*) AS film_count FROM film_actor WHERE actor_id = 1;
-- Now attempt delete (should be blocked by FK constraint)
DELETE FROM actor WHERE actor_id = 1;
-- Expected: ERROR 1451 - Cannot delete or update a parent row: foreign key constraint fails

-- TC15: Try to delete a film that has inventory -> should FAIL with ERROR 1451
DELETE FROM film WHERE film_id = 1;
-- Expected: ERROR 1451 - film is referenced by inventory and film_actor

-- TC16: Try to delete a customer who has rentals -> should FAIL with ERROR 1451
-- First check this customer has rentals
SELECT COUNT(*) FROM rental WHERE customer_id = 1;
-- Now attempt delete
DELETE FROM customer WHERE customer_id = 1;
-- Expected: ERROR 1451 - customer_id is referenced in rental and payment tables

-- TC17: Try to insert a rental with non-existent customer_id -> should FAIL with ERROR 1452
INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id)
VALUES (NOW(), 1, 99999, 1);
-- Expected: ERROR 1452 - Cannot add child row: customer_id 99999 does not exist

-- TC18: Try to insert a payment with non-existent rental_id -> should FAIL with ERROR 1452
INSERT INTO payment (customer_id, staff_id, rental_id, amount, payment_date)
VALUES (1, 1, 99999, 5.99, NOW());
-- Expected: ERROR 1452 - rental_id 99999 does not exist

-- TC19: Document all FK relationships in sakila (use in your report)
SELECT 
    CONSTRAINT_NAME,
    TABLE_NAME,
    COLUMN_NAME,
    REFERENCED_TABLE_NAME,
    REFERENCED_COLUMN_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_SCHEMA = 'sakila'
  AND REFERENCED_TABLE_NAME IS NOT NULL
ORDER BY TABLE_NAME;
-- This shows all FK relationships - useful for the presentation
