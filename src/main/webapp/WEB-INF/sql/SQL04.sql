use spr1;

desc tbl_board;

CREATE TABLE tbl_reply (
	rno INT PRIMARY KEY AUTO_INCREMENT,
    bno INT NOT NULL,
    reply VARCHAR(512) NOT NULL,
    replyer VARCHAR(50) NOT NULL,
    replyDate TIMESTAMP DEFAULT NOW(),
    updateDate TIMESTAMP DEFAULT NOW(),
	FOREIGN KEY (bno) REFERENCES tbl_board(bno)
);

Select * FROM tbl_board
ORDER BY bno desc;

SELECT * FROM tbl_reply
ORDER BY rno DESC;

UPDATE tbl_reply
SET reply = "수정된 댓글"
WHERE rno = 4;

-- 댓글이 잇는 게시물 조회
SELECT
 DISTINCT (b.bno)
FROM tbl_board b JOIN tbl_reply r ON b.bno = r. bno;


