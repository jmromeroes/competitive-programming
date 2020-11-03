/*
Enter your query here.
*/
SELECT DISTINCT CITY from STATION WHERE NOT (LOWER(RIGHT(CITY, 1)) IN ('a', 'e', 'i', 'o', 'u') OR LOWER(LEFT(CITY, 1)) IN ('a', 'e', 'i', 'o', 'u'));
