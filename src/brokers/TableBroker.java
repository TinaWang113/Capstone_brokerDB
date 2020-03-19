/**
 * 
 */
package brokers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		executedResult = false;
		System.out.println("[Table] insertTable");
		System.out.println("[TB_insert] table = "+ table.toString());
		try {				
			if(table.getTableID() > 0 || table.getStartTime() != null) {
				if( !isExisting(table)) {
					connect();	
					//  `tableID`,  `startTime`, `endTime`, `tableStatus`
					stmtString = "insert capstone2020.`table` (tableID, startTime, endTime, tableStatus)"
								+  " values  (?,?,?,?)";		
				
					preparedStmt = con.prepareStatement(stmtString);
	
					preparedStmt.setInt(1, table.getTableID());
					preparedStmt.setString(2,table.getStartTime().toString());
					if(table.getEndTime() == null) {
						preparedStmt.setObject(3,null);
					}else {
						preparedStmt.setString(3,table.getEndTime().toString());
					}
					preparedStmt.setInt(4, table.getTableStatus());
					//System.out.println("[TableBroker]insertTable_stmt = " + preparedStmt.toString());
					if (preparedStmt.executeUpdate() == 1) {
						executedResult = true;		
					}
					preparedStmt.close();
					con.close();
				}else {
					
				}				System.out.println("the table, "+ table.getTableID()+" is existing in DB.");
			}else {			
				System.out.println("the startTime or tableID is incorrect.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("[TB] executedResult: " + executedResult);
		return executedResult;
		
	}
	
	
	public boolean isExisting(Table table) {
		executedResult = false;
		try {
			if(table.getTableID() > 0) {
				connect();
				//System.out.println("[TB_isExisting] table = " + table.toString());
				stmtString = "SELECT count(*) FROM capstone2020.`table` "
						+ "where tableID = " + table.getTableID()+ " AND startTime = '" + table.getStartTime()+"'";
				//System.out.println("[Table_isExisting] stmtString = " + stmtString);
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery(stmtString);
				rs.next();
				if(rs.getInt(1)==1) {
					executedResult =true;
				}
				//System.out.println("[Table_isExisting] executedResult= "+executedResult);
				rs.close();
				preparedStmt.close();
				con.close();
			} 
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			return executedResult;
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
				stmtString = "update table SET "
						+ " endTime ="+ table.getEndTime() + " tableStatus=" + table.getTableStatus() 
						+ " where tableID = "+table.getTableID() +" AND startTime = '"+table.getStartTime().toString()+"'";
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[TB]updateStauts: "+ stmtString);
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
				stmtString = "update capstone2020.`table` set  tableStatus =" + table.getTableStatus() 
				+ " where tableID = "+table.getTableID() +" AND startTime = '"+table.getStartTime().toString()+"'";
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[TB]updateStauts: "+ stmtString);
				if(preparedStmt.executeUpdate() == 1) {
					System.out.println("[TB]updateStatus: success");
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
				stmtString = "delete from capstone2020.`table` "
						+ "where tableID = " + table.getTableID() +" AND startTime = '" + table.getStartTime().toString() + "'";
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
			stmtString = "delete from capstone2020.`table`";
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
			connect();
			stmtString = "SELECT count(*) FROM capstone2020.`table`";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			rs.next();
			qty = rs.getInt("count(*)");
			//System.out.println("[qtyDate]Table #"+qty);
			close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qty;
	}
	
	public Table findByID(int tableID, Timestamp startTime) {
		Table table = new Table(tableID, startTime, null,0);
		if(isExisting(table)) {
			try {
				connect();
				stmtString = "select endTime, tableStatus from capstone2020.`table` "
						+ "where tableID = "+ tableID + " AND startTime = '"+ startTime + "'";
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[TB]findByID: "+stmtString);
				rs = preparedStmt.executeQuery();
				rs.next();
				table.setEndTime(rs.getTimestamp(1));
				table.setTableStatus(rs.getInt(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			table = null;
			System.out.println("No table matches the TableID and startTime");
		}
		
		return table;
	}
	
	public Table findByID(Table table) {
		System.out.println("[TB]findByID:" + table.toString());
		if(isExisting(table)) {
			try {
				connect();
				stmtString = "select endTime, tableStatus from capstone2020.`table` "
						+ "where tableID = "+ table.getTableID() + " AND startTime = '"+ table.getStartTime()+"'";
				preparedStmt = con.prepareStatement(stmtString);
				System.out.println("[TB]findByID: "+stmtString);
				rs = preparedStmt.executeQuery();
				rs.next();
				table.setEndTime(rs.getTimestamp(1));
				table.setTableStatus(rs.getInt(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			table = null;
			System.out.println("No table matches the TableID and startTime");
		}
		
		return table;
	}
	
	public List<Table> findAll(){
		tables = new ArrayList<Table> ();
		try {
			connect();
			stmtString = "select * from capstone2020.`table`";
			//System.out.println("[Table]FinaAll: " + stmtString);
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
			//  `tableID`,  `startTime`, `endTime`, `tableStatus`
				Table table = new Table();
				table.setTableID(rs.getInt("tableID"));
				table.setStartTime(rs.getTimestamp("startTime"));
				table.setEndTime(rs.getTimestamp("endTime"));
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
		if(!rs.isClosed()) rs.close();
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
