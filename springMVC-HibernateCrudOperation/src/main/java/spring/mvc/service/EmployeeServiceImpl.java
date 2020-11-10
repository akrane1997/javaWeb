package spring.mvc.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.dao.EmployeeDao;
import spring.mvc.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDao.deleteEmployee(employeeId);

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee getEmployee(int employeeid) {
		return employeeDao.getEmployee(employeeid);
	}

}
