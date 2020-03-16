package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.MenuBroker;
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
		
		getServletContext().getRequestDispatcher("/ChoiceUI.jsp").forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Table table = new Table();

		
		
		TableBroker tableBroker = new TableBroker();
		
		tableBroker.insertTable(table);
		
		
		String menuSelection = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("menuSelection", menuSelection);
		session.setAttribute("table", table);
		
		
		response.sendRedirect("menu");
	}

}
