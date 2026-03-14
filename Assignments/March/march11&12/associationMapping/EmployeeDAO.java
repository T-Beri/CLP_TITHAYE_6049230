package cgDemo.associationMapping;
import java.util.List;

import jakarta.persistence.*;


public class EmployeeDAO {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em= emf.createEntityManager();
	
	public void insertEmployee(Employee e, Department d) {
		em.getTransaction().begin();
		
		d.getEmployees().add(e); //added emp in dept
		e.setDept(d);
		
		em.persist(d);
		
		em.getTransaction().commit();
	}
	
	public void fetchEmployeeDetails() {
		String jpql = "Select e.empname, d.name, d.mgrname from Employee e join e.dept d";
		  List<Object[]> list =
		            em.createQuery(jpql, Object[].class).getResultList();

		    for(Object[] obj : list) {
		        System.out.println(
		                "Employee : " + obj[0] +
		                " Dept : " + obj[1] +
		                " Manager : " + obj[2]);
		    	}
	
	
			}
	public void countEmployeesPerDept() {

	    String jpql =
	        "SELECT d.name, COUNT(e) " +
	        "FROM Department d LEFT JOIN d.employees e " +
	        "GROUP BY d.name";

	    List<Object[]> list =
	        em.createQuery(jpql, Object[].class).getResultList();

	    for(Object[] obj : list) {
	        System.out.println(
	            "Department : " + obj[0] +
	            " Employees : " + obj[1]);
	    }
	}
	
	public void fetchEmployeesByDept(String deptName) {

	    String jpql =
	        "SELECT e FROM Employee e WHERE e.dept.name = :dname";

	    List<Employee> list =
	        em.createQuery(jpql, Employee.class)
	          .setParameter("dname", deptName)
	          .getResultList();

	    for(Employee e : list) {
	        System.out.println(e.getEmpid() + " " + e.getEmpname());
	    }
	}
	public void fetchDeptUsingMobile(long mobile) {

	    String jpql =
	        "SELECT e.empid, e.empname, e.salary, d.name, d.mgrname " +
	        "FROM Employee e JOIN e.dept d JOIN e.mobilenos m " +
	        "WHERE m = :mob";

	    List<Object[]> list =
	        em.createQuery(jpql, Object[].class)
	          .setParameter("mob", mobile)
	          .getResultList();

	    for(Object[] obj : list) {

	        System.out.println(
	            "EmpID : " + obj[0] +
	            " Name : " + obj[1] +
	            " Salary : " + obj[2] +
	            " Dept : " + obj[3] +
	            " Manager : " + obj[4]);
	    }
	}
	
	
	
	
	
}
