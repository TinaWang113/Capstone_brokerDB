/**
 * 
 */
package model;

import java.sql.Date;
import java.util.List;

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
	private Date startTime = null;
	private Date endTime = null;
	private int tableStatus =0;
	
	/**
	 * @param tableID
	 * @param startTime
	 * @param endTime
	 * @param tableStatus
	 */
	public Table(int tableID, Date startTime, Date endTime, int tableStatus) {
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
	public Table(Date endTime, int tableStatus) {
		super();
		this.endTime = endTime;
		this.tableStatus = tableStatus;
	}
	
	public Table(int tableID, Date sTime) {
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
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
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
