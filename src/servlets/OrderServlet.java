package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Servlet implementation class Order
 */

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int currentSize;
	int difference = 0;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int count = 0;
		OrderBroker orderBroker  = new OrderBroker();
		MenuBroker menuBroker = new MenuBroker();
		
		HashMap<Integer, Order> parsedOrderList = new HashMap<>();
		Table table = (Table)session.getAttribute("table");
		ArrayList<Order> tempList = (ArrayList<Order>)orderBroker.getOrders();
		for (Order order : tempList) {			
			System.out.println(order + " THIS IS THE ORDER");
			if (order.getTable().getTableID() == table.getTableID() ) {
				parsedOrderList.put(count, order);
				count++;
			}
		}
		

		
		request.setAttribute("parsedOrderList", parsedOrderList);

		
		getServletContext().getRequestDispatcher("/OrderUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		//HashMap to hold the orders and the amount of orders
		HashMap<Integer, Order> orderList = new HashMap<>();
		int itemCount = (int)session.getAttribute("itemCount");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp startTime = Timestamp.valueOf(f.format(date));
		
//		TableBroker tableBroker = new TableBroker();
		
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
//						orderList.put(count, order);
						
//						count++;
//						session.setAttribute("orderList", orderList);
//						response.setContentType("text/html;charset=UTF-8");
//				        response.getWriter().write(Integer.toString(orderList.size() - difference));
						itemCount++;
						System.out.println(itemCount + " THIS IS THE ITEM COUNT");
//				        session.setAttribute("itemCount", itemCount);
	
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
//				for (int i = difference; i < orderList.size(); i++) {
//					
//					try {
//						System.out.println(orderList.get(i).toString());
//						orderBroker.insert(orderList.get(i));
//						orderList.get(i).setOrderStatus(1);
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				}
//				difference = orderList.size();
				itemCount = 0;
				session.setAttribute("itemCount", itemCount);
				
				response.sendRedirect("menu");
			}
			else if (modifyOrderBtn.equals("editItem")) {
				int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
				int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
				
				Order editOrder = orderList.get(itemIndex);
				editOrder.setOrderItemQty(itemQuantity);
				
				orderList.replace(itemIndex, editOrder);
			}
			else if (modifyOrderBtn.equals("deleteItem")) {
				int itemIndex = Integer.parseInt(request.getParameter("itemIndex"));
				
				orderList.remove(itemIndex);
			}
		}
			
		else {
			System.out.println("THE SESSION HAS CHANGED");
		}
		
	}

}
