package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.MenuBroker;
import model.Category;
import model.Item;

/**
 * Servlet implementation class Menu
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Item> parsedItemList = new ArrayList<>(); 
	ArrayList<Category> parsedCategoryList = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		String menuSelection = (String)session.getAttribute("menuSelection");
		
		MenuBroker menuBroker = new MenuBroker();
			try {
				ArrayList<Item> itemList = (ArrayList<Item>) menuBroker.findItemAll();
				ArrayList<Category> categoryList = (ArrayList<Category>) menuBroker.findCategoryAll();
					
				for (Category category : categoryList) {
					if (category.getMenuID() == Integer.parseInt(menuSelection)) {
						parsedCategoryList.add(category);
						
					}
				}
				for (Item item : itemList) {
					if (item.getCategory().getMenuID() == Integer.parseInt(menuSelection)) {
						parsedItemList.add(item);
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			request.setAttribute("parsedItemList", parsedItemList);
			request.setAttribute("parsedCategoryList", parsedCategoryList);
			session.setAttribute("parsedCategoryList", parsedCategoryList);
			getServletContext().getRequestDispatcher("/MenuUI.jsp").forward(request, response);
			parsedCategoryList.clear();
			parsedItemList.clear();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

