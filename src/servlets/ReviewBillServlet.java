package servlets;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
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

import brokers.OrderBroker;
import brokers.TableBroker;
import model.Order;
import model.Table;

/**
 * Servlet implementation class ReviewBillServlet
 */

public class ReviewBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int count = 0;
		double total = 0;
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
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		request.setAttribute("total", df.format(total));
		request.setAttribute("parsedOrderList", parsedOrderList);
		getServletContext().getRequestDispatcher("/BillUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp endTime = Timestamp.valueOf(f.format(date));
		
		Table table = (Table)session.getAttribute("table");
		
		table.setTableStatus(3);
		table.setEndTime(endTime);
		
		TableBroker tableBroker = new TableBroker();
		
		tableBroker.delete(table);
		session.invalidate();
		
	}

}
