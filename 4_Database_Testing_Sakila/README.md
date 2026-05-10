
# Sakila Database Testing

SQL-based validation to ensure data integrity, business logic, and relational consistency within the Sakila DB.

###  Test Documentation
Full test cases, queries, and results can be found here:
 **[Google Sheets - DB Test Report](https://docs.google.com/spreadsheets/d/1TBhbhiCqMlgPpbTm5bMNKCgZyoBHU9p6vFBWPujjdIY/edit?pli=1&gid=0#gid=0)**

---

###  Folder Contents
- **Scripts**: SQL files containing the test queries.
- **Screenshots**: Execution evidence and output results.

###  Test Scenarios
- **Data Integrity**: Blocking invalid Customer/Staff IDs (FK Constraints).
- **Automation**: Verifying automatic `rental_date` generation.
- **Business Logic**: Ensuring `return_date` is not before `rental_date`.
- **Relational Consistency**: Checking for orphan records in rentals and inventory.

---
*Developed by Fady Riad*
