package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Login;
import com.mvc.dao.LoginDao;
import com.mvc.dao.LoginDaoImpl;

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

    	HttpSession session=request.getSession();
		LoginDao dao=new LoginDaoImpl();
		PrintWriter out=response.getWriter();

		boolean result;
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		Login l=new Login();
		
		l.setPassword(uname);
		l.setUsername(pass);
		result=dao.userLogin(uname, pass);
		System.out.println("username:"+uname+"password:"+pass);

		if(result)
		{
			System.out.println(result);
			System.out.println("username:"+uname+"password:"+pass);
			request.setAttribute("username", uname);
			//String status= "<b style=color:green> You have Successfully Logged in!! </b>";
			request.setAttribute("status","<b style=color:green> You have Successfully Logged in!! </b>");
			RequestDispatcher rd=request.getRequestDispatcher("successPage.jsp");
			rd.forward(request,response);
		}
		else
		{
			//response.setContentType("text/html");
			System.out.println(result);
			//out.println("<html><body><h3><b style=color:red;> You have entered wrong creditials!!!</b></h3></body></html>");
			String status= " You have entered wrong creditials!!! ";
			request.setAttribute("status", status);
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
		
	}

}
















