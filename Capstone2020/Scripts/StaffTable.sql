CREATE TABLE capstone2020.staff (
	sID int(4) NOT NULL AUTO_INCREMENT, 
	pin varchar(4) DEFAULT '0000' NULL,
	isActive varchar(100) DEFAULT 'Y' NOT NULL,
	fName varchar(30) NOT NULL,
	lName varchar(30) NOT NULL,
	contactNum varchar(12) NOT NULL,
	jobName varchar(30) NULL,
	PRIMARY KEY (sID)
)
ENGINE=InnoDB
charset='utf8'
COLLATE=utf8_general_ci
COMMENT='Staff information'
