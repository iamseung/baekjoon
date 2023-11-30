SELECT u.USER_ID,u.NICKNAME, SUM(b.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD b
LEFT JOIN USED_GOODS_USER u
ON b.WRITER_ID = u.USER_ID
WHERE b.STATUS = 'DONE'
GROUP BY u.USER_ID,u.NICKNAME
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES