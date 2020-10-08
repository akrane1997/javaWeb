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
		//		HttpSession session=request.getSession();
		//		session.invalidate();
		//		response.sendRedirect("Login.jsp");
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

			String operation=request.getParameter("operation");
			String type=request.getParameter("type");
			boolean result;
			String email=request.getParameter("emailId");
			String pass=request.getParameter("password");
			//		Login l=new Login();
			//		l.setPassword(email);
			//		l.setUsername(pass);

			if(operation!=null && operation.equals("Login"))
			{

				if(type.equals("student"))
				{
					result=dao.StudLogin(email, pass);
					System.out.println("username:"+email+"password:"+pass);

					if(result)
					{
						System.out.println(result);
						System.out.println("username:"+email+"password:"+pass);


						session.setAttribute("student", email);
						String status= " You have successfully Login!!! ";
						request.setAttribute("status",status);
						RequestDispatcher rd=request.getRequestDispatcher("successPage.jsp");
						rd.forward(request,response);
					}
					else
					{
						System.out.println(result);
						String status= " You have entered wrong creditials!!! ";
						request.setAttribute("status", status);
						RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}
				}
				if(type.equals("teacher"))
				{
					result=dao.TheacherLogin(email, pass);
					System.out.println("username:"+email+"password:"+pass);

					if(result)
					{
						System.out.println(result);
						System.out.println("username:"+email+"password:"+pass);


						session.setAttribute("teacher", email);
						String status= " You have successfully Login!!! ";
						request.setAttribute("status",status);
						RequestDispatcher rd=request.getRequestDispatcher("successPage.jsp");
						rd.forward(request,response);
					}
					else
					{
						System.out.println(result);
						String status= " You have entered wrong creditials!!! ";
						request.setAttribute("status", status);
						RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}

				}
//				session.invalidate();
//				response.sendRedirect("Login.jsp");
			}
			
		}
	}
















