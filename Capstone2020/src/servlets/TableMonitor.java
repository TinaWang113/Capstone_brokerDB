package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.TableBrokder;
import model.Order;

/**
 * Servlet implementation class TableMonitor
 */
@WebServlet("/TableMonitor")
public class TableMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableMonitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/TableMonitor.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String table_id = request.getParameter("tableId");
		String action = request.getParameter("action");

		System.out.println("servlet: " + table_id);

		List<Order> orders = null;
		TableBrokder tb = new TableBrokder();
		try {
			orders = tb.getOrderAll(Integer.parseInt(table_id));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).toString();
		}
//		response.sendRedirect("TableMonitor");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/TableMonitor.jsp");
		request.setAttribute("orders", orders);
		request.setAttribute("test", "test");
		dispatcher.forward(request, response);
	}

}
