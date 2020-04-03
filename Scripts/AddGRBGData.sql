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
Values (null,'[Han-Sang] 한상',1); -- 1
insert into category (categoryID, categoryName, menuID)
Values (null,'[Han-Ggi] 한끼',1); -- 2
insert into category (categoryID, categoryName, menuID)
Values (null,'[Lunch Box]',1); -- 3
insert into category (categoryID, categoryName, menuID)
Values (null,'Noodles',1); -- 4 
insert into category (categoryID, categoryName, menuID)
Values (null,'Korean Cusine',1); -- 5
insert into category (categoryID, categoryName, menuID)
Values (null,'BBQ',1); -- 6
insert into category (categoryID, categoryName, menuID)
Values (null,'Asian Cuisine',1); -- 7 
insert into category (categoryID, categoryName, menuID)
Values (null,'Hot Pot',1); -- 8
insert into category (categoryID, categoryName, menuID)
Values (null,'Drink',3); -- 9
insert into category (categoryID, categoryName, menuID)
Values (null,'Dessert',3); -- 10
insert into category (categoryID, categoryName, menuID)
Values (null,'Appetizer',1); -- 11
insert into category (categoryID, categoryName, menuID)
Values (null,'All You Can Eat',2); -- 12

-- item: regular
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Don-katsu | 돈까스', 13.99, 'A breaded, deep-fried/tempura pork cutlet.', 7, 'item/donkatsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Chicken-Katsu | 치킨까스', 13.99, 'A breaded, deep-fried/tempura chicken cutlet.', 7, 'item/ckatsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Bossam Box | 보쌈', 14.99, 'A belly pork that is boiled in spices and thinly sliced.', 7, 'item/bossam.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodles with Beef Broth + Pork Bulgogi | 물냉면 + 돼지불고기', 18.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodles with Beef Broth + Chicken Bulgogi + | 물냉면 + 닭불고기', 18.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spice Cold Noodles + Pork Bulgogi | 비빔냉면 + 돼지불고기', 18.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spice Cold Noodles + Chicken Bulgogi | 비빔냉면 + 닭불고기', 18.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spice Cold Noodles with Beef Broth + Pork Bulgogi | 얼치기 냉면 + 돼지불고기', 18.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spice Cold Noodles with Beef Broth + Chicken Bulgogi | 얼치기 냉면 + 닭불고기', 18.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 2, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodle with Sliced Raw Skate + Pork Bulgogi | 회(홍어) 냉면 + 돼지불고기', 19.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 1, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodle with Sliced Raw Skate + Chicken Bulgogi | 회(홍어) 냉면 + 닭불고기', 19.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 1, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodle + Beef Short Ribs | 냉면 + LA갈비', 21.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 1, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodles | 물냉면', 13.99, 'a Korean noodle dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 4, 'item/mulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy Cold Noodle | 비빔냉면', 13.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 4, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy Cold Noodle with beef broth | 얼치기냉면', 13.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 4, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodle with Sliced Raw Skate | 회냉면', 14.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 4, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Cold Noodle with Broth + Spicy Cold Noodles | 물*비냉면', 14.99, 'a Korean noodle spice dish of long and thin handmade noodles made from the flour and starch of various ingredients, including buckwheat, potatoes, sweet potatoes, arrowroot starch', 4, 'item/bigogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Udon (Fishball, Chicken, Beef) | 우동', 13.99, 'a noodle soup derived from the Japanese udon', 4, 'item/udon.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Stir-fried glass noodles with vegetables|야채잡채', 16.99, 'a sweet and savory dish of stir-fried glass noodles and vegetables that is popular in Korean cuisine.', 4, 'item/jamchae.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Stir-fried glass noodles with beef bulgogi|고기잡채', 19.99, 'a sweet and savory dish of stir-fried glass noodles and vegetables that is popular in Korean cuisine.', 4, 'item/jamchae.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House salad|하우스샐러드|house salad', 6.99, 'House Salad is a recipe cooked on the intermediate Salad Station', 11, 'item/h_salad.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Soft tofu salad|연두부샐러드', 8.99, 'Salad with Tofu, sweet and sour dressing', 11, 'item/t_salad.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Deep fried dumpling|군만두', 5.99, 'Dumplings in Korean cuisine', 11, 'item/mandu.png', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Deep fried dumpling (sweet sauce)|탕수만두', 7.99, 'Dumplings in Korean cuisine with sweet and sour souce', 11, 'item/t_mandu.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Shrimp dumpling|슈마이|shrimp dumpling', 6.99, 'Dumplings in Korean cuisine with sweet and sour souce [Shrimp]', 11, 'item/shumai.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Deep fried tofu|두부튀김', 7.99, 'Deep fried tofu', 11, 'item/d_tofu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Shrimp tempura|새우튀김', 7.99, 'Shrimp tempura', 11, 'item/s_tempura.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Vegetable tempura|야채튀김', 6.99, 'Vegetable tempura', 11, 'item/v_tempura.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Seafood pancake (M) |해물파전 (M)', 15.99, 'crispy seafood pancakes ', 11, 'item/s_pancake.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Seafood pancake (L) |해물파전 (L)', 19.99, 'crispy seafood pancakes ', 11, 'item/s_pancake.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Kimchi pancake (M)|김치전 (M)', 12.99, 'Kimchi pancake is made from a simple batter of kimchi, scallions, salt, and water fried to a crispy pancake in the skillet and served', 11, 'item/k_pancake.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Kimchi pancake (L)|김치전 (L)', 15.99, 'Kimchi pancake is made from a simple batter of kimchi, scallions, salt, and water fried to a crispy pancake in the skillet and served', 11, 'item/k_pancake.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Kimchi stew soup|김치찌개', 12.99, 'stew-like Korean dish, made with kimchi and other ingredients, such as scallions, onions, diced tofu, pork', 5, 'item/k_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Soybean paste soup|된장찌개', 12.99, 'soybean paste stew is a rich, silky jjigae (stew) made with doenjang (soybean paste) ', 5, 'item/d_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy soft tofu soup with seafood |해물순두부', 12.99, 'soft tofu stew with sea food', 5, 'item/s_stew.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy soft tofu soup with Beef |소고기순두부 ', 13.99, 'soft tofu stew with beef', 5, 'item/b_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy beef soup|육개장', 14.99, 'spicy beef soup', 5, 'item/y_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Spicy pork bone soup|감자탕', 14.99, 'pork back-bone stew', 5, 'item/g_stew.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef rib soup|갈비탕', 14.99, 'short rib soup', 5, 'item/galbistew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Ox bone soup|설렁탕', 11.99, 'Korean broth tang (soup) made from ox bones', 5, 'item/seal_stew.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Ox knee soup|도가니탕', 14.99, 'beef bone soup refers to a soup in Korean cuisine ', 5, 'item/do_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Skates spicy hot pot|홍어매운탕', 15.99, 'spicy fish stew is a hot spicy Korean cuisine fish soup boiled with gochujang kochukaru (chili powder), and various vegetables', 5, 'item/ma_stew.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Bibimbap|비빔밥', 12.99, 'Bibimbap is served as a bowl of warm white rice topped with namul (seasoned vegetables) or kimchi (traditional fermented vegetables) and gochujang (chili pepper paste), soy sauce, or doenjang (a fermented soybean paste)', 5, 'item/bibimbob.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef King Sized Ribs (1 pc)|왕갈비 ', 25.99, 'grilled ribs is a type of gui (grilled dish) in Korean cuisine', 6, 'item/wanggalbi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef Bulgogi (300g)|소불고기', 23.99, 'Thin, marinated slices of beef grilled on a barbecue or on a stove-top griddle', 6, 'item/b_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef Short Ribs (3 pcs)|LA갈비', 27.99, 'A type of  grilled dish in Korean cuisine', 6, 'item/galbi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Marinated Pork Bulgogi (300g)|돼지불고기', 23.99, ' Thin, marinated slices of port grilled on a barbecue or on a stove-top griddle', 6, 'item/p_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Marinated Chichen Bulgogi (300g)|닭불고기', 23.99, ' Thin, marinated slices of chicken grilled on a barbecue or on a stove-top griddle', 6, 'item/c_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Stir Fried Pork (300g)|제육볶음', 25.99, 'Stir-fry is a recipe for roasting ingredients in a hot fire with seasoning .', 6, 'item/stirPork.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Pork Belly (5 pcs)|삼겹살', 25.99, 'grilled pork belly is a type of gui (grilled dish) in Korean cuisine', 6, 'item/samggubi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Rice With Beef Bulgogi|소불고기덮밥', 15.99, 'bugogi with steamed rice', 6, 'item/sobulbob.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Tteokbokki|떡볶이', 15.99, 'stir-fried rice cakes is a popular Korean food made from small-sized garae-tteok called tteokmyeon', 7, 'item/tteok.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Gungjung Tteokbokki|궁중떡볶이', 15.99, 'royal court tteok-bokki, non-spicy version ', 7, 'item/gungtteok.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Marinated Intestine|양념막창구이', 24.99, 'the abomasum (the fourth and final stomach compartment in ruminants) of cattle or the gui (grilled dish) made of beef abomasum', 7, 'item/makchang.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sweet And Sour Pork|탕수육', 26.99, 'Korean Chinese meat dish with sweet and sour sauce', 7, 'item/tangsu.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Fish Ball Hotpot (M) |오뎅전골(중)', 38.99, 'Oden, consisting of several ingredients such as boiled eggs, daikon, konjac, and processed fishcakes stewed in a light, soy-flavored dashi broth.', 8, 'item/oden.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Kimchi Hotpot (M)|김치전골(대)', 38.99, 'kimchi stew is a jjigae, or stew-like Korean dish, made with kimchi and other ingredients, such as scallions, onions, diced tofu, por', 8, 'item/kimchijeongol.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Seafood Hotpot (M) |해물전골(중)', 47.99, 'Korean-style hot pot made by putting mushroom, seafood', 8, 'item/hamuljeongol.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Pork Bone Hotpot (M)|감자탕(중)', 49.99, 'pork back-bone stew is a spicy Korean soup made from the spine or neck bones of a pig', 8, 'item/gamjatang.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sausage Stew Hotpot (M) |부대찌개(중)', 49.99, 'spicy sausage stew is a type of jjigae (stew), made with ham, sausage, spam, baked beans, kimchi', 8, 'item/budae.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Fish Ball Hotpot (L) |오뎅전골(대)', 45.99, 'Oden, consisting of several ingredients such as boiled eggs, daikon, konjac, and processed fishcakes stewed in a light, soy-flavored dashi broth.', 8, 'item/oden.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'KiLchi Hotpot (L)|김치전골(대)', 45.99, 'kimchi stew is a jjigae, or stew-like Korean dish, made with kimchi and other ingredients, such as scallions, onions, diced tofu, por', 8, 'item/kimchijeongol.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Seafood Hotpot (L) |해물전골(대)', 59.99, 'Korean-style hot pot made by putting mushroom, seafood', 8, 'item/hamuljeongol.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Pork Bone Hotpot (L)|감자탕(대)', 59.99, 'pork back-bone stew is a spicy Korean soup made from the spine or neck bones of a pig', 8, 'item/gamjatang.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sausage Stew Hotpot (L) |부대찌개(대)', 59.99, 'spicy sausage stew is a type of jjigae (stew), made with ham, sausage, spam, baked beans, kimchi', 8, 'item/budae.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Soju (375ml) | 소주 ', 17.99, 'Soju is a clear, colorless distilled beverage of Korean origin', 9, 'item/soju.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Graptefruit Soju (375ml) | 자몽소주', 17.99, '', 9, 'item/graptefruitsoju.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Peach Soju (375ml) | 복숭아소주', 17.99, '', 9, 'item/peachsoju.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Green Grape Soju (375ml) | 청포도소주', 17.99, '', 9, 'item/grapesoju.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Apple Soju (375ml) | 사과소주', 17.99, '', 9, 'item/applesoju.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Citron Soju (375ml) | 유자소주', 17.99, '', 9, 'item/yususoju.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Makgeolli (700ml) | 막걸리 ', 17.99, '', 9, 'item/makgulli.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House White Wine (5oz)', 6.95, '', 9, 'item/whitewine.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House White Wine (10oz)', 13, '', 9, 'item/whitewine.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House White Wine (bottle)', 35, '', 9, 'item/whitewine.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House Red Wine (5oz)', 6.95, '', 9, 'item/wine.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House Red Wine (10oz)', 13, '', 9, 'item/wine.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House Red Wine (bottle)', 35, '', 9, 'item/wine.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sake (5oz)', 7, '', 9, 'item/sake.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sake (10oz)', 13.95, '', 9, 'item/sake.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Domestic Beer (375ml) ', 5.95, '', 9, 'item/dobeer.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Pop', 2, '', 10, 'item/pop.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Juice', 2.5, '', 10, 'item/juice.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Mi Bingsu| 미빙수', 14.99, 'shaved ice dessert with sweet toppings that may include chopped fruit, condensed milk, fruit syrup, and red beans. Varieties ', 10, 'item/bingsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Matach Bingsu | 마차빙수', 14.99, 'shaved ice dessert with sweet toppings that may include chopped fruit, condensed milk, fruit syrup, and red beans. Varieties ', 10, 'item/matachbingsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Strawberry Bingsu | 딸기빙수', 14.99, 'shaved ice dessert with sweet toppings that may include chopped fruit, condensed milk, fruit syrup, and red beans. Varieties ', 10, 'item/ddalkibingsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Ice Cream (Vanilla)', 2.5, '', 10, 'item/icecream.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Ice Cream (Green)', 2.5, '', 10, 'item/icecream.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Ice Cream (Tea)', 2.5, '', 10, 'item/icecream.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Coffee', 2.5, '', 10, 'item/coffee.jpg', null);

