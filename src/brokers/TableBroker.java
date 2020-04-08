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

import model.Survey;
import model.Table;
import server.Connect2Server;

/**
 * TableBroker 
 * 	communicating data to server
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

	/**
	 * insertTable 
	 * 	insert data to table table
	 * @param table Table object. staff_sID cannot not be null, or not match staff table
	 * @return boolean true if data inserts success; otherwise false
	 * @throws SQLException if any exception during running query
	 */
	
	public boolean insertTable(Table table) throws SQLException{
		executedResult = false;
		System.out.println("[Table] insertTable");
		System.out.println("[TB_insert] table = "+ table.toString());
		StaffBroker sBroker = new StaffBroker();
		if(!sBroker.isExisitng(table.getStaff_sID())) {
			System.out.println("[TB_insert] the StaffID is incorrect, which not in staff DB.");
		}else {
			try {				
				if(table.getTableID() > 0 || table.getStartTime() != null) {
					if( !isExisting(table)) {
						connect();	
						//  `tableID`,  `startTime`, `endTime`, `tableStatus`, `staff_sID`
						stmtString = "insert capstone2020.`table` (tableID, startTime, endTime, tableStatus, staff_sID)"
									+  " values  (?,?,?,?,?)";		
					
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
						preparedStmt.setInt(5, table.getStaff_sID());
						if (preparedStmt.executeUpdate() == 1) {
							executedResult = true;		
						} 
						preparedStmt.close();
						con.close();
					}else {
						System.out.println("the table, "+ table.getTableID()+" is existing in DB.");
					}				
				}else {			
					System.out.println("the startTime or tableID is incorrect.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("[TB] executedResult: " + executedResult);
		return executedResult;
		
	}
	
	/**
	 * inExisting
	 * 	checking the data if it exists in database
	 * @param table Table object, tableID and start time cannot be null.
	 * @return boolean true if the data is existing in database; otherwise false.
	 */
	
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
	
	
	/**
	 * update 
	 * 	update data which is existing in database
	 * @param table Table object. tableID and start time cannot be null.
	 * @return boolean true if updating success; otherwise false
	 */
	
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
						+ " endTime ="+ table.getEndTime() + " tableStatus=" + table.getTableStatus() + " staff_sID = " +table.getStaff_sID() 
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
	
	/**
	 * updateStatus
	 * 	update variable, Status, only.
	 * @param table Table object. tableID and start time cannot be null.
	 * @return boolean true if updating success; otherwise false
	 */
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
	
	/**
	 * delete
	 * 	delete table from database
	 * @param table Table object. table ID and start time cannot be null
	 * @return boolean true if delete success; otherwise false.
	 */
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
	
	/**
	 * deleteAll
	 * 	delete all data in the Table database
	 * @return boolean true if all data has been deleted in table Table.
	 */
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
	
	/**
	 * dataQty 
	 * 	total number of database
	 * @return int the qty of data
	 */
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
	
	/**
	 * findByID
	 * find table data by the tableID and start time
	 * @param tableID int tableID has be digits and large then 0
	 * @param startTime timestamp cannot be null
	 * @return table Table object if the table can be found in Table database
	 */
	public Table findByID(int tableID, Timestamp startTime) {
		Table table = new Table(tableID, startTime);
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
				table.setStaff_sID(rs.getInt("staff_sID"));
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
	
	/**
	 * findByID
	 * 	find table data by the tableID and start time
	 * @param table Table tableID and start time cannot be null
	 * @return table Table if the data in table database
	 */
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
				table.setStaff_sID(rs.getInt("staff_sID"));
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
	
	/**findAll
	 * 
	 * @return List containing the object
	 */
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
				table.setStaff_sID(rs.getInt("staff_sID"));
				tables.add(table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tables;
	}
	
	
	/**
	 * close
	 * 	close all connection between database.
	 * @throws SQLException if any exception during running query
	 */
	

	private void close() throws SQLException {
		if(!rs.isClosed()) rs.close();
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
	
	
}
