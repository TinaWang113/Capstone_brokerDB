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
 * Servlet implementation class SubMenu
 */

public class SubMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ArrayList<Item> subMenuItemList = new ArrayList<>();
		ArrayList<Category> parsedCategoryList = new ArrayList<>();
		
		String menuSelection = (String)session.getAttribute("menuSelection");
		String quantityUpdate = request.getParameter("quantityUpdate");
		
		
		String categorySelection = request.getParameter("categorySelection");
		
		MenuBroker menuBroker = new MenuBroker();
		
		
		
		
		try {
			ArrayList<Item> subItemList = (ArrayList<Item>) menuBroker.findItemAll();
			ArrayList<Category> categoryList = (ArrayList<Category>) menuBroker.findCategoryAll();
			Category subMenuTitle = menuBroker.findByID(Integer.parseInt(categorySelection));
			
			for (Category category : categoryList) {
				
				if (category.getMenuID() == Integer.parseInt(menuSelection)) {
					parsedCategoryList.add(category);
				}
			}
			for (Item item : subItemList) {
				
				if (item.getCategory().getCategoryID() == Integer.parseInt(categorySelection)) {
					subMenuItemList.add(item);
				}
			}
			
			
			request.setAttribute("subMenuTitle", subMenuTitle.getCategoryName());
			request.setAttribute("subMenuItemList", subMenuItemList);
			request.setAttribute("parsedCategoryList", parsedCategoryList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		getServletContext().getRequestDispatcher("/SubMenuUI.jsp").forward(request, response);
		subMenuItemList.clear();
		parsedCategoryList.clear();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
