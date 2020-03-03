package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import brokers.StaffBroker;
import model.Staff;

/**
 * @author 747136
 */

/**
 * Servlet implementation class StaffManagement
 */
public class StaffManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * GET method, for loading the data from the database such as loading the list
	 * and when a redirection is made from the POST method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		
		StaffBroker staffbroker = new StaffBroker();
		
		try {
			ArrayList<Staff> staffList = (ArrayList<Staff>) staffbroker.findAll();
			request.setAttribute("staffList", staffList);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/StaffMgmtUI.jsp").forward(request, response);
	}

	/**
	 * POST method, for submitting edits, deletes and additions to staff to the database.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Action to determine if the user wants to edit or delete
		String action = request.getParameter("action");
		
		//If the action is "Confirm" the user is editing a staff member
		//If the action is "Yes" the user is deleting a user.
		if (action.equals("Confirm")) {
			StaffBroker staffBroker = new StaffBroker();
			Staff staff;
			try {
				staff = staffBroker.findByIDList(Integer.parseInt(request.getParameter("editbtnConfirm")));
				staff.setfName(request.getParameter("fName"));
				staff.setlName(request.getParameter("lName"));
				staff.setPin(request.getParameter("pin"));
				staff.setContactNum(request.getParameter("contactNum"));
				staff.setIsActive("y");
				staff.setJobName(request.getParameter("jobName"));
				
				staffBroker.update(staff);
				response.sendRedirect("staffmanagement");
				
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		else if (action.equals("Yes")) {

			StaffBroker staffBroker = new StaffBroker();
			int id = Integer.parseInt(request.getParameter("deletebtnConfirm"));
			try {
				staffBroker.delete(id);
				response.sendRedirect("staffmanagement");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
