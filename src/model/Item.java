/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author 747136
 *
 */
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7417459817591162425L;
	String itemName;
	double itemPrice;
	String description;
	int categoryId;
	String photoLocalDirectory;
	String photoCloudDirectory;

	public Item() {
		
	}

	public Item(String itemName, double itemPrice, String description, int categoryId, String photoLocalDirectory, String photoCloudDirectory) {
		
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.description = description;
		this.categoryId = categoryId;
		this.photoLocalDirectory = photoLocalDirectory;
		this.photoCloudDirectory = photoCloudDirectory;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemPrice=" + itemPrice + ", description=" + description
				+ ", categoryId=" + categoryId + ", photoLocalDirectory=" + photoLocalDirectory
				+ ", photoCloudDirectory=" + photoCloudDirectory + "]";
	}
	
	
	
	
}
