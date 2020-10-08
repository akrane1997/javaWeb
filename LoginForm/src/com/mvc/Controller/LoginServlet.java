package com.mvc.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		if(uname.equals("akrane") && pass.equals("123456"))
		{
			request.setAttribute("username", uname);
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response);
		}
		else
		{
			String status="incorrect username and password !!!";
			request.setAttribute("status", status);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		}
	}

}
