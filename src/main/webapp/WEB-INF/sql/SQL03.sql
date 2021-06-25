SELECt * FROM tbl_board
order by bno desc;

-- 제목 검색
SELECT * FROM tbl_board
WHERE title LIKE '%자바%'
ORDER BY bno DESC
LIMIT 0, 10;

-- 제목 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%자바%'
OR content LIKE '%자바%'
ORDER BY bno DESC
LIMIT 0, 10;

-- 제목 본문 작성자 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%자바%'
OR content LIKE '%자바%'
OR writer LIKE '%자바%'
ORDER BY bno DESC
LIMIT 0, 10;

-- CONCAT 함수
SELECT CONCAT('a', 'b');
SELECT CONCAT('a', 'java', 'b');
SELECT 'a' + 'b'; -- 이게 안되서 위에꺼 씀
SELECT 'a' || 'b'; -- 오라클