-- item: all you can eat 
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Don-katsu | 돈까스', 0, 'A breaded, deep-fried/tempura pork cutlet.', 12, 'item/donkatsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Chicken-Katsu | 치킨까스', 0, 'A breaded, deep-fried/tempura chicken cutlet.', 12, 'item/ckatsu.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Bossam Box | 보쌈', 0, 'A belly pork that is boiled in spices and thinly sliced.', 12, 'item/bossam.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Stir-fried glass noodles with vegetables|야채잡채', 0, 'a sweet and savory dish of stir-fried glass noodles and vegetables that is popular in Korean cuisine.', 12, 'item/jamchae.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House salad|하우스샐러드|house salad', 0, 'House Salad is a recipe cooked on the intermediate Salad Station', 12, 'item/h_salad.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Deep fried dumpling|군만두', 0, 'Dumplings in Korean cuisine', 12, 'item/mandu.png', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Deep fried dumpling (sweet sauce)|탕수만두', 0, 'Dumplings in Korean cuisine with sweet and sour souce', 12, 'item/t_mandu.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef King Sized Ribs (1 pc)|왕갈비 ', 0, 'grilled ribs is a type of gui (grilled dish) in Korean cuisine', 12, 'item/wanggalbi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef Bulgogi (300g)|소불고기', 0, 'Thin, marinated slices of beef grilled on a barbecue or on a stove-top griddle', 12, 'item/b_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Beef Short Ribs (3 pcs)|LA갈비', 0, 'A type of  grilled dish in Korean cuisine', 12, 'item/galbi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Marinated Pork Bulgogi (300g)|돼지불고기', 09, ' Thin, marinated slices of port grilled on a barbecue or on a stove-top griddle',12, 'item/p_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Marinated Chichen Bulgogi (300g)|닭불고기', 0, ' Thin, marinated slices of chicken grilled on a barbecue or on a stove-top griddle', 12, 'item/c_bulgogi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Pork Belly (5 pcs)|삼겹살', 0, 'grilled pork belly is a type of gui (grilled dish) in Korean cuisine', 12, 'item/samggubi.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Rice With Beef Bulgogi|소불고기덮밥', 0, 'bugogi with steamed rice', 12, 'item/sobulbob.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Tteokbokki|떡볶이', 0, 'stir-fried rice cakes is a popular Korean food made from small-sized garae-tteok called tteokmyeon', 12, 'item/tteok.jpg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Sweet And Sour Pork|탕수육', 0, 'Korean Chinese meat dish with sweet and sour sauce', 12, 'item/tangsu.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'House salad|하우스샐러드|house salad', 0, 'House Salad is a recipe cooked on the intermediate Salad Station', 12, 'item/h_salad.jpeg', null);
insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) Values (null, 'Soft tofu salad|연두부샐러드', 0, 'Salad with Tofu, sweet and sour dressing', 12, 'item/t_salad.jpg', null);

