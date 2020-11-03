SELECT ct.continent, FLOOR(AVG(c.population)) FROM COUNTRY ct JOIN CITY c on c.CountryCode = ct.Code Group BY ct.continent;
