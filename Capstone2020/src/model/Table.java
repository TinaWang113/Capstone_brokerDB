package model;

public class Table {

	int tableID;
	String startTime;
	String endTime;
	double totalAmount;
	int tableStatus;

	public Table() {
		super();
	}

	public Table(int tableID, String startTime, String endTime, double totalAmount, int tableStatus) {
		super();
		this.tableID = tableID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalAmount = totalAmount;
		this.tableStatus = tableStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public int getTableStatus() {
		return tableStatus;
	}

	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}

	@Override
	public String toString() {
		return "Table [tableID=" + tableID + ", startTime=" + startTime + ", tableStatus=" + tableStatus + "]";
	}

}
