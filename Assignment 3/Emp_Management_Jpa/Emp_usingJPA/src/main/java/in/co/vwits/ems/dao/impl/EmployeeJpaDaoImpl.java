package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeJpaDaoImpl implements EmployeeDao{
	
	private EntityManagerFactory factory;
	 public EmployeeJpaDaoImpl(){
		 factory=Persistence.createEntityManagerFactory("emsapp");
	 }

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Optional<Employee> findByID(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee s = em.find(Employee.class, id); //This fires select query.
		tx.commit();
		em.close();
		return Optional.of(s);
	}

	@Override
	public void Insert(Employee e) {
		EntityManager  em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e); 
		tx.commit();
		em.close();
		
	}

	@Override
	public void deleteById(int id) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Employee.class, id)); 
		tx.commit();
		em.close();
	}

	@Override
	public List<Employee> sortingByName(int key) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		String jpql="";
		if(key==1) {
		 jpql="FROM Employee ORDER BY name";
		}
		else  {
			jpql="FROM Employee ORDER BY name DESC";
		}
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;

	}

	@Override
	public List<Employee> sortingBySalary(int key) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		String  jpql="";
		if(key==1) {
		jpql="FROM Employee ORDER BY salary";
		}
		else {
			jpql="FROM Employee ORDER BY salary DESC";
		}
		
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
	}

	@Override
	public void UpdateBySalary(int id, int salary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String jpql="FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		tx.commit();
		em.close();
		return employeeList;
	}


}
