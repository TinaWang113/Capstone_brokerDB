package model;

public class Category {
	private int categoryID;
	private String categoryName;
	private int menuID;
	
	/**
	 * @param categoryID
	 * @param categoryName
	 */
	public Category(String categoryName, int menuID) {
		super();
		try {
			this.categoryID = categoryID;
			this.categoryName = categoryName;
			//1:Regular, 2:AYCE, 3:Extra
			if(String.valueOf(menuID).matches("^[1-3]$")) {
				this.menuID = menuID;
			}else {
				throw new IndexOutOfBoundsException("menuID should be 1 to 3. 1:Regular, 2:AYCE, 3:Extra");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
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
	

	/**
	 * @return the menuID
	 */
	public int getMenuID() {
		return menuID;
	}

	/**
	 * @param menuID the menuID to set
	 */
	public void setMenuID(int menuID) {
		try {
			if(String.valueOf(menuID).matches("^[1-3]$")) {
				this.menuID = menuID;
			}else {
				throw new IndexOutOfBoundsException("menuID should be 1 to 3. 1:Regular, 2:AYCE, 3:Extra");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", menuID=" + menuID + "]";
	}
}
