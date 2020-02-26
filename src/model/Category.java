package model;

public class Category {
	private int categoryID;
	private String categoryName;
	
	/**
	 * @param categoryID
	 * @param categoryName
	 */
	public Category(int categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	/**
	 * 
	 */
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the categoryID
	 */
	public int getCategoryID() {
		return categoryID;
	}
	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	}
}
