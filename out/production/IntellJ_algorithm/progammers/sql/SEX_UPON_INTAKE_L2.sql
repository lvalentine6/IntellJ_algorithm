SELECT ANIMAL_ID, NAME,
       IF(SEX_UPON_INTAKE LIKE "%Neutered%" OR SEX_UPON_INTAKE LIKE "%Spayed%", "O", "X") as 중성화
FROM ANIMAL_INS