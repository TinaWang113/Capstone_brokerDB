package servlets;

import java.io.IOException;
import java.sql.Date;
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
import model.Order;

/**
 * Servlet implementation class Order
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Item> ItemList = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/OrderUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.isNew() != true) {
			
			String itemId = request.getParameter("itemId");
			String itemQuantity = request.getParameter("itemQuantity");
			
			MenuBroker menuBroker = new MenuBroker();
			try {
				
				Item item = menuBroker.findbyID(Integer.parseInt(itemId));
				ItemList.add(item);
//				Order order = new Order(1, new Date(System.currentTimeMillis()), 0, ItemList);
				
				System.out.println(ItemList.toString() + " THIS IS THE ITEM LIST");
				
//				System.out.println(order.toString() + " THIS IS YOUR ORDER");
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write(item.getItemName() + " ");
//		        response.getWriter().write(ItemList.size());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("THE SESSION HAS CHANGED");
		}
		
	}

}
