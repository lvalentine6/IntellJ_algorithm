SELECT DATE_FORMAT(DATETIME, "%H") as HOUR, COUNT(*) as COUNT
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME
    , "%H") >= 9
  AND DATE_FORMAT(DATETIME
    , "%H")
    < 20
GROUP BY HOUR
ORDER BY HOUR asc
