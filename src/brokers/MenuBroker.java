/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Category;
import model.Item;
import server.Connect2Server;

/**
 * The class is for menu object using
 * @author 730693
 *
 */
public class MenuBroker {
	
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	boolean executedResult = false;
	List <Item>items ;
	
	
	/**
	 * findItemAll:
	 * 	Obtaining all items from database
	 * @return items  List with Item datatype
	 * @throws SQLException  if any exception during running query
	 */
	public List<Item> findItemAll() throws SQLException {
		//connect;
		executedResult = false;
		connect();	
		stmtString = "SELECT item.itemID, item.itemName, item.itemPrice, item.itemDesc, item.categoryID, " + 
					 "item.photoLocalDirectory, item.photoCloudDirectory, categoryName, menuID " + 
					 "FROM capstone2020.`item` " + 
					 "JOIN category ON item.categoryID = category.categoryID";				
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if(rs != null) {			
			items =  new ArrayList<Item>();
			while(rs.next()) {	
				Item item = new Item();
				Category category = new Category();
				item.setItemID(rs.getInt(1));
				item.setItemName(rs.getString(2));
				item.setItemPrice(rs.getDouble(3));
				item.setItemDesc(rs.getString(4));
				//category
				category.setCategoryID(rs.getInt(5));
				category.setCategoryName(rs.getString(8));
				category.setMenuID(rs.getInt(9));
				item.setCategory(category);
				item.setPhotoLocalDirectory(rs.getString(6));
				item.setPhotoCloudDirectory(rs.getString(7));								
				items.add(item);
				//System.out.println(item.toString());
			}
		}else {
			System.out.println("SQL stmt is problem.");
		}	
		close();
		return items;	
	}
	
