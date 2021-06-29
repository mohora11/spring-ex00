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


