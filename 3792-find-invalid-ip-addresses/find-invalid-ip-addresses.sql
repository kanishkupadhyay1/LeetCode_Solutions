SELECT ip, COUNT(*) AS invalid_count
FROM logs
WHERE 
    ip NOT REGEXP '^[0-9]+(\\.[0-9]+){3}$'
    OR ip REGEXP '(^|\\.)0[0-9]+'
    OR ip REGEXP '(^|\\.)([0-9]{4,})'
    OR EXISTS (
        SELECT 1
        FROM (
            SELECT 
                SUBSTRING_INDEX(SUBSTRING_INDEX(ip,'.',1),'.',-1) AS p1,
                SUBSTRING_INDEX(SUBSTRING_INDEX(ip,'.',2),'.',-1) AS p2,
                SUBSTRING_INDEX(SUBSTRING_INDEX(ip,'.',3),'.',-1) AS p3,
                SUBSTRING_INDEX(ip,'.',-1) AS p4
        ) t
        WHERE p1 > 255 OR p2 > 255 OR p3 > 255 OR p4 > 255
    )
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;