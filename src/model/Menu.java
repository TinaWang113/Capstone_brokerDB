/**
 * 
 */
package model;

/**
 * @author 730693
 *
 */
public class Menu {
	//attributes
	private int menuID;
	private String menuName;
	private Category category;
	
	/**
	 * @param menuID
	 * @param menuName
	 */
	public Menu(int menuID, String menuName) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
	}

	/**
	 * 
	 */
	public Menu() {
		
	}

	
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
		this.menuID = menuID;
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
		return "Menu [menuID=" + menuID + ", menuName=" + menuName + ", category=" + category + "]";
	}
	
	
}
