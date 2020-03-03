/**
 * 
 */
package model;

/**
 * @author 730693
 *
 */
public class Item {
	//attributes
	private int itemID;
	private String itemName;
	private double itemPrice;
	private String itemDesc;
	private Category category;
	private String photoLocalDirectory;
	private String photoCloudDirectory;
	
	
	/**
	 * @param itemID
	 * @param itemName
	 * @param itemPrice
	 * @param itemDesc
	 * @param photoLocalDirectory
	 * @param photoCloudDirectory
	 */
	public Item(String itemName,  Category category, double itemPrice, String itemDesc, String photoLocalDirectory,
			String photoCloudDirectory) {
		super();
		//this.itemID = itemID;
		this.itemName = itemName;
		this.category = category;
		this.itemPrice = itemPrice;
		this.itemDesc = itemDesc;
		this.photoLocalDirectory = photoLocalDirectory;
		this.photoCloudDirectory = photoCloudDirectory;
	}
	
	/**
	 * 
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}
	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	/**
	 * @return the photoLocalDirectory
	 */
	public String getPhotoLocalDirectory() {
		return photoLocalDirectory;
	}
	/**
	 * @param photoLocalDirectory the photoLocalDirectory to set
	 */
	public void setPhotoLocalDirectory(String photoLocalDirectory) {
		this.photoLocalDirectory = photoLocalDirectory;
	}
	/**
	 * @return the photoCloudDirectory
	 */
	public String getPhotoCloudDirectory() {
		return photoCloudDirectory;
	}
	/**
	 * @param photoCloudDirectory the photoCloudDirectory to set
	 */
	public void setPhotoCloudDirectory(String photoCloudDirectory) {
		this.photoCloudDirectory = photoCloudDirectory;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDesc="
				+ itemDesc + ", category=" + category.toString() + ", photoLocalDirectory=" + photoLocalDirectory
				+ ", photoCloudDirectory=" + photoCloudDirectory + "]";
	}

	
	
}
