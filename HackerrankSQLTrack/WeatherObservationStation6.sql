/*
Enter your query here.
*/
SELECT CITY FROM STATION WHERE LOWER(LEFT(CITY,1)) IN ('a','e','i','o','u');
