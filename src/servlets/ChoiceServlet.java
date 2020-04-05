package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.TableBroker;
import model.Table;

/**
 * Servlet implementation class Choice
 */
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		//this will grab the tableid from the url
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		
		session.setAttribute("tableId", tableId);
		
		System.out.println(tableId + " THIS IS THE TABLE ID");
		getServletContext().getRequestDispatcher("/ChoiceUI.jsp").forward(request, response);
		
		

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
		
        Table table = new Table();
		table.setTableID((int)session.getAttribute("tableId"));
		table.setStartTime(startTime);
		table.setStaff_sID(4);
		
		
		TableBroker tableBroker = new TableBroker();
		
		try {
			tableBroker.insertTable(table);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String menuSelection = request.getParameter("action");

		session.setAttribute("menuSelection", menuSelection);
		session.setAttribute("table", table);
		session.setAttribute("itemCount", itemCount);
		
		response.sendRedirect("menu");
	}

}
