package spring.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.model.Employee;
import spring.mvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@RequestMapping(value="/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee",listEmployee);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping (value ="/newEmployee", method = RequestMethod.GET)
	public ModelAndView AddNewEmployee(ModelAndView model) {
		Employee emp = new Employee();
		model.addObject("employee",emp);
		model.setViewName("employeeForm");
		
		return model;
		
	}
	
	 @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	        if (employee.getId() == 0) 
	        {
	            employeeService.addEmployee(employee);
	        } 
	        else 
	        {
	            employeeService.updateEmployee(employee);
	        }
	        return new ModelAndView("redirect:/");
	    }
	 
	 @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	    public ModelAndView deleteEmployee(HttpServletRequest request) {
	        int employeeId = Integer.parseInt(request.getParameter("id"));
	        employeeService.deleteEmployee(employeeId);
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	        int employeeId = Integer.parseInt(request.getParameter("id"));
	        Employee employee = employeeService.getEmployee(employeeId);
	        ModelAndView model = new ModelAndView("employeeForm");
	        model.addObject("employee", employee);
	 
	        return model;
	    }
}
