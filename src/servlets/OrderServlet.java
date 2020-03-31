package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
//	ArrayList<Item> itemList = new ArrayList<>();
//	ArrayList<Order> orderList = new ArrayList<>();
	HashMap<Integer, Order> orderList = new HashMap<>();
	int currentSize;
	int difference = 0;
	int count = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		

		HashMap<Integer, Order> parsedOrderList = (HashMap<Integer, Order>)session.getAttribute("orderList");

		
		request.setAttribute("parsedOrderList", parsedOrderList);

		
		getServletContext().getRequestDispatcher("/OrderUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
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
				
				MenuBroker menuBroker = new MenuBroker();
					
					
					try {
						
						Item item = menuBroker.findbyID(Integer.parseInt(itemId));
						
						Order order = new Order();
						order.setTable(table);
						order.setTimeStamp(startTime);
						order.setOrderItemQty(itemQuantity);
						order.setOrderItem(item);
						order.setOrderAmount(item.getItemPrice() * itemQuantity);
						
						orderList.put(count, order);
						
						count++;
						session.setAttribute("orderList", orderList);
						response.setContentType("text/html;charset=UTF-8");
				        response.getWriter().write(Integer.toString(orderList.size() - difference));
				        
	
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
				
				for (int i = difference; i < orderList.size(); i++) {
					
					try {
						System.out.println(orderList.get(i).toString());
						orderBroker.insert(orderList.get(i));
						orderList.get(i).setOrderStatus(1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				difference = orderList.size();
				
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
