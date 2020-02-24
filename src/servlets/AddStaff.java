package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.StaffBroker;
import model.Staff;

/**
 * Servlet implementation class AddStaff
 */
@WebServlet("/addstaff")
public class AddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/AddStaffUI.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff staff = new Staff();
		staff.setfName(request.getParameter("fName"));
		staff.setlName(request.getParameter("lName"));
		staff.setPin(request.getParameter("pin"));
		staff.setContactNum(request.getParameter("contactNum"));
		staff.setIsActive("y");
		staff.setJobName(request.getParameter("jobSelect"));
		
		StaffBroker staffBroker = new StaffBroker();
		try {
			staffBroker.insert(staff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("staffmanagement");
	}

}
