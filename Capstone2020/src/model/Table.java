package model;

public class Table {

	int tableID;
	String timeStamp;
	double totalAmount;
	int tableStatus;

	public Table() {
		super();
	}

	public Table(int tableID, String timeStamp, double totalAmount, int tableStatus) {
		super();
		this.tableID = tableID;
		this.timeStamp = timeStamp;
		this.tableStatus = tableStatus;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}

	@Override
	public String toString() {
		return "Table [tableID=" + tableID + ", timeStamp=" + timeStamp + ", tableStatus=" + tableStatus + "]";
	}




}
