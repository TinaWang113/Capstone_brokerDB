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
	private int tableID;
	private Date startDate;
	private Date enDate;
	private double totalAmount;
	private int tableStatus;
	private List<Order>orders;
	/**
	 * @param tableID
	 * @param startDate
	 * @param enDate
	 * @param totalAmount
	 * @param tableStatus
	 * @param orders
	 */
	public Table(int tableID, Date startDate, Date enDate, double totalAmount, int tableStatus, List<Order> orders) {
		super();
		this.tableID = tableID;
		this.startDate = startDate;
		this.enDate = enDate;
		this.totalAmount = totalAmount;
		this.tableStatus = tableStatus;
		this.orders = orders;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the enDate
	 */
	public Date getEnDate() {
		return enDate;
	}
	/**
	 * @param enDate the enDate to set
	 */
	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}
	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Table [tableID=" + tableID + ", startDate=" + startDate + ", enDate=" + enDate + ", totalAmount="
				+ totalAmount + ", tableStatus=" + tableStatus + ", orders=" + orders + "]";
	}
	
}
