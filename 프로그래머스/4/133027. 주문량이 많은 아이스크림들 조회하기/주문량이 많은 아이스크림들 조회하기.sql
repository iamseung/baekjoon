# SELECT *
# FROM FIRST_HALF f
# LEFT JOIN JULY j
# ON f.FLAVOR = j.FLAVOR


SELECT f.FLAVOR as FLAVOR
FROM FIRST_HALF f
LEFT JOIN JULY j
ON f.FLAVOR = j.FLAVOR
GROUP BY FLAVOR
ORDER BY sum(f.TOTAL_ORDER + j.TOTAL_ORDER) DESC
LIMIT 3
