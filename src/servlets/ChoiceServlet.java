package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
	int tableId;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//this will grab the tableid from the url
		tableId = Integer.parseInt(request.getParameter("tableId"));

		System.out.println(tableId + " THIS IS THE TABLE ID");
		getServletContext().getRequestDispatcher("/ChoiceUI.jsp").forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Timestamp startTime = Timestamp.valueOf(f.format(date));
		Table table = new Table();
		//TODO: THIS IS JUST TESTING REMOVE BEFORE FINAL PRSENTATION
		//THIS SETS THE TABLE ID TO A RANDOM NUMBER BETWEEN 1 AND 25!
//		Random r = new Random();
//		int low = 1;
//		int high = 25;
//		int fakeTableId = r.nextInt(high-low) + low;
		////////////////////////////////////////////
		table.setTableID(tableId);
		table.setStartTime(startTime);
		
		
		TableBroker tableBroker = new TableBroker();
		
		try {
			tableBroker.insertTable(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String menuSelection = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("menuSelection", menuSelection);
		session.setAttribute("table", table);
		
		
		response.sendRedirect("menu?tableId=17");
	}

}
