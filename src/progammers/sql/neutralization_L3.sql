SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS as i
         INNER JOIN ANIMAL_OUTS as o
                    ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE (i.SEX_UPON_INTAKE LIKE "%Intact%")
  AND (o.SEX_UPON_OUTCOME LIKE "%Spayed%" OR
       o.SEX_UPON_OUTCOME LIKE "%Neutered%")
ORDER BY i.ANIMAL_ID asc