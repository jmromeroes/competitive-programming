/*
Enter your query here.
*/
SELECT CITY FROM STATION WHERE LOWER(LEFT(CITY, 1)) in ('a','e','i','o','u') AND LOWER(RIGHT(CITY, 1)) in ('a','e','i','o','u');
