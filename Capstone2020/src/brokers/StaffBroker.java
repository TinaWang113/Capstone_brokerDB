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

//import com.mysql.cj.xdevapi.Table;

import model.Job;
import model.Staff;
import server.Connect2Server;
//import sun.security.action.GetIntegerAction;

/**
 * @author 730693
 * StaffBroker:	
 * 	Communicating DB and Model
 *  Including job database and staff database
 *
 */
public class StaffBroker {
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	Job job;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	/**
	 * insert
	 * 	insert the jobID and job description 
	 * @param job object JOB
	 * @return boolean , true is success. false is fail.
	 * @throws SQLException
	 */
	/* [2020.02.11] for removing the job table
	public boolean insert(Job job) throws SQLException{		
			//connect;			
		con = c2s.connect();
		int executedResult = -1;
		if(con != null) {
			try {			
					// MYSQL insert statement
				
					stmtString = " insert into job (jobID, jobName)"
							+ " VALUES (?, ?)";
					preparedStmt = con.prepareStatement(stmtString);
					//create MySQL insert preparedstatement
					preparedStmt.setInt(1, job.getjobID());
					preparedStmt.setString (2, job.getJobName());
			      // execute the preparedstatement			     

					executedResult = preparedStmt.executeUpdate();	     
			} catch (SQLException e) {
				con.close();
				System.out.println("Insert data is wrong. Caused reason: duplication id or data.");
				e.printStackTrace();
			}
		}else {
			System.out.println("Connecting fail, please check settings.");
		}
		preparedStmt.close();
		con.close();
		if(executedResult > 0) {
			System.out.println("insert success.");
			return true;
		}
		return false;	
	}
	*/
	/**
	 * insert data into database
	 * @param object Staff staff
	 * @return boolean  true if insert is success, otherwise the return is false
	 * @throws SQLException  Exception if SQL has any problem.
	 */
	
