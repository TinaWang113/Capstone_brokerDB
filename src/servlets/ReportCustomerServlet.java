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
import javax.servlet.http.HttpSession;

import brokers.ReportBroker;
import brokers.TableMgmtBrokder;
import model.OrderMgmt;
import model.ReportCustomer;
import model.TableMgmt;

/**
 * Servlet implementation class TableMonitor
 */
public class ReportCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		ReportCustomer report = null;
		ReportBroker rb = new ReportBroker();

		try {
			report = rb.getCustomerReport();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("report", report);
		getServletContext().getRequestDispatcher("/Mgmt_Report_Customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Mgmt_Report_Customer.jsp").forward(request, response);
	}

}
