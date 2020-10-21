package com.maven.Hibernate.Dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maven.Hibernate.Pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
	SessionFactory sf = con.buildSessionFactory();
	
	
	@Override
	public Integer AddEmployee(String name , String email) {
		Session session = sf.openSession();
		Transaction tx=null;
		Integer empId=null;
		try
		{
			tx=session.beginTransaction();
			Employee employee = new Employee(name,email);
			empId=(Integer) session.save(employee);
			tx.commit();
			
		}
		catch(HibernateException e)
		{
			if(tx!=null)
			{
				tx.rollback();
				System.out.println(e);
			}
		}
		finally
		{
			session.close();
		}
		return empId;
	}

	@Override
	public void UpdateEmployee(Integer id, String name) {
		Session session = sf.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			Employee emp=(Employee)session.get(Employee.class, id);
			emp.setName(name);
			session.update(emp);
			tx.commit();
		}
		catch(HibernateException e) 
		{
			if(tx!=null)
			{
				tx.rollback();
				System.out.println(e);
			}
		}
		finally
		{
			session.close();
		}
		
	}

	@Override
	public void DeleteEmployee(Integer id) {
		Session session = sf.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			Employee employee=(Employee)session.get(Employee.class, id);
			session.delete(employee);
			tx.commit();
		}
		catch(HibernateException e) 
		{
			if(tx!=null)
			{
				tx.rollback();
				System.out.println(e);
			}
		}
		finally
		{
			session.close();
		}
	}

	@Override
	public void ListOfEmployee() {
		Session session = sf.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			List<Employee> employee=session.createQuery("from Employee").list();
			for(Employee temp : employee)
			{
				System.out.println("Name:-"+temp.getName() + "  Email:-"+temp.getEmail());
			}
			tx.commit();
		}
		catch(HibernateException e) 
		{
			if(tx!=null)
			{
				tx.rollback();
				System.out.println(e);
			}
		}
		finally
		{
			session.close();
		}
		
	}
}
