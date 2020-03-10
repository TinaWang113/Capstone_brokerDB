/**
 * 
 */
package model;

import java.sql.Date;
import java.util.List;

import com.mysql.cj.xdevapi.Table;

/**
 * @author 730693
 *
 */
public class Order {
	//Attributes
	private int orderID;
	private Date timeStamp;
	private double orderAmount;
	/*orderedItems : 
	  containing qty of item, total price of item, 
	  and the info of item (Item object)
	*/
	private List<Item>orderedItems;
	
	
	
	/**
	 * @param orderID
	 * @param timeStamp
	 * @param orderAmount
	 * @param orderedItems
	 */
	public Order(int orderID, Date timeStamp, double orderAmount, List<Item> orderedItems) {
		super();
		this.orderID = orderID;
		this.timeStamp = timeStamp;
		this.orderAmount = orderAmount;
		this.orderedItems = orderedItems;
	}



	public void Order() {
		
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
	 * @return the orderedItems
	 */
	public List<Item> getOrderedItems() {
		return orderedItems;
	}



	/**
	 * @param orderedItems the orderedItems to set
	 */
	public void setOrderedItems(List<Item> orderedItems) {
		this.orderedItems = orderedItems;
	}



	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", timeStamp=" + timeStamp + ", orderAmount=" + orderAmount
				+ ", orderedItems=" + orderedItems + "]";
	}

	

	
}
