/**
 * 
 */
package server;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

//import com.mysql.cj.jdbc.DatabaseMetaData;

/**
 * @author 730693
 *
 */
public class Connect2Server{
	//attributes
	static Connection con = null;
//	private final static String URL = "jdbc:mysql://harbor.cc7dvrrj6n2j.ca-central-1.rds.amazonaws.com:3306/";
	private final static String URL =  "jdbc:mysql://localhost:3306/";
//	private final static String USERNAME = "admin";
	private final static String USERNAME = "root";
//	private final static String PW = "password1234";
	private final static String PW = "password";
	private final static String DBNAME = "capstone2020";
	//for mysql 6.0up 
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	//for mysql 5.0
	//com.mysql.jdbc.Driver
	
	public  Connect2Server(){
		
	}
	
	public Connection connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL + DBNAME, USERNAME, PW);
			//[Test] listing all tables in database
			/*
			if( con != null){
				ResultSet rs = null;
				DatabaseMetaData meta = (DatabaseMetaData) con.getMetaData();
			      rs = meta.getTables(null, null, null, new String[] {
			         "TABLE"
			      });
			 int count = 0;
		      System.out.println("All table names are in test database:");
		      while (rs.next()) {
		         String tblName = rs.getString("TABLE_NAME");
		         System.out.println(tblName);
		         count++;
		      }
		      System.out.println(count + " Rows in set ");
		      
			}
			
			*/
		}catch(Exception e) {
			System.out.println(e);			
		}
	
		return con;
	}

	
	
	// [2020.01.21] for testing
	/*
	public static void main(String[] args) {
		connect();		

	}
	*/

}
