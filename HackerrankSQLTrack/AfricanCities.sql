SELECT c.NAME FROM CITY c JOIN COUNTRY ct on c.COUNTRYCODE = ct.CODE WHERE ct.CONTINENT = 'Africa';