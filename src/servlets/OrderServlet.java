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
import brokers.OrderBroker;
import brokers.TableBroker;
import model.Item;
import model.Order;
import model.Table;

/**
 * Servlet implementation class Order
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	ArrayList<Item> itemList = new ArrayList<>();
	ArrayList<Order> orderList = new ArrayList<>();
	int currentSize;
	int difference;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ArrayList<Order> parsedOrderList = (ArrayList<Order>)session.getAttribute("orderList");
		
		request.setAttribute("parsedOrderList", parsedOrderList);
		
		getServletContext().getRequestDispatcher("/OrderUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		TableBroker tableBroker = new TableBroker();
		
		Table table = (Table)session.getAttribute("table");
		
		
		if (session.isNew() != true) {
			
			String addOrSubmitBtn = request.getParameter("action");
			
			if (addOrSubmitBtn.equals("addToOrder")) {
				
				String itemId = request.getParameter("itemId");
				int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
				
				MenuBroker menuBroker = new MenuBroker();
					
					
					try {
						
						Item item = menuBroker.findbyID(Integer.parseInt(itemId));
						
						Order order = new Order();
						order.setTable(table);
						order.setOrderID(9);
						order.setOrderItemQty(itemQuantity);
						order.setOrderItem(item);
						
						orderList.add(order);
						
						
						session.setAttribute("orderList", orderList);
						response.setContentType("text/html;charset=UTF-8");
						
						
							 
						
						
				        response.getWriter().write(Integer.toString(orderList.size()));
				        
	
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			else if (addOrSubmitBtn.equals("submitForOrder")) {
				
				
				OrderBroker orderBroker = new OrderBroker();
				
//				for (Order order : orderList) {
//					orderBroker.insert(order);
//				}
				
				response.sendRedirect("menu");
			}
		}
			
		else {
			System.out.println("THE SESSION HAS CHANGED");
		}
		
	}

}
