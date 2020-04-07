package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.MenuBroker;
import brokers.OrderBroker;
import brokers.TableBroker;
import model.Category;
import model.Item;
import model.Order;
import model.Table;

/**
 * Servlet implementation class Menu
 * This is to build the menu
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		
		ArrayList<Item> parsedItemList = new ArrayList<>(); 
		ArrayList<Category> parsedCategoryList = new ArrayList<>();
		String menuSelection = (String)session.getAttribute("menuSelection");
		
		MenuBroker menuBroker = new MenuBroker();
			try {
				ArrayList<Item> itemList = (ArrayList<Item>) menuBroker.findItemAll();
				ArrayList<Category> categoryList = (ArrayList<Category>) menuBroker.findCategoryAll();
					
				for (Category category : categoryList) {
					if (category.getMenuID() == Integer.parseInt(menuSelection) || category.getMenuID() == 3) {
						parsedCategoryList.add(category);
						
					}
				}
				for (Item item : itemList) {
					if (item.getCategory().getMenuID() == Integer.parseInt(menuSelection)) {
						parsedItemList.add(item);
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			int itemCount = 0;
			OrderBroker orderBroker = new OrderBroker();

			Table table = (Table)session.getAttribute("table");
			ArrayList<Order> countList = (ArrayList<Order>) orderBroker.getOrders();
			for (int i = 0; i < countList.size(); i++ ) {
				if (countList.get(i).getOrderStatus() == 3 && countList.get(i).getTable().getTableID() == table.getTableID()) {
					itemCount++;
				}
			}
			
			session.setAttribute("updateQuantity", itemCount);
				
			request.setAttribute("parsedItemList", parsedItemList);
			request.setAttribute("parsedCategoryList", parsedCategoryList);
			session.setAttribute("parsedCategoryList", parsedCategoryList);
			getServletContext().getRequestDispatcher("/MenuUI.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

