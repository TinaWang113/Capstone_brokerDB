-- add staff
insert into staff( fName, lName, contactNum, jobName)
values ('Tina', 'Wang', '1231234567','PT-Staff');
insert into staff(pin, isActive, fName, lName, contactNum, jobName)
values ('1234', 'T', 'Christopher', 'Lumsden', '1231234567','PT-Staff');
insert into staff(pin, isActive, fName, lName, contactNum, jobName)
values ('4567', 'T', 'Sungwook', 'Baek', '1231234567','PT-Staff');
insert into staff(pin, isActive, fName, lName, contactNum, jobName)
values ('7894', 'T', 'John', 'OLoughlin', '1231234567','Manager');

-- addingcategory
insert into category (categoryID, categoryName, menuID)
Values (null,'[Han-Sang] 한상',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'[Han-Ggi] 한끼',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'[Lunch Box]',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'Noodles',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'Korean Cusine',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'BBQ',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'Korean Alcohol',3);
insert into category (categoryID, categoryName, menuID)
Values (null,'Dessert',3);
insert into category (categoryID, categoryName, menuID)
Values (null,'Noodles Combo',1);
insert into category (categoryID, categoryName, menuID)
Values (null,'Meat',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'Vegetable',2);

insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Short Rib Box | LA갈비',14.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Chicken Bulgogi Box | 닭불고기',12.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Pork Bulgogi Box | 돼지불고기',12.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Don-katsu | 돈까스',13.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Chicken-Katsu | 치킨까스',13.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Bossam Box | 보쌈',14.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles with Beef Broth + Pork Bulgogi | 물냉면 + 돼지불고기',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles with Beef Broth + Chicken Bulgogi + | 물냉면 + 닭불고기',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles + Pork Bulgogi | 비빔냉면 + 돼지불고기',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles + Chicken Bulgogi | 비빔냉면 + 닭불고기',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles with Beef Broth + Pork Bulgogi | 얼치기 냉면 + 돼지불고기',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles with Beef Broth + Chicken Bulgogi | 얼치기 냉면 + 닭불고기',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate + Pork Bulgogi | 회(홍어) 냉면 + 돼지불고기',19.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate + Chicken Bulgogi | 회(홍어) 냉면 + 닭불고기',19.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle + Beef Short Ribs | 냉면 + LA갈비',21.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles | 물냉면',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy Cold Noodle | 비빔냉면',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy Cold Noodle with beef broth | 얼치기냉면',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate | 회냉면',14.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Udon (Fishball, Chicken, Beef) | 우동',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir-fried glass noodles with vegetables|야채잡채',16.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir-fried glass noodles with beef bulgogi|고기잡채',19.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Kimchi stew soup|김치찌개',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Soybean paste soup|된장찌개',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy soft tofu soup with seafood |해물순두부',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef rib soup|갈비탕',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ox bone soup|설렁탕',11.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ox knee soup|도가니탕',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Skates spicy hot pot|홍어매운탕',15.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy pollack soup|동태찌개',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Hot stone bowl bulgogi|뚝배기불고기',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Bibimbap|비빔밥',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef King Sized Ribs (1 pc)|왕갈비',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Bulgogi (300g)|소불고기',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Short Ribs (3 pcs)|LA갈비',27.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Marinated Pork Bulgogi (300g)|돼지불고기',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Marinated Chichen Bulgogi (300g)|닭불고기',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir Fried Pork (300g)|제육볶음',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Pork Belly (5 pcs)|삼겹살',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Beef Bulgogi|소불고기덮밥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Chichen Bulgogi|닭불고기덮밥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Beef Short Ribs|LA갈비덮밥',17.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Pork Bulgogi|돼지불고기덮밥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Stir Fried Glass Noodles With Beef Bulgogi|잡채덮밥',14.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Soju (375ml) | 소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Graptefruit Soju (375ml) | 자몽소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Peach Soju (375ml) | 복숭아소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Green Grape Soju (375ml) | 청포도소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Apple Soju (375ml) | 사과소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Citron Soju (375ml) | 유자소주',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Makgeolli (700ml) | 막걸리',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Vanilla)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Green)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Tea)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Coffee',2.5,'',8,'','');

-- Table Data
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(1, now(),now()+200,3,1);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(2, now(), now()+300,2,2);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(3, now(),now()+200,2,3);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(4, now()+1, now()+300,1,4);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(5, now(),now()+200,0,1);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(6, now(),now()+200,2,2);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(7, now(),now()+1400,3,3);

-- order Data
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   2 AS orderItemQty,
   12.99*2 AS orderAmount,
   1 AS orderStatus,
   2 AS item_itemID,
   2 AS table_tableID,
   startTime
     FROM capstone2020.`table`
     Where tableID = 2;

insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   5 AS orderItemQty,
   5*18.99 AS orderAmount,
   3 AS orderStatus,
   9 AS item_itemID,
   5 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 5;

insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   1 AS orderItemQty,
   2.5 AS orderAmount,
   0 AS orderStatus,
   52 AS item_itemID,
   1 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 1;
 
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   1 AS orderItemQty,
   2.5 AS orderAmount,
   1 AS orderStatus,
   53 AS item_itemID,
   1 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 3; 
     	
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT     
   1 AS orderItemQty,
   2.5 AS orderAmount,
   1 AS orderStatus,
   53 AS item_itemID,
   1 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 7;    
     
     
     
 -- survey data    
     
     
insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7, surveyA8, table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   1 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   1 AS surveyA5,
   1 AS surveyA6,
   1 AS surveyA7,
   1 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 1 ;    
	
insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7, surveyA8, table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   1 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   1 AS surveyA5,
   1 AS surveyA6,
   1 AS surveyA7,
   2 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 2 ;  
     insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7, surveyA8, table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   4 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   2 AS surveyA5,
   4 AS surveyA6,
   2 AS surveyA7,
   3 AS table_tableID,
   startTime
     FROM capstone2020.table
     Where tableID = 3 ;    
     
    -- Survery Question 
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(1, "Food quality ") ;   
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(2, "Service speed") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(3, "Restaurant Enviornment ") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(4, "Service quality") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(5, "Food speed") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(6, "Will you recommand your friend to visit our restaurant") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(7, "How satisfied your food") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(8, "How enjoy this experiment") ;    