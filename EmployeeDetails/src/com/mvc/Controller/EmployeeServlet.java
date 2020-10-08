package com.mvc.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.Dao.EmployeeDao;
import com.mvc.Dao.EmployeeDaoImpl;
import com.mvc.Pojo.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeDao edao=new EmployeeDaoImpl();
		boolean result;
		RequestDispatcher rd;
		String op=request.getParameter("operation");
		HttpSession session=request.getSession();
		
		
		List<Employee> elist=edao.ListOfEmployee();
		session.setAttribute("elist", elist);
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
		if(op!=null && op.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("EmpId"));
			result=edao.deleteEmployee(id);
			if (result)
			{
				String status= " employee deleted ";
				request.setAttribute("status", status);
				rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}	
		else 
			{
			String status= " employee deletion failed ";
			request.setAttribute("empstatus", status);
			rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			}
		}
		else
		{
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		EmployeeDao edao=new EmployeeDaoImpl();
		boolean result;
		RequestDispatcher rd;
		HttpSession session=request.getSession();
		String op=request.getParameter("operation");
		String empname=request.getParameter("employeeName");
		String empemail=request.getParameter("employeeemail");
		String empaddress=request.getParameter("employeeaddress");
		
		if (op != null && op.equals("addEmployee"))
		{
			Employee empl=new Employee(empname, empemail, empaddress);
			result=edao.addEmployee(empl);
			if(result)
			{
				System.out.println(result);
				String status= " You have successfully registered ";
				request.setAttribute("RegStatus", status);
				List<Employee> elist=edao.ListOfEmployee();
				session.setAttribute("elist", elist);
				rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else
			{
				System.out.println(result);
				String status= " Registration failed!!! ";
				request.setAttribute("RegStatus", status);
				rd=request.getRequestDispatcher("addEmployee.jsp");
				rd.forward(request, response);
			}
		}
	}

}