	/**
	 * findCategoryAll
	 * 		Obtaining all category from category table
	 * @return categories List with Category datatype
	 * @throws SQLException if any exception during running query
	 */
	public List<Category> findCategoryAll() throws SQLException{
	//connect;
		executedResult = false;
		List <Category> categories =  new ArrayList<Category>();
		connect();	
		stmtString = "SELECT * FROM category " ;				
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if(rs != null) {						
			while(rs.next()) {	
				Category category = new Category();
				category.setCategoryID(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setMenuID(rs.getInt(3));
									
				categories.add(category);
				//System.out.println(item.toString());
			}
		}else {
			System.out.println("SQL stmt is problem.");
		}	
		close();
		return categories;
	}
	
	
	/**
	 * close
	 * 	close all connection between database.
	 * @throws SQLException if any exception during running query
	 */
	private void close() throws SQLException {
		if(rs.isClosed()) rs.close();
		if(!preparedStmt.isClosed()) preparedStmt.close();
		if(!con.isClosed()) con.close();
	}
	
	/**
	 * connect
	 * 	Establishing the connection to server.
	 * @return con Connection
	 * @throws SQLException if any exception during running query
	 */
	private Connection connect() throws SQLException {
		if(con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}
	
	
	/**
	 * findbyID
	 * 	Seeking an item by using the item ID 
	 * @param id Int, it's the item ID. It's should be integer and cannot be negative 
	 * @return  item Item object, if the Item ID can be found in Item table, otherwise it's will return null.
	 * @throws SQLException if any exception during running query
	 */
	public Item findbyID(int id)throws SQLException{
		Item item = null;
		Category category =null;
		int tempCategoryID = -1;
		connect();
		//stmtString = "select * from item where itemID = "+id;
		stmtString = "SELECT item.itemName, item.itemPrice, item.itemDesc, item.categoryID, " + 
				"item.photoLocalDirectory, item.photoCloudDirectory, categoryName, menuID " + 
				"FROM item JOIN category ON item.categoryID = category.categoryID " + 
				"where itemID = " +id;
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		while(rs.next()) {
				item = new Item();
				category = new Category();
				item.setItemID(id);
				item.setItemName(rs.getString(1));
				item.setItemPrice(rs.getDouble(2));
				item.setItemDesc(rs.getString(3));
				//category
				category.setCategoryID(rs.getInt(4));
				category.setCategoryName(rs.getString(7));
				category.setMenuID(rs.getInt(8));
				item.setCategory(category);
				item.setPhotoLocalDirectory(rs.getString(5));
				item.setPhotoCloudDirectory(rs.getString(6));								
				//System.out.println(item.toString());
		}	
		close();
		return item;
	}
	
	
	/**
	 * findByID
	 * 	seeking a category by categoryID in category table
	 * @param id int It must to be integer and large than 0
	 * @return category Category object if the id can be found in category table, otherwise it returns null
	 * @throws SQLException if any exception during running query
	 */
	public Category findByID(int id) throws SQLException {
		Category category = null;
		executedResult = false;
		connect();		
		if(con != null) {
			stmtString = "select * from category where categoryID = " + id;
			preparedStmt  = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				category = new Category();
				category.setCategoryID(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setMenuID(rs.getInt(3));				
			}
		}else {
			System.out.println("Server connect fail.");
		}
		close();
		return category;
	}
	
	
	/**
	 * isExisting
	 * 	seeking an object if it is in table.
	 * @param table  String it indicates neither category or item table.  Only accessible the two String.
	 * @param id int It must to be integer and large than 0
	 * @return boolean either true or false which represents the id if it's in the table. 
	 * @throws SQLException if any exception during running query
	 */
	public boolean isExisting(String table, int id) throws SQLException {
		connect();
		//System.out.println("table: "+table+ ", id= "+ id);
		executedResult = false;
		switch(table.toLowerCase()) {
			case "item":
				stmtString = "select count(*) from item where itemID = "+id;
			break;				
			case "category":
				stmtString = "select count(*) from category where categoryID = " + id;
			break;
			default:
				break;
		}
		preparedStmt = con.prepareStatement(stmtString);
		//rs = preparedStmt.executeQuery(stmtString);
		//rs.next();
		//System.out.println(rs.getInt("count(*)") );
		rs = preparedStmt.executeQuery(stmtString);
		rs.next();
		if(rs.getInt(1)>0) {
			executedResult =true;
		}
		preparedStmt.close();
		con.close();
		return executedResult ;		
	}
	
	/**
	 * qtyData
	 * 	calculating the number of data in table
	 * @param table String it is either "category" or "item"
	 * @return qty int the number of data in the table. 
	 * @throws SQLException if any exception during running query 
	 */
	
	public int qtyData(String table) throws SQLException {
		connect();
		stmtString = "select count(*) from " + table.toLowerCase();
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		rs.next();
		int qty = rs.getInt(1);
		System.out.println("[qtyDat]"+qty);
		close();
		return qty;
	}
	
	/**
	 * insertItem
	 * 	inserting Item object into item table.
	 * @param item Item object ItemName and price categoryID cannot be null 
	 * @return boolean  true is inserting success, otherwise false
	 * @throws SQLException if any exception during running query
	 */
	public boolean insertItem(Item item) throws SQLException {
		executedResult = false;		
		if(item == null && isExisting("item", item.getItemID()) ) {
			System.out.println("item is incorrect.");
		}else if(!isExisting("category",item.getCategory().getCategoryID()) || item.getCategory() == null) {
			System.out.println("Category isn't exisiting or is null Object, please add it before adding item.");
		}else {	
			connect();
			stmtString = "insert into item (itemID, itemName, itemPrice, itemDesc, "
					+ "categoryID,photoLocalDirectory,photoCloudDirectory) "
					+ "Values(null,?,?,?,?,?,?)";
			//create MySQL insert preparedstatement
			preparedStmt =con.prepareStatement(stmtString);
			//preparedStmt.setInt(1, item.getItemID());
			preparedStmt.setString(1, item.getItemName());
			preparedStmt.setDouble(2, item.getItemPrice());
			preparedStmt.setString(3, item.getItemDesc());
			preparedStmt.setInt(4, item.getCategory().getCategoryID());
			preparedStmt.setString(5, item.getPhotoLocalDirectory());
			preparedStmt.setString(6, item.getPhotoCloudDirectory());
	      // execute the preparedstatement
			System.out.println(preparedStmt.executeUpdate());
		     executedResult = true;
		}
		//close();
		preparedStmt.close();
		con.close();
		return executedResult;
		
	}
	
	/**
	 * insertCategory
	 * 		insert new Category object into category table
	 * @param category Category Object. menuID and categoryName cannot be null 
	 * @return boolean  true is inserting success, otherwise false
	 * @throws SQLException if any exception during running query
	 */
	
	public boolean insertCategory(Category category) throws SQLException {
		connect();
		executedResult = false;
		if(category != null) {
			stmtString = "insert into category (categoryID, categoryName, menuID) " + 
					"Values (null,?,?)";
			preparedStmt = con.prepareStatement(stmtString);
			//preparedStmt.setInt(1, category.getCategoryID());
			preparedStmt.setString(1, category.getCategoryName());
			preparedStmt.setInt(2, category.getMenuID());
			if (preparedStmt.executeUpdate()== 1) executedResult = true;
		}else {
			System.out.println("the Object, category is existing or ID is incorrect. ");
		}			
		close();
		return executedResult;
	}
	
	/**
	 * update
	 * 	Update Item item which is existing in item table
	 * @param item Item object. ItemID cannot be null and doesn't existing in database
	 * @return boolean true if update successes, otherwise return false. 
	 * @throws SQLException if any exception during running query
	 */
	public boolean update(Item item) throws SQLException {
		executedResult = false;
		if(item != null && isExisting("item", item.getItemID())) {
			connect();
			stmtString = "update item "
					+ "set itemName=?, itemPrice=?, itemDesc=?, categoryID=?, "
					+ "photoLocalDirectory=?, photoCloudDirectory=? where itemID= " + item.getItemID();
			//itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.setString(1, item.getItemName());
			preparedStmt.setDouble(2, item.getItemPrice());
			preparedStmt.setString(3, item.getItemDesc());
			preparedStmt.setInt(4, item.getCategory().getCategoryID());
			preparedStmt.setString(5, item.getPhotoLocalDirectory());
			preparedStmt.setString(6, item.getPhotoCloudDirectory());
			if(preparedStmt.executeUpdate()==1) executedResult = true;
		}else {
			System.out.println("update object is incorrect, "+ item.toString());
		}
		close();
		return executedResult;
		
	}
	
	
	/**
	 *  update
	 *  	update Category data
	 * @param category Category the categoryID cannot be null and cannot existing in database
	 * @return boolean returning true if update successes, otherwise false.
	 * @throws SQLException if any exception during running query
	 */
	public boolean update(Category category) throws SQLException {
		executedResult = false;
		if(category != null && isExisting("category", category.getCategoryID())) {
			connect();
			stmtString = "update category "
					+ "set categoryName = ?, menuID = ? where categoryID = "+ category.getCategoryID();
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.setString(1, category.getCategoryName());
			preparedStmt.setInt(2, category.getMenuID());
			if(preparedStmt.executeUpdate()==1) executedResult = true;
		}else {
			System.out.println("update object is incorrect, "+category.toString());
		}	
		close();
		return executedResult;
	}
	
	/**
	 * deleteByID
	 * 	delete data by the tableName and id
	 * @param table String it would be either "item" or "category"
	 * @param id int it must be Integer and large than 0
	 * @return boolean true, if delete success; otherwise false
	 * @throws SQLException if any exception during running query
	 */
	
	public boolean deleteByID(String table, int id) throws SQLException {
		executedResult = false;
		if(isExisting(table, id)) {
			connect();
			switch(table.toLowerCase()) {
				case "item":
					stmtString = "delete from item where itemID = " +id;
				break;
				
				case "category":
					//have to make sure all item have been delete that use the same categoryID.
					stmtString = "delete from category where categoryID =  "+id;
				break;
				
				default:
				break;
			}
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.executeUpdate();
			if(preparedStmt.executeUpdate()==1) executedResult = true;
		}else {
			System.out.println("the object doesn't existing.");
			executedResult = true;
		}
		close();
		return executedResult;
	}
	
	
	/**
	 * deleteAll
	 * 	delete All data by the table Name
	 * @param table String  either "category" or "item".
	 * @return boolean true if delete all data success; otherwise false.
	 * @throws SQLException if any exception during running query
	 */
	private boolean deleteAll(String table) throws SQLException {
		stmtString = "delete from "+ table ;
		executedResult = false;
		connect();
		preparedStmt = con.prepareStatement(stmtString);
		preparedStmt.executeUpdate();	
		if(qtyData(table) == 0) {
			executedResult = true;
		}else {
			System.out.println("delete fail.");
		}
		close();
		return executedResult;
	}
	
	
}
