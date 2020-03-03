
-- create category
CREATE TABLE capstone2020.category (
	categoryID INT auto_increment NOT NULL,
	categoryName varchar(30) UNIQUE NOT NULL,
	menuID INT NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (categoryid)
    /*CONSTRAINT category_fk FOREIGN KEY (menuid) REFERENCES capstone2020.menu(menuid)*/
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='Meal category';

-- create item
CREATE TABLE capstone2020.item (
	itemID INT auto_increment NOT NULL,
	itemName varchar(255) UNIQUE NOT NULL,
    itemPrice DECIMAL(10,2),
    itemDesc varchar(255),
    categoryID int NOT NULL,
    photoLocalDirectory varchar(255),
    photoCloudDirectory varchar(255),
    constraint item_pk primary key (itemID),
	CONSTRAINT item_fk FOREIGN KEY (categoryID) REFERENCES capstone2020.category(categoryID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='Meal items';


/*
-- add testing data
insert into menu (menuID, menuName)
values (null, 'AUCE');
insert into menu (menuID, menuName)
values (null, 'Regular');
insert into menu (menuID, menuName)
values (null, 'Drink');
insert into menu (menuID, menuName)
values (null, 'Dessert');
*/

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
