package sand.HibernateSandBox;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import sand.HibernateUtilSingleton;

public class Main {
	
	public static void main(String[] args) {
        Main aSillyHibernateUseExample = new Main();   
        Employee e1 = new Employee();
        e1.setFirstName("John");
        e1.setLastName("Smith");
        e1.setSalary(200);
       
        aSillyHibernateUseExample.addNewUsers(e1);
	}

	private void addNewUsers(Employee employee) {
		 Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
	        /*
	         * all database interactions in Hibernate are required to be inside a transaction.
	         */
	 //       Transaction transaction = session.beginTransaction();	           
	        /*
	         * save each instance as a record in the database
	         */
	 //       session.save(employee);	        
	 //       transaction.commit();
	        /*
	         * prove that the User instances were added to the database and that
	         * the instances were each updated with a database generated id.
	         */
	 //       System.out.println("An Employee generated ID is: " + employee.getId());
	        
	        Session session2 = HibernateUtilSingleton.getSessionFactory().getCurrentSession();	        
	        Transaction transaction2 = session2.beginTransaction();
	        int x = 1;
	        String y = "'John'";
	        Query query = session2.createQuery("select last_name, first_name from Employee");
	        Query query2 = session2.createQuery("select first_name from Employee where first_name = " + y);
	        Query query3 = session2.createQuery("select salary from Employee where id = " + x);
	        List last_name = query.list();
	        List first_name = query2.list();
	        List salary = query3.list();
	        List namePair = new ArrayList<String>();
	        
	        List<Object[]> people = (List<Object[]>)query.list();
	        for(Object[] person:people)
	        {
	        	String first_name1 = (String)person[1];
	        	String last_name1 =(String)person[0];
	        	namePair.add(first_name1);
	        	namePair.add(last_name1);
	        }
	        
	      //  List last_name = query.list();
	        session2.save(employee);	        
	        transaction2.commit();
	        System.out.println("First Name " + last_name);
	        System.out.println("First Name " + first_name);   
	        System.out.println("First Name " + salary);
	        System.out.println(namePair);
	}

}