-- Table Data

insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(1, '2020-03-30 20:30:00',now()+200,3,1);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(2, '2020-03-30 20:30:00', now()+300,2,2);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(3, '2020-03-30 20:30:00',now()+200,2,3);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(4, '2020-03-30 20:30:00', now()+300,1,4);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(5, '2020-03-30 20:30:00',now()+200,0,1);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(6,'2020-03-30 20:30:00',now()+200,2,2);
insert into capstone2020.table(tableID, startTime, endTime, tableStatus,staff_sID)
Values(7, '2020-03-30 20:30:00',now()+1400,3,3);

-- order Data
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   2 AS orderItemQty,
   12.99*2 AS orderAmount,
   1 AS orderStatus,
   2 AS item_itemID,
   2 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.`table`
     Where tableID = 2;
     
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   5 AS orderItemQty,
   5*18.99 AS orderAmount,
   3 AS orderStatus,
   9 AS item_itemID,
   5 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 5;

insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   1 AS orderItemQty,
   2.5 AS orderAmount,
   0 AS orderStatus,
   52 AS item_itemID,
   1 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 1;
 
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT 
   1 AS orderItemQty,
   2.5 AS orderAmount,
   1 AS orderStatus,
   53 AS item_itemID,
   1 AS table_tableID,
  '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 3; 
     	
