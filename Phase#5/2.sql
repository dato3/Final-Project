--If a client wants to know which medicine is in high demand, how can he/she do it?
SELECT * FROM featured_medicines ORDER BY number_bought DESC FETCH FIRST 5 ROWS ONLY;