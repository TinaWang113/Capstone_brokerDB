/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Table;
import server.Connect2Server;

/**
 * @author 730693
 *
 */
public class TableBroker {	
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	boolean executedResult = false;
	List <Table> tables; 
	/*implement Survey later */
	
	public boolean insertTable(Table table){
		try {				
			if(table.getTableID() == 0 || !isExisting(table)) {
				connect();	
				//  `tableID`,  `startTime`, `endTime`, `tableStatus`
				stmtString = "insert `table` (tableID, startTime, endTime, tableStatus)"
						+ "values  (?, ?,?,?)";
			}else {			
				System.out.println("the table, "+ table.getTableStatus()+" is existing in DB");
				close();
				return false;
			}
			
			preparedStmt = con.prepareStatement(stmtString);
			if(table.getTableID() == 0) {
				preparedStmt.setString(1, null);
			}else {
				preparedStmt.setInt(1, table.getTableID());
			}
			preparedStmt.setDate(2, table.getStartTime());
			preparedStmt.setDate(3, table.getEndTime());
			preparedStmt.setInt(4, table.getTableStatus());
			
			if (preparedStmt.executeUpdate() == 1) executedResult = true;		
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executedResult;
		
	}
	
	
	public boolean isExisting(Table table) {
		executedResult = false;
		if(!(table.getTableID() >0)) {
			return false;
		}else {
			try {
				connect();
				stmtString = "select count(*) from `table` "
						+ "where tableID = " + table.getTableID()+ " AND startTime = " + table.getStartTime();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.execute()) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return executedResult;
		}
	}
	
	public boolean update(Table table) {
		executedResult = false;
		if(!isExisting(table)) {
			System.out.println("Table isn't existing, please check table data.");
			//here can implement the exception handling to throw the noExisitng Exception ....
		}else {
			try {
			//  `tableID`,  `startTime`, `endTime`, `tableStatus`
				connect();
				/*
				stmtString = "update table SET "
						+ " startTime= " + table.getStartTime() + " endTime ="+ table.getEndTime()
						+ " tableStatus=" + table.getTableStatus() + " where tableID = "+table.getTableID();
				*/
				stmtString = "update `table` SET "
						+ " endTime ="+ table.getEndTime()
						+ " tableStatus=" + table.getTableStatus() + " where tableID = "+table.getTableID();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return executedResult;
	}
	
	
	public boolean updateStatus(Table table) {
		executedResult = false;
		if(!isExisting(table)) {
			System.out.println("Table isn't existing, please check table data.");
			//here can implement the exception handling to throw the noExisitng Exception ....
		}else {
			try {
				connect();
				stmtString = "update `table` "
						+ "tableStatus=" + table.getTableStatus() + "where tableID = "+table.getTableID();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					executedResult = true;
				}
				close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	

		return executedResult;
	}
	
	public boolean delete(Table table) {
		executedResult = false;
		if(table.getTableID() > 0 && table.getStartTime() != null) {
			try {
				connect();			
				stmtString = "delete from `table` "
						+ "where tableID = " + table.getTableID() +" AND startTime = " + table.getStartTime();
				preparedStmt = con.prepareStatement(stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					System.out.println("[Table]deleted.");
					executedResult = true;
				}
				close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Table ID cannot equal or small than 0, "+table.getTableID()+ ". Or startTime cannot be null");		
		}
		return executedResult;	
	}
	
	
	private boolean deleteAll() {
		executedResult = false;
		try {
			connect();			
			stmtString = "delete from `table`";
			preparedStmt = con.prepareStatement(stmtString);
			if(preparedStmt.executeUpdate() == 1) {
				System.out.println("[Table] All data is deleted.");
				executedResult = true;
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return executedResult;
		
	}
	
	public int qtyData() {
		int qty = 0;
		try {
			stmtString = "select count(*) from `table`";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			rs.next();
			qty =  rs.getInt(1);
			System.out.println("[qtyDate]Table #"+qty);
			close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qty;
	}
	
	public Table findByID(int tableID, Date startTime) {
		Table table = new Table(tableID, startTime, null,0);
		if(isExisting(table)) {
			try {
				connect();
				stmtString = "select endTime, tableStatus from `table` "
						+ "where tableID = "+ tableID + " AND startTime = "+ startTime;
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();
				rs.next();
				table.setEndTime(rs.getDate(1));
				table.setTableStatus(rs.getInt(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("No table matches the TableID and startTime");
		}
		
		return table;
	}
	
	public Table findByID(Table table) {
		if(isExisting(table)) {
			try {
				connect();
				stmtString = "select endTime, tableStatus from `table` "
						+ "where tableID = "+ table.getTableID() + " AND startTime = "+ table.getStartTime();
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();
				rs.next();
				table.setEndTime(rs.getDate(1));
				table.setTableStatus(rs.getInt(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("No table matches the TableID and startTime");
		}
		
		return table;
	}
	
	public List<Table> findAll(){
		tables = new ArrayList<Table> ();
		try {
			connect();
			stmtString = "select * from `table`";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
			//  `tableID`,  `startTime`, `endTime`, `tableStatus`
				Table table = new Table();
				table.setTableID(rs.getInt("tableID"));
				table.setStartTime(rs.getDate("startTime"));
				table.setEndTime(rs.getDate("endTime"));
				table.setTableStatus(rs.getInt("tableStatus"));
				tables.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tables;
	}
	
	

	private void close() throws SQLException {
		if(rs.isClosed()) rs.close();
		if(!preparedStmt.isClosed()) preparedStmt.close();
		if(!con.isClosed()) con.close();
	}
	
	private Connection connect() throws SQLException {
		if(con != null) {
			con.close();
		}
		con = c2s.connect();
		return con;
	}
	
}