	public boolean insert(Staff staff) throws SQLException {
		//connect;
		int executedResult = -1;
		con = c2s.connect();
		if(con != null) {
			try {						
				staff.toString();
				// MYSQL insert statement
				//removed isActive in order to submit to the database - Nathan
				stmtString = "INSERT INTO staff (sID, pin, isActive, fName, lName, contactNum, jobName) "
						+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
				//create MySQL insert preparedstatement
				preparedStmt = con.prepareStatement(stmtString);
				preparedStmt.setInt(1, staff.getsID());
				preparedStmt.setString (2, staff.getPin());
				preparedStmt.setString (3, staff.getIsActive());	
				preparedStmt.setString (4, staff.getfName());
				preparedStmt.setString (5, staff.getlName());
				preparedStmt.setString (6, staff.getContactNum());
				preparedStmt.setString(7, staff.getJobName());

		      // execute the preparedstatement
			     
				executedResult = preparedStmt.executeUpdate();	     
			} catch (SQLException e) {
				con.close();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Connecting fail, please check settings.");
		}
		preparedStmt.close();
		con.close();
		if(executedResult > 0) {
			System.out.println("insert success.");
			return true;
		}
		return false;		
	}	
	
	/**
	 * isExisitng
	 * 	check id is existing or not.
	 * @param tableName String 
	 * @param id Sting 4 characters ID
	 * @return boolean indicating the ID is existing in DB, or not
	 * @throws SQLException
	 */
	public boolean isExisitng(int id) throws SQLException {
		//connect
		int result= -1;
		con = c2s.connect();
		if(con != null) {			
			stmtString = "select count(*) from staff where sID = " + id;	
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery(stmtString);
			rs.next();
			result = rs.getInt(1);
		}else {
			System.out.println("Connecting server fail.");
		}
		preparedStmt.close();
		rs.close();
		con.close();	
		
		return result > 0 ?  true: false;		
	}
	
	/**
	 * findByID
	 * @param ID 4 characters ID
	 * @param tableName String table name
	 * @return list of searching result.
	 * @throws SQLException
	 */
	//public List<Staff> findByIDList( String id) throws SQLException {
	public Staff findByIDList(int id) throws SQLException {
		//connect
		Staff staff = new Staff();
		System.out.println(id + " ID");
		con = c2s.connect();	
		if(con != null) {	 
			stmtString = "select * from staff where sID = " + id;
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();	
		}else {
			System.out.println("Connecting server fail.");
		}
		System.out.println("[findByIDList] get data from DB success.");
		rs.next();
		System.out.println("result:" + rs);
		staff.setsID(rs.getInt(1));
		staff.setPin(rs.getString(2));
		staff.setIsActive(rs.getString(3));
		staff.setfName(rs.getString(4));
		staff.setlName(rs.getString(5));
		staff.setContactNum(rs.getNString(6));
		staff.setJobName(rs.getString(7));
		System.out.println(staff.toString());
//		List<Staff> listResultList = listing(rs);
		preparedStmt.close();
		rs.close();
		con.close();
		return staff;
		
	}
	
	
	/**
	 * delete 
	 * 	delete data by staffID
	 * @param tableName String table name
	 * @param id String, size == 4
	 * @return boolean true, the data has been deleted. False, deleting fail.
	 * @throws SQLException
	 */
	public boolean delete(int id) throws SQLException {
		if(isExisitng(id)) {		
			//connect
			con = c2s.connect();
			if(con != null) {								
				stmtString = "delete from staff where sID = "+ id;
				preparedStmt = con.prepareStatement(stmtString);
				if( preparedStmt.executeUpdate() ==1) {
					return true;				
				}					
			}else {
				System.out.println("Connecting fail, please check settings.");
			}
			preparedStmt.close();
			con.close();
		}else {
			System.out.println("Staff is not existing in staff DB.");
		}
		return false;
	}
	
	/*
	 * delete
	 * 	delete data by Staff object.
	 * @param staff Staff object, the staffID cannot be null(mandatory).
	 * @return boolean true, the data has been deleted. False, deleting fail.
	 * @throws SQLException
	*/
		public boolean delete(Staff staff) throws SQLException  {
			if(isExisitng(staff.getsID())) {		
				//connect
				con = c2s.connect();
				if(con != null) {
					stmtString = "delete from staff where sID = "+ staff.getsID();
					preparedStmt = con.prepareStatement(stmtString);
					if( preparedStmt.executeUpdate() ==1) {
						return true;				
					}
						
				}else {
					System.out.println("Connecting fail, please check settings.");
				}
				preparedStmt.close();
				con.close();
			}else {
				System.out.println("Staff is not existing in staff DB.");
			}
			return false;
		}
	
		/**
		 * update
		 * 	update staff data
		 * @param staff Staff object, staff ID, sID cannot be empty and changed. the jobID must to existing in the Job table.
		 * @return boolean update 
		 * @throws SQLException
		 */
		public boolean update(Staff staff) throws SQLException{
			int result = -1;
			System.out.println("[Staff]"+staff.toString());			
			if(isExisitng(staff.getsID())) {
				try {		
					con = c2s.connect();
					// MYSQL insert statement
					stmtString = "update staff "
							+ "set pin = ?, isActive = ?, fName =?, lName =?, contactNum = ?, jobName= ?"
							+ " where sID = ?";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmtString);
					preparedStmt.setString (1, staff.getPin());
					preparedStmt.setString (2, staff.getIsActive());	
					preparedStmt.setString (3, staff.getfName());
					preparedStmt.setString (4, staff.getlName());
					preparedStmt.setString (5, staff.getContactNum());
					preparedStmt.setString(6, staff.getJobName());
					preparedStmt.setInt(7, staff.getsID());
					
			      // execute the preparedstatement
					result = preparedStmt.executeUpdate();     
				} catch (SQLException e) {
					con.close();
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("Staff ID not existing.");
			}
			con.close();
			preparedStmt.close();
			if(result > 0) {
				System.out.println("[Job_update] update success. ");
				return true;
			}else {
				return false;
			}
		}
		

		/**
		 * update
		 * 	update staff data
		 * @param staff Staff object, staff ID, sID cannot be empty and changed 
		 * @return boolean update 
		 * @throws SQLException
		 */
		/* [2020.02.11] for removing the job table
		public boolean update(Job job) throws SQLException{
			int result  = -1;
			//connect
			if(isExisitng("Job", job.getjobID())) {
				try {			
					con = c2s.connect();
					// MYSQL insert statement
					String stmt = " update job "
							+ "set jobName = ? where jobID = ?";
					//create MySQL insert preparedstatement
					preparedStmt = con.prepareStatement(stmt);					
					preparedStmt.setString(1, job.getJobName());
					preparedStmt.setInt(2, job.getjobID());
		 	       // execute the preparedstatement
					result = preparedStmt.executeUpdate();						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("job ID does not existing, or you cannot change the job ID");
			}
			con.close();
			preparedStmt.close();
			if(result > 0) {
				System.out.println("[Job_update] update success. ");
				return true;
			}else {
				return false;
			}
			
		}	
		*/
	/**
	 * listing function:
	 * 	covert the data from ResultSet into object list
	 * @param rs ResultSet from database
	 * @return list  staff data
	 * @throws SQLException
	 */
	public List<Staff> fillingData(ResultSet rs) throws SQLException {
		if(rs != null) {			
			List<Staff> staffs = new ArrayList<Staff>();
			while(rs.next()) {
				Staff staff = new Staff();
				staff.setsID(rs.getInt("sID"));
				staff.setfName(rs.getString("fName"));
				staff.setlName(rs.getString("lName"));
				staff.setPin(rs.getString("pin"));
				staff.setContactNum(rs.getString("contactNum"));
				staff.setJobName(rs.getString("jobName"));
				staff.setIsActive(rs.getString("isActive"));
				staffs.add(staff);
			}
			return staffs;
		}
		return null;

	}	
	/**findAll
	 * 
	 * @param tableName database name, cannot be null or empty
	 * @return List containing the object
	 * @throws SQLException
	 */
	
		public List<Staff> findAll() throws SQLException {
			//connect
			con = c2s.connect();	
			if(con != null) {	 
				stmtString = "select * from staff";				
				preparedStmt = con.prepareStatement(stmtString);
				rs = preparedStmt.executeQuery();	
			}else {
				System.out.println("Connecting server fail.");
			}
			//Commented out these few lines of code as they try to return another result set
			//Which then errors and returns a 404 - Nathan
//			System.out.println("[findAll] get data from DB success.");
//			System.out.println("[findAll] get Qty of Db: " + dataQty(tableName));
//			System.out.println("result:" + rs.toString());
			List<Staff> listResultList = fillingData(rs);

			preparedStmt.close();
			rs.close();
			con.close();
			return listResultList;
			
		}
	
	
	/**
	 * dataQty 
	 * 	total number of database
	 * @param tableName  the retrieving  data name
	 * @return int the qty of data
	 * @throws SQLException
	 */
	
	public int dataQty() throws SQLException {
		//connect
		con = c2s.connect();
		int qty = -1;
		if(con != null) {
			stmtString = "select count(*) from staff" ;
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery(stmtString);
			rs.next();
			qty = rs.getInt("count(*)");
		}
		//System.out.println("total number of data in "+tableName + " is "+ qty);
		rs.close();
		preparedStmt.close();
		con.close();
		return qty;
	}
	/**
	 * deleteAll
	 * @param tableName String tableName
	 * @return executedResult int the number of DB has been deleted  
	 * @throws SQLException
	 */
	public int deleteAll() throws SQLException {
		//connect
		con = c2s.connect();
		int executedResult = -1;		
		if(con != null) {			
	           // System.out.println("cleaning data....."+ tableName);
	            stmtString = "delete from staff" ;
				preparedStmt = con.prepareStatement(stmtString);
				executedResult = preparedStmt.executeUpdate();				
		}		
		preparedStmt.close();
		con.close();
		System.out.println("delete reuslt: " + executedResult );		
		return executedResult;
	}
		
	//[2020.01.21] for testing
	//if you need test code, please un-common it.
	/*
	public static void main(String[] args) {
		System.out.println("running");
		StaffBroker sb = new StaffBroker();		
	
	}
	*/
	
	
}
