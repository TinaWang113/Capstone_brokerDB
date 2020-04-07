package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.MenuBroker;
import brokers.OrderBroker;
import model.Item;
import model.Order;
import model.Table;

/**
 * Servlet implementation class Order
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int count = 0;
		double total=0;
		OrderBroker orderBroker  = new OrderBroker();
		
		HashMap<Integer, Order> parsedOrderList = new HashMap<>();
		Table table = (Table)session.getAttribute("table");
		ArrayList<Order> tempList = (ArrayList<Order>)orderBroker.getOrders();
		for (Order order : tempList) {			
			
			if (order.getTable().getTableID() == table.getTableID() ) {
				parsedOrderList.put(count, order);
				count++;
				total += order.getOrderAmount();
			}
		}
		

		request.setAttribute("total", total);
		request.setAttribute("parsedOrderList", parsedOrderList);
		
		getServletContext().getRequestDispatcher("/OrderUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		
		int itemCount = 0;
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp startTime = Timestamp.valueOf(f.format(date));
		

		
		Table table = (Table)session.getAttribute("table");
		
		
		if (session.isNew() != true) {
			
			String modifyOrderBtn = request.getParameter("action");
			
			if (modifyOrderBtn.equals("addToOrder")) {
				
				String itemId = request.getParameter("itemId");
				int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
				OrderBroker orderBroker = new OrderBroker();
				MenuBroker menuBroker = new MenuBroker();
				
					
					
					try {
						
						
						Item item = menuBroker.findbyID(Integer.parseInt(itemId));
						
						Order order = new Order();
						order.setTable(table);
						order.setTimeStamp(startTime);
						order.setOrderItemQty(itemQuantity);
						order.setOrderItem(item);
						order.setOrderAmount(item.getItemPrice() * itemQuantity);
						
						
						//Everytime a user hits add, it inserts it into the database
						orderBroker.insert(order);
						
						ArrayList<Order> countList = (ArrayList<Order>) orderBroker.getOrders();
						for (int i = 0; i < countList.size(); i++ ) {
							if (countList.get(i).getOrderStatus() == 0 && countList.get(i).getTable().getTableID() == table.getTableID()) {
								itemCount++;
							}
						}
						session.setAttribute("updateQuantity", itemCount);
						response.setContentType("text/html");
						response.getWriter().write(Integer.toString(itemCount));
						response.getWriter().close();
						System.out.println(itemCount + " THIS IS THE ITEM COUNT");

	
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
			else if (modifyOrderBtn.equals("submitForOrder")) {
				
				
				OrderBroker orderBroker = new OrderBroker();
				ArrayList<Order> testList = (ArrayList<Order>)orderBroker.getOrders();
				
				//Set the order status to ordered when they hit submit button
				for (Order order : testList) {
					
					if (order.getOrderStatus() != 1) {
						order.setOrderStatus(1);
						
						try {
							orderBroker.updateStatus(order);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
				}
				itemCount = 0;
				session.setAttribute("itemCount", itemCount);
				
				response.sendRedirect("menu");
			}
			else if (modifyOrderBtn.equals("editItem")) {
				
				int count = 0;
				OrderBroker orderBroker = new OrderBroker();
				HashMap<Integer, Order> orderList = new HashMap<>();
				ArrayList<Order> tempList = (ArrayList<Order>)orderBroker.getOrders();
				
				for (Order order : tempList) {			
					
					if (order.getTable().getTableID() == table.getTableID() ) {
						orderList.put(count, order);
						count++;
					}
				}
				
				int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
				int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
				
				
				Order editOrder = orderList.get(itemIndex);
				
				if (itemQuantity == 0) {
					orderBroker.delete(editOrder);
				}
				else {
					
					editOrder.setOrderItemQty(itemQuantity);
					editOrder.setOrderAmount(itemQuantity * editOrder.getOrderItem().getItemPrice());
					
					try {
						orderBroker.update(editOrder);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			else if (modifyOrderBtn.equals("deleteItem")) {
				
				int count = 0;
				OrderBroker orderBroker = new OrderBroker();
				HashMap<Integer, Order> orderList = new HashMap<>();
				ArrayList<Order> tempList = (ArrayList<Order>)orderBroker.getOrders();
				
				for (Order order : tempList) {			
					
					if (order.getTable().getTableID() == table.getTableID() ) {
						orderList.put(count, order);
						count++;
					}
				}
				
				int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
				
				Order order = orderList.get(itemIndex);
				System.out.println(order + " THIS IS DELETE ORDER ITEM");
				orderBroker.delete(order);
				
				int something = (int)session.getAttribute("updateQuantity");
				something--;
				session.setAttribute("updateQuantity", something);
				response.setContentType("text/html");
				response.getWriter().write(Integer.toString(something));
				response.getWriter().close();
				
			}
		}
			
		else {
			System.out.println("THE SESSION HAS CHANGED");
		}
		
	}

}