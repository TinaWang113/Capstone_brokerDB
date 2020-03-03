package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.MenuBroker;
import model.Item;

/**
 * Servlet implementation class Menu
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String menuChoice = request.getParameter("menuChoice");
		String menuChoice = "2";
		MenuBroker menubroker = new MenuBroker();
		
		
			try {
				ArrayList<Item> itemList = (ArrayList<Item>) menubroker.findItemAll();
				System.out.println(itemList.toString());
				if (menuChoice.equals("2"))
				{
					for (Item item : itemList)
					{
							
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		getServletContext().getRequestDispatcher("/StaffMgmtUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
