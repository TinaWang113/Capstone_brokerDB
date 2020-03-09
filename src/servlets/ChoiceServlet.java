package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.MenuBroker;

/**
 * Servlet implementation class Choice
 */
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.isNew() != true)
		{
			System.out.println(session.getCreationTime());
			response.sendRedirect("menu");
		}
		else {
			getServletContext().getRequestDispatcher("/ChoiceUI.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menuSelection = request.getParameter("action");
		HttpSession session = request.getSession();
		session.setAttribute("menuSelection", menuSelection);
		
		response.sendRedirect("menu");
	}

}
