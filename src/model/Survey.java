/**
 * 
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author 730693
 *
 */
public class Survey {
	private int surveyID;
	private final int NUMQUESTIONS = 8;
	private ArrayList<Double> surveyAs;
	private int tableID;
	private Timestamp table_startTime;
	
	
	/**
	 * @param surveyID
	 * @param surveyAs
	 * @param tableID
	 * @param table_startTime
	 */
	public Survey(int surveyID, ArrayList<Double> survArrayList, int tableID, Timestamp table_startTime) {
		super();
		this.surveyID = surveyID;
		surveyAs = new ArrayList<Double>(NUMQUESTIONS);
		this.surveyAs = survArrayList;
		this.tableID = tableID;
		this.table_startTime = table_startTime;
	}
	
	/**
	 * @param surveyAs
	 * @param tableID
	 * @param table_startTime
	 */
	public Survey( ArrayList<Double> survArrayList, int tableID, Timestamp table_startTime) {
		super();
		this.surveyID = 0;
		surveyAs = new ArrayList<Double>(NUMQUESTIONS);
		this.surveyAs = survArrayList;
		this.tableID = tableID;
		this.table_startTime = table_startTime;
	}

	public Survey() {
	}

	/**
	 * @return the surveyID
	 */
	public int getSurveyID() {
		return surveyID;
	}

	/**
	 * @param surveyID the surveyID to set
	 */
	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	/**
	 * @return the surveyAs
	 */
	public ArrayList<Double> getSurveyAs() {
		return surveyAs;
	}

	/**
	 * @param surveyAs the surveyAs to set
	 */
	public void setSurveyAs(ArrayList<Double> surveyAs) {
		this.surveyAs = surveyAs;
	}

	/**
	 * @return the tableID
	 */
	public int getTableID() {
		return tableID;
	}

	/**
	 * @param tableID the tableID to set
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	/**
	 * @return the table_startTime
	 */
	public Timestamp getTable_startTime() {
		return table_startTime;
	}

	/**
	 * @param table_startTime the table_startTime to set
	 */
	public void setTable_startTime(Timestamp table_startTime) {
		this.table_startTime = table_startTime;
	}

	@Override
	public String toString() {
		return "Survey [surveyID=" + surveyID + ", surveyAs=" + surveyAs + ", tableID=" + tableID + ", table_startTime="
				+ table_startTime + "]";
	}

	/**
	 * @return the nUMQUESTIONS
	 */
	public int getNUMQUESTIONS() {
		return NUMQUESTIONS;
	}
	
}
