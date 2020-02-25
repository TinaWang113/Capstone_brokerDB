-- create menu
CREATE TABLE capstone2020.menu (
	menuid INT auto_increment NOT NULL,
	menuname varchar(30) NOT NULL,
	CONSTRAINT menu_pk PRIMARY KEY (menuid)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='Menu type';

-- create category
CREATE TABLE capstone2020.category (
	categoryid INT auto_increment NOT NULL,
	categoryname varchar(30) UNIQUE NOT NULL,
	menuid INT NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (categoryid),
    CONSTRAINT category_fk FOREIGN KEY (menuid) REFERENCES capstone2020.menu(menuid)
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
	CONSTRAINT menu_pk PRIMARY KEY (itemID),
	CONSTRAINT item_fk FOREIGN KEY (categoryID) REFERENCES capstone2020.category(categoryid)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci
COMMENT='Meal items';



-- add testing data
insert into menu (menuID, menuName)
values (null, 'AUCE');
insert into menu (menuID, menuName)
values (null, 'Regular');
insert into menu (menuID, menuName)
values (null, 'Drink');
insert into menu (menuID, menuName)
values (null, 'Dessert');

insert into category (categoryID, categoryName, menuID)
Values (null,'[Han-Sang] í•œìƒ�',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'[Han-Ggi] í•œë�¼',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'[Lunch Box]',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'Noodles',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'Korean Cusine',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'BBQ',2);
insert into category (categoryID, categoryName, menuID)
Values (null,'Korean Alcohol',3);
insert into category (categoryID, categoryName, menuID)
Values (null,'Dessert',4);
insert into category (categoryID, categoryName, menuID)
Values (null,'Noodles Combo',2);

insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Short Rib Box | LAê°ˆë¹„',14.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Chicken Bulgogi Box | ë‹­ë¶ˆê³ ê¸°',12.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Pork Bulgogi Box | ë�¼ì§€ë¶ˆê³ ê¸°',12.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Don-katsu | ë�ˆê¹ŒìŠ¤',13.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Chicken-Katsu | ì¹˜í‚¨ê¹ŒìŠ¤',13.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Bossam Box | ë³´ìŒˆ',14.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles with Beef Broth + Pork Bulgogi | ë¬¼ëƒ‰ë©´ + ë�¼ì§€ë¶ˆê³ ê¸°',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles with Beef Broth + Chicken Bulgogi + | ë¬¼ëƒ‰ë©´ + ë‹­ë¶ˆê³ ê¸°',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles + Pork Bulgogi | ë¹„ë¹”ëƒ‰ë©´ + ë�¼ì§€ë¶ˆê³ ê¸°',18.99,'',9,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles + Chicken Bulgogi | ë¹„ë¹”ëƒ‰ë©´ + ë‹­ë¶ˆê³ ê¸°',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles with Beef Broth + Pork Bulgogi | ì–¼ì¹˜ê¸° ëƒ‰ë©´ + ë�¼ì§€ë¶ˆê³ ê¸°',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spice Cold Noodles with Beef Broth + Chicken Bulgogi | ì–¼ì¹˜ê¸° ëƒ‰ë©´ + ë‹­ë¶ˆê³ ê¸°',18.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate + Pork Bulgogi | íšŒ(í™�ì–´) ëƒ‰ë©´ + ë�¼ì§€ë¶ˆê³ ê¸°',19.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate + Chicken Bulgogi | íšŒ(í™�ì–´) ëƒ‰ë©´ + ë‹­ë¶ˆê³ ê¸°',19.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle + Beef Short Ribs | ëƒ‰ë©´ + LAê°ˆë¹„',21.99,'',3,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodles | ë¬¼ëƒ‰ë©´',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy Cold Noodle | ë¹„ë¹”ëƒ‰ë©´',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy Cold Noodle with beef broth | ì–¼ì¹˜ê¸°ëƒ‰ë©´',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Cold Noodle with Sliced Raw Skate | íšŒëƒ‰ë©´',14.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Udon (Fishball, Chicken, Beef) | ìš°ë�™',13.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir-fried glass noodles with vegetables|ì•¼ì±„ìž¡ì±„',16.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir-fried glass noodles with beef bulgogi|ê³ ê¸°ìž¡ì±„',19.99,'',4,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Kimchi stew soup|ê¹€ì¹˜ì°Œê°œ',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Soybean paste soup|ë�œìž¥ì°Œê°œ',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy soft tofu soup with seafood |í•´ë¬¼ìˆœë‘�ë¶€',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef rib soup|ê°ˆë¹„íƒ•',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ox bone soup|ì„¤ë �íƒ•',11.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ox knee soup|ë�„ê°€ë‹ˆíƒ•',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Skates spicy hot pot|í™�ì–´ë§¤ìš´íƒ•',15.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Spicy pollack soup|ë�™íƒœì°Œê°œ',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Hot stone bowl bulgogi|ëš�ë°°ê¸°ë¶ˆê³ ê¸°',14.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Bibimbap|ë¹„ë¹”ë°¥',12.99,'',5,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef King Sized Ribs (1 pc)|ì™•ê°ˆë¹„',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Bulgogi (300g)|ì†Œë¶ˆê³ ê¸°',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Beef Short Ribs (3 pcs)|LAê°ˆë¹„',27.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Marinated Pork Bulgogi (300g)|ë�¼ì§€ë¶ˆê³ ê¸°',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Marinated Chichen Bulgogi (300g)|ë‹­ë¶ˆê³ ê¸°',23.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Stir Fried Pork (300g)|ì œìœ¡ë³¶ì�Œ',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Pork Belly (5 pcs)|ì‚¼ê²¹ì‚´',25.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Beef Bulgogi|ì†Œë¶ˆê³ ê¸°ë�®ë°¥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Chichen Bulgogi|ë‹­ë¶ˆê³ ê¸°ë�®ë°¥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Beef Short Ribs|LAê°ˆë¹„ë�®ë°¥',17.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Pork Bulgogi|ë�¼ì§€ë¶ˆê³ ê¸°ë�®ë°¥',15.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Rice With Stir Fried Glass Noodles With Beef Bulgogi|ìž¡ì±„ë�®ë°¥',14.99,'',6,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Soju (375ml) | ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Graptefruit Soju (375ml) | ìž�ëª½ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Peach Soju (375ml) | ë³µìˆ­ì•„ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Green Grape Soju (375ml) | ì²­í�¬ë�„ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Apple Soju (375ml) | ì‚¬ê³¼ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Citron Soju (375ml) | ìœ ìž�ì†Œì£¼',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Makgeolli (700ml) | ë§‰ê±¸ë¦¬',17.99,'',7,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Vanilla)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Green)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Ice Cream (Tea)',2.5,'',8,'','');
insert into item (itemID, itemName, itemPrice, itemDesc,categoryID,photoLocalDirectory,photoCloudDirectory)
Values(null,'Coffee',2.5,'',8,'','');
