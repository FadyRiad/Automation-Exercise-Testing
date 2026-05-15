-- ============================================
-- TC14: Delete Actor Constraint Test
-- ============================================

USE sakila;

-- Action: Try to delete a referenced actor
DELETE FROM actor
WHERE actor_id = 2;

-- Expected Result:
-- Delete should FAIL due to foreign key constraint (film_actor table)

-- Actual Result:
-- Error Code: 1451
-- Cannot delete or update a parent row:
-- a foreign key constraint fails (`sakila`.`film_actor`)

-- Test Result: PASS
-- Conclusion: Referential integrity is enforced correctly (ON DELETE RESTRICT)