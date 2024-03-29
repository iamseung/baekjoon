WITH RECURSIVE T (HOUR) AS
(
    SELECT 0
    UNION ALL
    SELECT HOUR + 1 FROM T WHERE HOUR < 23
)

SELECT t.HOUR AS HOUR, COUNT(a.ANIMAL_ID) AS COUNT
FROM T t
LEFT JOIN ANIMAL_OUTS a
ON t.HOUR = HOUR(a.DATETIME)
GROUP BY HOUR
ORDER BY HOUR ASC