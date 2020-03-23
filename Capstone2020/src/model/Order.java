package model;

public class Order {

	int orderID;
	String orderItem;
	int orderQty;
	double orderPrice;
	int orderStatus;
	String tableID;
	String timeStamp;

	public Order() {
		super();
	}

	public Order(int orderID, String orderItem, int orderQty, double orderPrice, int orderStatus, String tableID,
			String timeStamp) {
		super();
		this.orderID = orderID;
		this.orderItem = orderItem;
		this.orderQty = orderQty;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
		this.tableID = tableID;
		this.timeStamp = timeStamp;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTableID() {
		return tableID;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderItem=" + orderItem + ", orderQty=" + orderQty + ", orderPrice="
				+ orderPrice + ", orderStatus=" + orderStatus + ", tableID=" + tableID + ", timeStamp=" + timeStamp
				+ "]";
	}

}
