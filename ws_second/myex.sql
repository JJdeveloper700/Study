-- myex 데이터 베이스 (2024.11.27 생성)
-- 1차 프로젝트 기간 동안 사용할 데이터베이스 
CREATE TABLE t1(
	c1 INT 
	c2 VARCHAR(20)
);
CREATE TABLE t2(
	c1 INT PRIMARY KEY, 
	c2 VARCHAR(20)
);
DESC t1;

-- 등록-- 
INSERT INTO t2(c1,c2) VALUES (5,'James');
INSERT INTO t2(c1,c2) VALUES (6,'hoyeong');
INSERT INTO t2(c1,c2) VALUES (7,'minjae');
INSERT INTO t2(c1,c2) VALUES (8,'ku');

INSERT INTO t2(c1,c2) VALUES (4,'bbbb');  
INSERT INTO t1(c2,c1) VALUES ('bbbb',2) 
INSERT INTO t1(c1) VALUES (3);
INSERT INTO t2(c1) VALUES (3);
--조회--
SELECT * FROM 테이블 명;
SELECT * FROM t1; 
--수정--
UPDATE t2 SET c2 = 'ccccc'
UPDATE t2 SET c2 = 'dddd' WHERE c1= 3; 
UPDATE t2 SET c2 = 'bbbb' WHERE c2='aaaa'
--삭제-----
DELETE FROM 테이블 명; 
DELETE FROM t2 WHERE c1 = 6; 
DELETE FROM t2 WHERE c1 = 7;
DELETE FROM t2 WHERE c1 = 8;
--한개만 조회---
SELECT COUNT(*)FROM t2; 

---하나만 조회 --- 로그인--- 
SELECT COUNT(*)FROM t2 WHERE c1 = 2 AND c2 = 'bbbb'; 
SELECT COUNT(*)FROM t2 WHERE c1 = 2 OR c2 = 'bbbb'; 

SELECT 컬럼명,*  FROM 테이블 명 WHERE c2 = 찾을 값; 
SELECT * FROM t2 WHERE c2 LIKE '%a%'; 
SELECT * FROM t2 WHERE c2 LIKE '_a%'; 
SELECT * FROM t2 WHERE c2 LIKE '__m%';
SELECT * FROM t2 WHERE c2 LIKE '_m';
SELECT * FROM t2 WHERE c2 LIKE '%g'; 
SELECT * FROM t2 WHERE c1<5; 
SELECT * FROM t2 WHERE c1>5;  
SELECT * FROM t2 WHERE c1!=5;  



-----------------------------------------

CREATE TABLE tbl_board(
	bno INT PRIMARY KEY AUTO_INCREMENT, 
	title VARCHAR(50),
	content VARCHAR(1000), 
	writer VARCHAR(50)
);

INSERT INTO tbl_board (title,content,writer)VALUES 
('제목1','내용1.....', 'user01'),
('제목2','내용2.....', 'user02'),
('제목3','내용3.....', 'user03'),
('제목4','내용4.....', 'user01'),
('제목5','내용5.....', 'user02');

SELECT *FROM  tbl_board;

SELECT *FROM tbl_board WHERE bno =3; 