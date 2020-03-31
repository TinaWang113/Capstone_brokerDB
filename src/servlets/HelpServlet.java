package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.TableBroker;
import model.Table;

/**
 * Servlet implementation class HelpServlet
 */
@WebServlet("/helpservlet")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Table table = (Table)session.getAttribute("table");
		
		
		getServletContext().getRequestDispatcher("/HelpUI.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Table table = (Table)session.getAttribute("table");
		TableBroker tableBroker = new TableBroker();
		
		String action = request.getParameter("action");
		System.out.println(action + " THIS IS THE ACTION");
		if (action.equals("help")) {
			table.setTableStatus(1);
			tableBroker.updateStatus(table);
			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("help");
		}
		else if (action.equals("cancel")) {
			table.setTableStatus(0);
			tableBroker.updateStatus(table);
			response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().write("cancel");
		}
		
	}

}
