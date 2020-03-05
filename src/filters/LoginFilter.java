package filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import brokers.StaffBroker;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest resq = (HttpServletRequest) request;
		int pin = Integer.parseInt(resq.getParameter("pin"));
		System.out.println("THIS IS THE STAFF PIN! " + " " + pin);
		int staffPin = 1234;
		int managerPin = 9999;
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (pin == staffPin) {
			System.out.println("THIS WOULD NORMALLY REDIRECT TO TABLE SERVLET");
//			resp.sendRedirect("tableServlet");
		}
		else if (pin == managerPin) {
			resp.sendRedirect("staffmanagement");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
