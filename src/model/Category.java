/**
 * 
 */
package model;

/**
 * @author 747136
 *
 */
public class Category {

	int categoryId;
	String categoryName;
	int menuId;
	
	public Category() {
		
	}
	
	public Category(int categoryId, String categoryName, int menuId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.menuId = menuId;
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
	 * @return the menuId
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", menuId=" + menuId + "]";
	}
	
	
	
	
}
