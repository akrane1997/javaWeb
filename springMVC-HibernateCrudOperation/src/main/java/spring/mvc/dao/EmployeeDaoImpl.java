package spring.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employee = sessionFactory.getCurrentSession().createQuery("from Employee").list();
		return employee;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(employee !=null)
		{
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(int employeeid) {
		Employee employee=(Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeid);
		return employee;
	}

}