insert into capstone2020.order (orderItemQty, orderAmount, orderStatus, item_itemID, table_tableID, table_startTime)
SELECT     
   1 AS orderItemQty,
   2.5 AS orderAmount,
   1 AS orderStatus,
   53 AS item_itemID,
   1 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 7;    
     
     
     
 -- survey data    
     
     
insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7,table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   1 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   1 AS surveyA6,
   1 AS surveyA7,
   1 AS table_tableID,
  '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 1 ;    
	
insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7, table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   1 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   1 AS surveyA6,
   1 AS surveyA7,
   2 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 2 ;  
     insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, 
surveyA6, surveyA7, table_tableID, table_startTime)
SELECT     
   1 AS surveyA1,
   2 AS surveyA2,
   4 AS surveyA3,
   5 AS surveyA4,
   1 AS surveyA5,
   4 AS surveyA6,
   2 AS surveyA7,
   3 AS table_tableID,
   '2020-03-30 20:30:00'
     FROM capstone2020.table
     Where tableID = 3 ;    
     
    -- Survery Question 
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(1, "How was your food?") ;   
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(2, "How was the service?") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(3, "How was the atmosphere?") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(4, "How was the service speed?") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(5, "Food delivery speed? adequate?") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(6, "Will you recommend this restaurant?") ;    
insert into capstone2020.surveyQuestions (surveyQuestionID, surveysurveyQuestion)
values(7, "How was your experience with this application?") ;    
  