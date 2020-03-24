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
 * @author 730693
 *
 */
public class SurveyBroker {
	TableBroker tBroker;
	List<Survey> surveys;
	Connect2Server c2s = new Connect2Server();
	Connection con = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	String stmtString="";
	boolean executedResult;
	
	
	
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
		if(!isExisting(survey) && tBroker.isExisting(table)) {							
			connect();
			stmtString = "insert into capstone2020.survey (surveyA1, surveyA2, surveyA3,surveyA4, surveyA5, " + 
					"surveyA6, surveyA7, surveyA8, table_tableID, table_startTime) Values(?,?,?,?,?,?,?,?,?,?)";
			preparedStmt = con.prepareStatement(stmtString);
			for(int i=0; i< survey.getSurveyAs().size(); i++) {
				preparedStmt.setDouble((i+1), survey.getSurveyAs().get(i));
			}
			preparedStmt.setInt(9, survey.getTableID());
			preparedStmt.setTimestamp(10, survey.getTable_startTime());
			if(preparedStmt.executeUpdate() == 1) {
				executedResult = true;
			}
			close();
		}else {
			System.out.println("[SB_insert] the survey is existing or table is not existing.");
		}			
		
		return executedResult;
	}
		
	
	
	private boolean isExisting(Survey survey) throws SQLException {
		executedResult = false;
		connect();
		if(survey.getSurveyID() < 1) {
			System.out.println("[SB_isExisting] SurveyID should not be small than and equal 0.");
		}else {
			stmtString = "select count(*) from capstone2020.survey"
					+ " where surveryID = " + survey.getSurveyID();
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			rs.next();
			if(rs.getInt("count(*)") == 1) {
				executedResult = true;
			}
			close();
		}
		
		return executedResult;
	}
		
	
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
				getSurvey.setTableID(rs.getInt(9));
				getSurvey.setTable_startTime(rs.getTimestamp(10));
			}
			close();
		}
		return getSurvey;
	}
	
	public Survey getSurvey(Survey survey) throws SQLException {
		executedResult = false;
		connect();
		if(survey.getSurveyID() < 1) {
			System.out.println("[SB_getSurvey] surveyID should be large than 1");
		}else {
			stmtString = "select * from capstone2020.survey "
					+ "where surveyID = " + survey.getSurveyID();
			preparedStmt = con.prepareStatement(stmtString);
			rs = preparedStmt.executeQuery();
			while(rs.next()) {
				survey = new Survey();
				survey.setSurveyID(rs.getInt(1));
				ArrayList<Double> surveyAs = new ArrayList<Double>();
				for(int i = 0; i< survey.getNUMQUESTIONS(); i++) {
					surveyAs.add(rs.getDouble(i+2));
				}
				survey.setSurveyAs(surveyAs);
				survey.setTableID(rs.getInt(9));
				survey.setTable_startTime(rs.getTimestamp(10));
			}
			close();
		}
		return survey;
	}
	
	public Survey getSurvey(int tableID, Timestamp table_startTime) throws SQLException {
		executedResult = false;
		Survey getSurvey = null;
		connect();
		if(tableID < 1 || table_startTime == null) {
			System.out.println("[SB_getSurvey] tableID and table_startTime is incorrect");
		}else {
			stmtString = "select * from capstone2020.survey "
					+ "where tableID = " + tableID + " AND table_startTime = '" + table_startTime+"'";
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
				getSurvey.setTableID(rs.getInt(9));
				getSurvey.setTable_startTime(rs.getTimestamp(10));
			}
			close();
		}
		return getSurvey;
	}
	
	
	public ArrayList<Survey> getAll() throws SQLException{
		connect();
		ArrayList<Survey> surveys = new ArrayList<Survey>();
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
			survey.setTableID(rs.getInt(9));
			survey.setTable_startTime(rs.getTimestamp(10));
			
			surveys.add(survey);
		}
		return surveys;
		
	}
	
	
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
