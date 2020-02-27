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
	List<Menu> menuList;
	
	//attributes
	Item item;
	Menu menu;
	
	public List<Menu> findAll() throws SQLException {
		//connect;
		executedResult = false;
		con = c2s.connect();
		if(con != null) {
			stmtString = "select * from menu";				
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();	
			if(rs != null) {			
				menuList =  new ArrayList<Menu>();
				while(rs.next()) {	
					menu = new Menu();
					menu.setMenuID(rs.getInt("menuID"));
					menu.setMenuName(rs.getString("menuName"));
					menuList.add(menu);
				}
			}
			preparedStmt.close();
			rs.close();
			con.close();
		}else {
			System.out.println("Connecting to server fail, please check the connection.");
		}
		
		return menuList;		

	}
	

	
}
