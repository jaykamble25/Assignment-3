package in.co.vwits.ems.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;
import in.co.vwits.ems.dao.impl.EmployeeJpaDaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.service.EmployeeService;


public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao;
	 
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		dao=new EmployeeJpaDaoImpl();
	}
	
	//public List<String> sortingByName()
	//{
	//	return dao.findAll().stream().map(emp->emp.getName()).sorted().toList();
	//}
	public List<Employee> findAll()
	{
		return this.dao.findAll();
	
	}
	
	public Optional<Employee> findByID(int id)
	{
		
		return this.dao.findByID(id);
	
	}
	
	public void Insert(Employee e) {
		 
		this.dao.Insert(e);
		}
	
	public void deleteById(int id ) {
	this.dao.deleteById(id);
		}

	public List<Employee> sortingByName(int key)
	{
		return this.dao.sortingByName(key);
	}
	
	public List<Employee> sortingBySalary(int key)
	{
		
		return this.dao.sortingBySalary(key);
	}
	
	public void UpdateBySalary(int id,int salary)
	{
		this.dao.UpdateBySalary(id, salary);
	}
	

	
	/*public  void push()
	{
		dao.save();
	}
	*/
	
	

}
