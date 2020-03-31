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
import model.ReportBest;
import model.ReportSale;
import model.TableMgmt;

/**
 * Servlet implementation class TableMonitor
 */
public class ReportSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportSaleServlet() {
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

		ReportSale report = null;
		ReportBroker rb = new ReportBroker();
		ArrayList<ReportBest> bestToday = new ArrayList<ReportBest>();
		ArrayList<ReportBest> bestMonth = new ArrayList<ReportBest>();

		try {
			report = rb.getSaleTrend();
			bestToday = rb.getSaleBestToday();
			bestMonth = rb.getSaleBestMonth();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("report", report);
		request.setAttribute("bestToday", bestToday);
		request.setAttribute("bestMonth", bestMonth);
		getServletContext().getRequestDispatcher("/Mgmt_Report_Sale.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/Mgmt_Report_Sale.jsp").forward(request, response);
	}

}
