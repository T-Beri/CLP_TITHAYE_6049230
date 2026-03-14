package cgDemo.associationMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//ONE TO MANY
// many side is the owning side
// 3 tables are made in this relationship

public class App2 {
	public static void main(String[] args) {
		EntityManagerFactory emf=  Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        
        Employee emp1= new Employee();
      
        emp1.setEmpname("Levi");
        emp1.setSalary(35000);
        
        Employee emp2= new Employee();
        emp2.setEmpname("Liam");
        emp2.setSalary(30000);
        
        Department d1= new Department();
        d1.setDeptid(102);
        d1.setMgrname("Darius");
        d1.setName("IT");
        
        
        emp1.setDept(d1);
        emp2.setDept(d1);
        
        em.persist(d1);
        em.persist(emp1);
        em.persist(emp2);
     
        
        em.getTransaction().commit();
        
        System.out.println("Inserted successfully!");
        em.close();
        emf.close();
        
	}
}
