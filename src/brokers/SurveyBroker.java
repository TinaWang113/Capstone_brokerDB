/**
 * 
 */
package brokers;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Survey;
import model.Table;
import server.Connect2Server;

/**
 * SurveyBroker
 * 	communicating to server for Surey object/database
 * @author 730693
 *
 */
public class SurveyBroker {
	TableBroker tBroker = new TableBroker();
	List<Survey> surveys;
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	boolean executedResult;
	
	/**
	 * InsertSurvey
	 * 	insert data into database
	 * @param survey Survey object.
	 * @return boolean  true if insert is success, otherwise the return is false
	 * @throws SQLException  Exception if SQL has any problem.
	 */
	
	public boolean InsertSurvey(Survey survey) throws SQLException {
		executedResult = false;
		//start - verify
		for (Field f : survey.getClass().getFields()) {
			  f.setAccessible(true);
			  System.out.println("[SB_insert]Field= "+ f.getName());
			  try {
				  if(f.getName().contains("surveyID")||f.getName().contains("tableID")||f.getName().contains("table_startTime")) {
					  if (f.get(survey) == null || f.getDouble(survey) < 0.0) {
						System.out.println("[SB_insert] All survey cannot be null or small than 0.");
						return executedResult;
					  }
				  }
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(survey.getSurveyAs().size() != 8) {
			System.out.println("[SB_insert] all survey should have value.");
			return executedResult;
		}else {
			for(double c: survey.getSurveyAs()) {
				if(c < 0) {
					System.out.println("[SB_insert] survey value should be large than 0.");
					return executedResult;
				}
			}
		}
		// verify done
		Table table = new Table(survey.getTableID(),survey.getTable_startTime());
		//don't need to check if it is existing.
		if(tBroker.isExisting(table)) {							
			connect();
			stmtString = "insert into capstone2020.survey (surveyA1, surveyA2, surveyA3, surveyA4, surveyA5, " + 
					"surveyA6, surveyA7, surveyA8, table_tableID, table_startTime) Values(?,?,?,?,?,?,?,?,?,?)";
			preparedStmt = con.prepareStatement(stmtString);
			for(double c: survey.getSurveyAs()){
				System.out.println("[sb_insert] Survey Value: " + c);
			}
			for(int i=0; i< survey.getSurveyAs().size(); i++) {				
				preparedStmt.setDouble((i+1), survey.getSurveyAs().get(i));
			}
			preparedStmt.setInt(9, survey.getTableID());
			preparedStmt.setTimestamp(10, survey.getTable_startTime());
			System.out.println("[sb_inset]"+survey.getTable_startTime());
			System.out.println(preparedStmt.executeUpdate());
		    executedResult = true;
			preparedStmt.close();
			con.close();
		}else {
			System.out.println("[SB_insert] the survey is existing or table is not existing.");
		}			
		
		return executedResult;
	}
		
	/**
	 * isExisitng
	 * 	check id is existing or not.
	 * @param survey Survey object. surveyID cannot be null or small than 0
	 * @return boolean indicating the ID is existing in DB, or not
	 * @throws SQLException Exception if SQL has any problem.
	 */
	
	public boolean isExisting(Survey survey) throws SQLException {
		executedResult = false;
		connect();
		if(survey.getSurveyID() > 0) {
			stmtString = "select count(*) from capstone2020.survey"
					+ " where surveyID = " + survey.getSurveyID();
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			rs.next();
			if(rs.getInt("count(*)") == 1) {
				executedResult = true;
			}
			close();			
		}else {
			System.out.println("[SB_isExisting] SurveyID should not be small than and equal 0.");
		}

		return executedResult;
	}
		
	/**
	 * getSurvey
	 * 	find Survey data with the survey ID
	 * @param surveyID int SurveyID must be integer and cannot small than 0
	 * @return survey Survey object if the data is existing in database; otherwise null.
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public Survey getSurvey(int surveyID) throws SQLException {
		executedResult = false;
		Survey getSurvey = null;
		connect();
		if(surveyID < 1) {
			System.out.println("[SB_getSurvey] surveyID should be large than 1");
		}else {
			stmtString = "select * from capstone2020.survey "
					+ "where surveyID = " + surveyID;
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				getSurvey = new Survey();
				getSurvey.setSurveyID(rs.getInt(1));
				ArrayList<Double> surveyAs = new ArrayList<Double>();
				for(int i = 0; i< getSurvey.getNUMQUESTIONS(); i++) {
					surveyAs.add(rs.getDouble(i+2));
				}
				getSurvey.setSurveyAs(surveyAs);
				getSurvey.setTableID(rs.getInt(10));
				getSurvey.setTable_startTime(rs.getTimestamp(11));
			}
			close();
		}
		return getSurvey;
	}
	
	
	/**
	 * getSurvey
	 * 	find Survey data with the survey ID
	 * @param survey Survey object which SurveyID must be integer and cannot small than 0
	 * @return survey Survey object if the data is existing in database; otherwise null.
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public Survey getSurvey(Survey survey) throws SQLException {
		executedResult = false;
		Survey getSurvey = null;
		connect();
		if(survey.getSurveyID() < 1) {
			System.out.println("[SB_getSurvey] surveyID should be large than 1");
		}else {
			stmtString = "select * from capstone2020.survey "
					+ "where surveyID = " + survey.getSurveyID();
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				getSurvey = new Survey();
				getSurvey.setSurveyID(rs.getInt(1));
				ArrayList<Double> surveyAs = new ArrayList<Double>();
				for(int i = 0; i< getSurvey.getNUMQUESTIONS(); i++) {
					surveyAs.add(rs.getDouble(i+2));
				}
				getSurvey.setSurveyAs(surveyAs);
				getSurvey.setTableID(rs.getInt(10));
				getSurvey.setTable_startTime(rs.getTimestamp(11));
			}
			close();
		}
		return getSurvey;
	}
	
	/**
	 * getSurvey
	 * 	find Survey data with the survey ID
	 * @param tableID int tableID cannot be null or small than 0
	 * @param table_startTime Timestamp cannot be null
	 * @return survey Survey Object if the data can be found in survey Database; otherwise it will be null
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public Survey getSurvey(int tableID, Timestamp table_startTime) throws SQLException {
		executedResult = false;
		Survey getSurvey = null;
		Table table = new Table(tableID, table_startTime);
		connect();
		if(tBroker.isExisting(table)) {			
			stmtString = "select * from capstone2020.survey "
					+ "where table_tableID = " + tableID + " AND table_startTime = '" + table_startTime.toString()+"'";
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				getSurvey = new Survey();
				getSurvey.setSurveyID(rs.getInt(1));
				ArrayList<Double> surveyAs = new ArrayList<Double>();
				for(int i = 0; i< getSurvey.getNUMQUESTIONS(); i++) {
					surveyAs.add(rs.getDouble(i+2));
				}
				getSurvey.setSurveyAs(surveyAs);
				getSurvey.setTableID(rs.getInt(10));
				getSurvey.setTable_startTime(rs.getTimestamp(11));
			}
			close();
		}else {
			System.out.println("[SB_getSurvey] Survey isn't existing.");
		}
		return getSurvey;
	}
	
	/**
	 * getAll
	 * 	get all data from database, Survey
	 * @return surveys ArrayList with Survey datatype; otherwise null.
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public ArrayList<Survey> getAll() throws SQLException{
		connect();
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		/*
		stmtString = "select surveyID, surveyA1, surveyA2, surveyA3,surveyA4, surveyA5," + 
				"surveyA6, surveyA7, surveyA8, table_tableID, table_startTime from capstone2020.survey";
				*/
		stmtString = "select * from capstone2020.survey";
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		while(rs.next()) {
			Survey survey = new Survey();
			survey.setSurveyID(rs.getInt(1));
			ArrayList<Double> surveyAs = new ArrayList<Double>();
			for(int i = 0; i< survey.getNUMQUESTIONS(); i++) {
				surveyAs.add(rs.getDouble(i+2));
			}
			survey.setSurveyAs(surveyAs);
			survey.setTableID(rs.getInt(10));
			survey.setTable_startTime(rs.getTimestamp(11));
			
			surveys.add(survey);
		}
		return surveys;
		
	}
	
	/**
	 * deleteByID
	 * 	delete Survey data by surveyID
	 * @param survey Survey object, the survey cannot be null or small than 0
	 * @return boolean  true if indicating the ID is existing in DB, or not
	 * @throws SQLException SQLException Exception if SQL has any error.
	 */
	public boolean deleteByID(Survey survey) throws SQLException {
		executedResult = false;
		if(survey.getSurveyID() < 1 || survey == null) {
			System.out.println("[SB_deleteByID] surveyID or survey object is incorrect.");
		}else {
			connect();
			stmtString = "delete from capstone2020.survey where surveyID = " + survey.getSurveyID();
			preparedStmt = con.prepareStatement(stmtString);
			if(preparedStmt.executeUpdate() == 1) {
				executedResult = true;
			}
			close();
		}
		
		return executedResult;
	}
	
	 /**
	 * deleteAll
	 * @param tableName String tableName
	 * @return executedResult int the number of DB has been deleted  
	 * @throws SQLException Exception if SQL has any problem.
	 */
	
	private boolean deleteAll() throws SQLException {
		executedResult = false;
		connect();
		stmtString = "delete from capstone2020.survey";
		preparedStmt = con.prepareStatement(stmtString);
		if(preparedStmt.executeUpdate() > 0) {
			executedResult = true;
		}
		close();
		return executedResult;
	}
	
	/**
	 * dataQty 
	 * 	total number of database
	 * @return int the qty of data
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public int qtyData() throws SQLException {
		connect();
		stmtString = "select count(*) from capstone2020.survey";
		preparedStmt = con.prepareStatement(stmtString);
		rs = preparedStmt.executeQuery();
		rs.next();
		int qty = rs.getInt("count(*)");
		close();
		return qty;
	}
	
	/**
	 * update
	 * 	update data of survey 
	 * @param survey Survey object which surveyID cannot be null
	 * @return boolean true if updating success; otherwise false
	 * @throws SQLException Exception if SQL has any problem.
	 */
	public boolean update(Survey survey) throws SQLException {
		//check ID, check FK
		Table checkTable = new Table(survey.getTableID(), survey.getTable_startTime());
		if(!isExisting(survey)) {
			System.out.println("[SB_update] survey is not existing in DB.");
		}else if(!tBroker.isExisting(checkTable)) {
			System.out.println("[SB_update]The table ID and Table_start time is not matching, please check table Table.");
		}else {
			connect();
			stmtString = "update capstone2020.survey set surveyA1 = ?, surveyA2 = ?, surveyA3 = ?, surveyA4 = ?, surveyA5 = ?, " 
			     +" surveyA6 = ?, surveyA7 = ?, surveyA8 = ?, table_tableID = ?, table_startTime = ?";
			preparedStmt = con.prepareStatement(stmtString);
			for(int i=0; i<survey.getNUMQUESTIONS(); i++) {
				preparedStmt.setDouble((i+1), survey.getSurveyAs().get(i));
			}
			preparedStmt.setInt(9, survey.getTableID());
			preparedStmt.setTimestamp(10, survey.getTable_startTime());
			if(preparedStmt.executeUpdate()==1) {
				executedResult = true;
			}
		}			
		
		close();
		return executedResult;
		
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
