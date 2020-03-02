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
import java.util.concurrent.CyclicBarrier;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.webkit.ThemeClient;

import model.Category;
import model.Item;
import model.Menu;
import server.Connect2Server;

/**
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
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Item> findAll() throws SQLException {
		//connect;
		executedResult = false;
		connect();
		stmtString = "select * from item";				
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
				ResultSet rsCategory = preparedStmt.executeQuery("select * from category where categoryID = "+rs.getInt(5));
				if(rsCategory != null) {
					category = new Category();
					category.setCategoryID(rsCategory.getInt(1));
					category.setCategoryName(rsCategory.getString(2));
					category.setMenuID(rsCategory.getInt(3));		
				}else {
					//not impletement
				}
				rsCategory.close();
				//end - category
				item.setCategory(category);
				item.setPhotoLocalDirectory(rs.getString(6));
				item.setPhotoCloudDirectory(rs.getString(7));								
				items.add(item);
				System.out.println(item.toString());
			}
		}else {
			System.out.println("SQL stmt is problem.");
		}	
		close();
		return items;	
	}
	
	public void close() throws SQLException {
		if(!preparedStmt.isClosed()) preparedStmt.close();
		if(!rs.isClosed()) rs.close();
		if(!con.isClosed()) con.close();
	}
	
	public Connection connect() {
		if(con == null) {
			con = c2s.connect();
		}else {
			System.out.println("conntecting server");
		}
		return con;
	}
	
	public Item findbyID(int id)throws SQLException{
		Item item = null;
		int tempCategoryID = -1;
		connect();
		stmtString = "select * from item where itemID = "+id;
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		if(rs != null) {
			item = new Item();
			item.setItemID(rs.getInt(1));
			item.setItemName(rs.getString(2));
			item.setItemPrice(rs.getDouble(3));
			item.setItemDesc(rs.getString(4));
			tempCategoryID = rs.getInt(5);
			//item.setCategory(findByID(id));
			item.setPhotoLocalDirectory(rs.getString(6));
			item.setPhotoCloudDirectory(rs.getString(7));	
			close();
		}else {
			System.out.println("cannot find data which ItemID is "+id);
		}
		//get category;
		if(tempCategoryID > 0) {
			item.setCategory(findByID(tempCategoryID));
		}
		return item;
	}
	
	
	public Category findByID(int id) throws SQLException {
		Category category = null;
		executedResult = false;
		con =  c2s.connect();		
		if(con != null) {
			stmtString = "select * from category where categoryID = " + id;
			preparedStmt  = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			if(rs != null) {
				category = new Category();
				category.setCategoryID(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setMenuID(rs.getInt(3));				
			}else {
				System.out.println("Cannot find the data by categoryID, "+id);
			}
		}else {
			System.out.println("Server connect fail.");
		}
		close();
		return category;
	}
	
	public boolean isExisting(String table, int id) throws SQLException {
		connect();
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
		rs = preparedStmt.executeQuery(stmtString);
		rs.next();
		return rs.getInt(1) > 0 ?  true: false;		
	}
	
	
	public int qtyData(String table) throws SQLException {
		connect();
		stmtString = "select count(*) from " + table.toLowerCase();
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		rs.next();
		int qty = rs.getInt("count(*)");	
		close();
		return qty;
	}
	
	
	public boolean insert(Item item) throws SQLException {
		connect();
		executedResult = false;
		if(item == null && isExisting("item", item.getItemID()) ) {
			System.out.println("item is incorrect.");
		}else {
			stmtString = "insert into item (itemID, itemName, itemPrice, itemDesc, categoryID,photoLocalDirectory,photoCloudDirectory) "
					+ "Values(?,?,?,?,?,?)";
			//create MySQL insert preparedstatement
			preparedStmt = con.prepareStatement(stmtString);
			if(item.getItemID() > 0 && findbyID(item.getItemID())== null) {
				preparedStmt.setInt(1, item.getItemID());
			}
			preparedStmt.setString(2, item.getItemName());
			preparedStmt.setDouble(3, item.getItemPrice());
			preparedStmt.setString(4, item.getItemDesc());
			if(item.getCategory() == null) {
				System.out.println("Category cannot be null.");
			}else if (findByID(item.getCategory().getCategoryID()) == null) {
				insert(item.getCategory());				
			}else {
				preparedStmt.setInt(5, item.getCategory().getCategoryID());
			}
			preparedStmt.setString(6, item.getPhotoLocalDirectory());
			preparedStmt.setString(7, item.getPhotoCloudDirectory());
			
	      // execute the preparedstatement
			if (preparedStmt.executeUpdate()== 1) executedResult = true;	     
		}
		close();
		return executedResult;
		
	}
	
	public boolean insert(Category category) throws SQLException {
		connect();
		executedResult = false;
		if(category != null && !isExisting("category", category.getCategoryID())) {
			stmtString = "insert into category (categoryID, categoryName, menuID) " + 
					"Values (?,?,?)";
			preparedStmt = con.prepareStatement(stmtString);
			preparedStmt.setInt(1, category.getCategoryID());
			preparedStmt.setString(2, category.getCategoryName());
			preparedStmt.setInt(3, category.getMenuID());
			if (preparedStmt.executeUpdate()== 1) executedResult = true;
		}else {
			System.out.println("the Object, category is existing or ID is incorrect. ");
		}			
		close();
		return executedResult;
	}
	
	public boolean update(Item item) throws SQLException {
		executedResult = false;
		connect();
		if(item != null && isExisting("item", item.getItemID())) {
			stmtString = "update item "
					+ "set itemName=?, itemPrice=?, itemDesc=?, categoryID=?"
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
	
	public boolean update(Category category) throws SQLException {
		executedResult = false;
		if(category != null && isExisting("category", category.getCategoryID())) {
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
	 * 
	 * @param table
	 * @return
	 * @throws SQLException
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
		return executedResult;
	}
	
	
}
