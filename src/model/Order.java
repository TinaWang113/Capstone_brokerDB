/**
 * 
 */
package model;

import java.sql.Date;
import model.Table;

/**
 * @author 730693
 *
 */
public class Order {
	//Attributes
	// if orderID is 0, the DB will auto increment;
	//otherwise, following the value that is assigned to tabelID 
	private int orderID;
	//auto create now() in DB, if timeStamp' value is null
	private Date timeStamp = null;	
	private int orderItemQty = 0;
	private double orderAmount = 0.0;
	//orderStatus default is 0
	private int orderStatus = 0;
	private Table table = null;
	private Item orderItem = null;
	
	
	/**
	 * @param orderID
	 * @param timeStamp
	 * @param orderItemQty
	 * @param orderAmount
	 * @param orderStatus
	 * @param table
	 * @param orderItem
	 */
	public Order(int orderID, Date timeStamp, int orderItemQty, int orderStatus, Table table,
			Item orderItem) {
		super();
		this.orderID = orderID;
		this.timeStamp = timeStamp;
		this.orderItemQty = orderItemQty;
		setOrderAmount(calOrderAmount());
		this.orderStatus = orderStatus;
		this.table = table;
		this.orderItem = orderItem;
	}
	
	/**
	 * @param orderID
	 * @param timeStamp
	 * @param orderItemQty
	 * @param orderAmount
	 * @param orderStatus
	 * @param table
	 * @param orderItem
	 */
	public Order(int orderItemQty, Table table, Item orderItem) {
		super();
		setOrderItemQty(orderItemQty);
		setOrderAmount(calOrderAmount());
		setOrderStatus(0);
		this.table = table;
		this.orderItem = orderItem;
	}
	
	public Order(int orderID, Date timeStamp) {
		setOrderID(orderID);
		setTimeStamp(timeStamp);
	}
	
	public Order() {
		
	}
	
	
	/**calOrderAmount
	 * 
	 * @return double
	 */
	public double calOrderAmount() {
		if(getOrderItemQty() > 0 && orderItem !=null) {
			return getOrderAmount() * orderItem.getItemPrice();
		}
		System.out.println("No any ordered item");
		return 0.00;
		
	}
	
	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}
	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the orderItemQty
	 */
	public int getOrderItemQty() {
		return orderItemQty;
	}
	/**
	 * @param orderItemQty the orderItemQty to set
	 */
	public void setOrderItemQty(int orderItemQty) {
		this.orderItemQty = orderItemQty;
	}
	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @return the orderStatus
	 */
	public int getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}
	/**
	 * @return the orderItem
	 */
	public Item getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(Item orderItem) {
		this.orderItem = orderItem;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", timeStamp=" + timeStamp + ", orderItemQty=" + orderItemQty
				+ ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus + ", table=" + table + ", orderItem="
				+ orderItem + "]";
	}
	
	

	

	
}
