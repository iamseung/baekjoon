SELECT 
    YEAR(SALES_DATE) AS YEAR,
    MONTH(SALES_DATE) AS MONTH, 
    COUNT(distinct USER_ID) AS puchased_users,
    # 구매 비율
    ROUND(count(distinct USER_ID) / (SELECT count(*) FROM USER_INFO WHERE YEAR(JOINED)=2021),1) 
    AS puchased_ratio
FROM ONLINE_SALE 
WHERE USER_ID IN (select USER_ID from USER_INFO WHERE YEAR(JOINED) = 2021)
GROUP BY YEAR(SALES_DATE),MONTH(SALES_DATE)
ORDER BY YEAR,MONTH