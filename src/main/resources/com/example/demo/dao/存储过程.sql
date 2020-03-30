DROP PROCEDURE  IF EXISTS addAndReturnId


DELIMITER //

CREATE PROCEDURE addAndReturnId (OUT result BIGINT ,IN createdOn DATETIME,IN `name` VARCHAR(30),IN `code` VARCHAR(30),IN `status` VARCHAR(10))
BEGIN
	INSERT INTO bl_hospital (createdOn,updatedOn,`name`,`code`,`status`) VALUES (createdOn,NULL,NAME,CODE,STATUS);
	SET result=LAST_INSERT_ID();
END //

DELIMITER ;

DELIMITER //


# 调用

CALL addAndReturnId(@id,'2020-03-30 12:11:19','存储过程测试3','Test','Active');
SELECT @id



-- 查看直到数据库下所有存储过程
    SELECT `name` FROM mysql.proc WHERE db = 'demo1' AND `type` = 'PROCEDURE'
-- 查看musql所有数据库的存储过程
	SHOW PROCEDURE STATUS
-- 查看某个存储过程创建语句
    SHOW CREATE PROCEDURE addAndReturnId
