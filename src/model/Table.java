/**
 * 
 */
package model;

import java.sql.Timestamp;

/**
 * @author 730693
 *
 */
public class Table {
	//attributes
	// if tableID is 0, the DB will auto increment;
	//otherwise, following the value that is assigned to tabelID 
	private int tableID = 0 ;
	//auto create now() in DB, if timeStamp' value is null
	private Timestamp startTime = null;
	private Timestamp endTime = null;
	private int tableStatus =0;
	
	/**
	 * @param tableID
	 * @param startTime
	 * @param endTime
	 * @param tableStatus
	 */
	public Table(int tableID, Timestamp startTime, Timestamp endTime, int tableStatus) {
		super();
		this.tableID = tableID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.tableStatus = tableStatus;
	}
	
	/**
	 * @param endTime
	 * @param tableStatus
	 */
	public Table(Timestamp endTime, int tableStatus) {
		super();
		this.endTime = endTime;
		this.tableStatus = tableStatus;
	}
	
	public Table(int tableID, Timestamp sTime) {
		setTableID(tableID);
		setStartTime(sTime);
	}
	
	/**
	 * 
	 */
	public Table() {
		
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
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the tableStatus
	 */
	public int getTableStatus() {
		return tableStatus;
	}
	/**
	 * @param tableStatus the tableStatus to set
	 */
	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}
	@Override
	public String toString() {
		return "TableBroker [tableID=" + tableID + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", tableStatus=" + tableStatus + "]";
	}
	
	
}
