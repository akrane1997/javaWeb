package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.Student;
import com.mvc.dao.StudRegistrationDao;
import com.mvc.dao.StudRegistrationDaoImpl;

/**
 * Servlet implementation class SudentServlet
 */
@WebServlet("/SudentServlet")
public class SudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		StudRegistrationDaoImpl sdao=new StudRegistrationDaoImpl();
		boolean result;
		RequestDispatcher rd;
		String op=request.getParameter("operation");
		
		 if(op!=null && op.equals("edit"))
			{
				
				 String email=(String)session.getAttribute("student");
				Student stud=sdao.getStudByEmail(email);
				session.setAttribute("studObj",stud);
				rd=request.getRequestDispatcher("updateProfile.jsp");
				rd.forward(request, response);
			}
			else
			{
				List<Student> slist=sdao.ListOfStudent();
				session.setAttribute("sList", slist);
				rd=request.getRequestDispatcher("studList.jsp");
				rd.forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//		StudRegistrationDaoImpl sdao=new StudRegistrationDaoImpl();
		StudRegistrationDao sdao=new StudRegistrationDaoImpl();
		boolean result;
		
		RequestDispatcher rd;
		String op=request.getParameter("operation");
		String studname=request.getParameter("studentname");
		String studage=request.getParameter("studentage");
		String studgenger=request.getParameter("studentgender");
		String studaddr=request.getParameter("studentaddress");
		String studemail=request.getParameter("studentemailid");
		String studpass=request.getParameter("studentpassword");

		if (op != null && op.equals("addStud"))
		{

			Student	stud=new Student(studname, studage, studgenger, studaddr, studemail, studpass);
			result = sdao.addStudent(stud);
			if(result) 
			{	System.out.println(result);
			String status= " You have successfully registered ";
			request.setAttribute("RegStatus", status);
			rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			}
			else
			{
				System.out.println(result);
				String status= " Registration failed!!! ";
				request.setAttribute("RegStatus", status);
				rd=request.getRequestDispatcher("addStudent.jsp");
				rd.forward(request, response);
			}
		}
		else if (op != null && op.equals("updateStud"))
		{
			
			int id = Integer.parseInt(request.getParameter("studid"));
			Student	stud=new Student(studname, studage, studgenger, studaddr, studemail, studpass);
			stud.setId(id);
			result = sdao.updateStudent(stud);
			
			if (result) 
			{
				System.out.println(result);
				String status= " You have successfully updated your profile ";
				request.setAttribute("status", status);
				rd=request.getRequestDispatcher("successPage.jsp");
				rd.forward(request, response);
			} 
			else 
			{

				System.out.println(result);
				String status= " updation failed!!! ";
				request.setAttribute("RegStatus", status);
				rd=request.getRequestDispatcher("updateProfile.jsp");
				rd.forward(request, response);
			}
		}

	}
}


















