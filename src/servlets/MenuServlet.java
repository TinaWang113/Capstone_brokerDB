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
import model.Item;

/**
 * Servlet implementation class Menu
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	ArrayList<Item> regItemList = 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String menuSelection = (String)session.getAttribute("menuSelection");
		System.out.println(menuSelection + " THIS IS YOUR MENU SELECTION");
		MenuBroker menubroker = new MenuBroker();
			try {
				ArrayList<Item> itemList = (ArrayList<Item>) menubroker.findItemAll();
				
				
				if (menuSelection.equals("1")) {
					
					for (Item item : itemList) {
						if (item.getCategory().getMenuID() == Integer.parseInt(menuSelection)) {
							
						}
					}
				}
				else if (menuSelection.equals("2")) {
					for (Item item : itemList) {
						if (item.getCategory().getMenuID() == Integer.parseInt(menuSelection)) {
							
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		getServletContext().getRequestDispatcher("/MenuUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

