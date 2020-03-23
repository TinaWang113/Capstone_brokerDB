package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.TableMgmtBrokder;
import model.Order;
import model.Table;

/**
 * Servlet implementation class TableDetail
 */
@WebServlet("/TableDetail")
public class TableDetail extends HttpServlet {
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tableId = request.getParameter("tableId");
		String tableStartTime = request.getParameter("tableStartTime");

		double totalAmount = 0;
		double subTotal = 0;
		double tax = 0;

		List<Order> orders = null;
		Table table = null;
		TableMgmtBrokder tb = new TableMgmtBrokder();

		try {
			orders = tb.getOrderAll(tableId, tableStartTime);
			table = tb.getTable(tableId, tableStartTime);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		if (orders != null) {

			for (int i = 0; i < orders.size(); i++) {
				subTotal += Math.round(orders.get(i).getOrderPrice() * orders.get(i).getOrderQty()*100)/100;
			}

			tax = Math.round(subTotal * 0.05);
			totalAmount = tax + subTotal;
			request.setAttribute("orders", orders);
			request.setAttribute("tableId", tableId);
			request.setAttribute("subTotal", subTotal);
			request.setAttribute("tax", tax);
			request.setAttribute("totalAmount", totalAmount);
			request.setAttribute("startTime", table.getStartTime());
		}
		request.setAttribute("table", table);
		getServletContext().getRequestDispatcher("/TableDetail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tableId = request.getParameter("tableId");
		String action = request.getParameter("action");
		String orderItemId = request.getParameter("orderItem");
		String tableStartTime = request.getParameter("tableStartTime");
		String orderTimeStamp = request.getParameter("orderTimeStamp");

		double totalAmount = 0;
		double subTotal = 0;
		double tax = 0;

		List<Order> orders = null;
		Table table = null;
		TableMgmtBrokder tb = new TableMgmtBrokder();
		try {
			if (action.equalsIgnoreCase("requestStatus")) {
				tb.changeTableStatus(tableId, tableStartTime);
			} else if (action.equalsIgnoreCase("closeSession")) {
				tb.closeSession(tableId);
			} else if (action.equalsIgnoreCase("orderStatus")) {
				tb.changeOrderStatus(orderItemId, orderTimeStamp, tableStartTime);
			}
			orders = tb.getOrderAll(tableId, tableStartTime);
			table = tb.getTable(tableId, tableStartTime);

		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		if (orders != null) {
			for (int i = 0; i < orders.size(); i++) {
				subTotal +=  Math.round(orders.get(i).getOrderPrice() * orders.get(i).getOrderQty()*100)/100;
				System.out.println(orders.get(i).toString());
			}

			tax = (double) Math.round(subTotal * 0.05*100)/100;
			totalAmount = tax + subTotal;

			request.setAttribute("orders", orders);
			request.setAttribute("table", table);
			request.setAttribute("tableId", tableId);
			request.setAttribute("subTotal", subTotal);
			request.setAttribute("tax", tax);
			request.setAttribute("totalAmount", totalAmount);

		}
		if (action.equalsIgnoreCase("closeSession") || action.equalsIgnoreCase("requestStatus")) {
			response.sendRedirect("/Capstone2020/tableMonitor");
		} else if (action.equalsIgnoreCase("orderStatus")) {
			response.sendRedirect("/Capstone2020/tableDetail?tableId=" + tableId + "&tableStartTime="+tableStartTime);
		} else {
			getServletContext().getRequestDispatcher("/TableDetail.jsp").forward(request, response);

		}

	}

}
