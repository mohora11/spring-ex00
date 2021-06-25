
SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 10; -- 상위 10개

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 0, 10; -- 0번 부터 상위 10개 (1page)

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 10, 10; -- 10번부터 상위 10개 (2page)

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 20, 10; -- 20번 부터 상위 10개 (3page)

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 10 * (n-1), 10; -- (n page)