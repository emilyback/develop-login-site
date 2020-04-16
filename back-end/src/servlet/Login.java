package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginCheck")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminId = getServletContext().getInitParameter("adminId");
		String adminPwd = getServletContext().getInitParameter("adminPwd");
		
		int admin =0;
				
		
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		
		boolean isAdminId = loginId.equals(adminId);
		boolean isAdminPwd = loginPwd.equals(adminPwd);
		
		if(isAdminId && isAdminPwd) admin = 1;
		
		//Sysetem.out.println(lo)
		
		response.setIntHeader("isAdmin", admin);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
