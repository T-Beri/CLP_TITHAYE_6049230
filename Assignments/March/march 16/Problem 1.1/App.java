package cg.demo.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demo.springcore.beans.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConf.xml");
        Employee e1 = (Employee )ac.getBean("emp1");
        System.out.println(e1.toString());
        
    }
}
