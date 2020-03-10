/**
 * 
 */
package model;

/**
 * @author 730693
 *
 */
public class OrderedItem {
	private Item item;
	private int qty;
	private double itemAmount;
	
	public OrderedItem(Item item, int qty) {
		this.item = item;
		this.qty = qty;
		setItemAmount(item.getItemPrice()*qty);
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * @return the itemAmount
	 */
	public double getItemAmount() {
		return itemAmount;
	}

	/**
	 * @param itemAmount the itemAmount to set
	 */
	public void setItemAmount(double itemAmount) {
		this.itemAmount = itemAmount;
	}

	@Override
	public String toString() {
		return "OrderedItem [item=" + item + ", qty=" + qty + ", itemAmount=" + itemAmount + "]";
	}
}
