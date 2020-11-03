/*
Enter your query here.
*/
SELECT DISTINCT CITY FROM STATION WHERE NOT LOWER(RIGHT(CITY, 1)) in ('a','e','i','o','u') OR NOT LOWER(LEFT(CITY, 1)) in ('a','e','i','o','u');
