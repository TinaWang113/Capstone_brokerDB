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
	ArrayList<Item> subMenuItemList = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categorySelection = request.getParameter("categorySelection");
		
		MenuBroker menuBroker = new MenuBroker();
		
		
		try {
			ArrayList<Item> subItemList = (ArrayList<Item>) menuBroker.findItemAll();
			
			for (Item item : subItemList) {
				System.out.println(item.getCategory().getCategoryID() + " CATEGORY ID");
				System.out.println(categorySelection + " CATEGORY SELECTION");
				if (item.getCategory().getCategoryID() == Integer.parseInt(categorySelection)) {
					subMenuItemList.add(item);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(subMenuItemList.toString());
		getServletContext().getRequestDispatcher("/SubMenuUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
