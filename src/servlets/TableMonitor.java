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


import brokers.TableMgmtBrokder;
import model.OrderMgmt;
import model.TableMgmt;

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

		HttpSession session = request.getSession();

		List<TableMgmt> tables = null;
		TableMgmtBrokder tb = new TableMgmtBrokder();

		try {
			tables = tb.getTableAll();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < tables.size(); i++) {
			int value = 0;
			value = tables.get(i).getTableStatus();
			
			String startTime ="";
			startTime = tables.get(i).getStartTime();
			
			request.setAttribute("table_" + (i + 1)+"_startTime", startTime);
			request.setAttribute("table_" + (i + 1), value);
			
		}
		request.setAttribute("tables", tables);
		getServletContext().getRequestDispatcher("/TableMonitor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/TableMonitor.jsp").forward(request, response);
	}

}
