CREATE TABLE `staff` (
  `sID` varchar(20) NOT NULL  AUTO_INCREMENT,
  `pin` varchar(4) DEFAULT '0000',
  `isActive` varchar(1) DEFAULT 'Y',
  `fName` varchar(30) NOT NULL,
  `lName` varchar(30) NOT NULL,
  `contactNum` varchar(12) DEFAULT NULL,
  `jobName` varchar(20) NOT NULL,   
  PRIMARY KEY (`sID`),
) ENGINE=InnoDB 
  DEFAULT CHARSET=utf8 
  COMMENT='Staff information'

