package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.TableBrokder;
import model.Order;

/**
 * Servlet implementation class TableDetail
 */
@WebServlet("/TableDetail")
public class TableDetail extends HttpServlet {
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
		double totalAmount = 0;
		double subTotal = 0;
		double tax = 0;

		List<Order> orders = null;
		TableBrokder tb = new TableBrokder();
		try {
			orders = tb.getOrderAll(Integer.parseInt(tableId));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).toString();
			subTotal += orders.get(i).getOrderPrice();
		}
		tax = Math.round(subTotal * 0.05);
		totalAmount = tax + subTotal;

		request.setAttribute("orders", orders);
		request.setAttribute("tableId", tableId);
		request.setAttribute("subTotal", subTotal);
		request.setAttribute("tax", tax);
		request.setAttribute("totalAmount", totalAmount);
		getServletContext().getRequestDispatcher("/TableDetail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
