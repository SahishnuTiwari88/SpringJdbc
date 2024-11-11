package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;
//import com.spring.jdbc.noxml.JDBCConfig;
// this is main app/test
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "The programing has started......" );
        //Spring jdbc => JdbcTemplate --> used to create object of jdbctemplate class in order to perform database operation like insert,
        // delete, update and reading data from database
        
       //for that we have to create object of the jdbctemplate using ApplicationContext
        ApplicationContext con = new ClassPathXmlApplicationContext("com/spring/jdbc/jdbcconfig.xml");
       // ApplicationContext con  = new AnnotationConfigApplicationContext(JDBCConfig.class);
        
        
      // JdbcTemplate temp =  con.getBean("jdbctemplate",JdbcTemplate.class);//it is used when we directly pass value
        
        StudentDao temp =  con.getBean("studentDao",StudentDaoImpl.class);//we can pass interface here also
        
        // insert query
       // String query = "insert into student(id,name,city)values(?,?,?)";
        
//       int result =  temp.update(query,2,"Sarvesh T","Delhi");// direct method to insert data in database(fire query)
//       System.out.println("number of record inserted ...."+result);
        
        
        
        //INSERT
//        Student student = new Student();//we have to create object of student to save data
//        student.setId(5);
//        student.setName("Sahishnu Tiwari");
//        student.setCity("Ghaziabad");
//        int result = temp.insert(student);
//        System.out.println("Number of record added..."+result);
        
        
        // UPDATE
        
//        Student student  = new Student();
//        student.setId(3);
//        student.setName("Harsh T");
//        student.setCity("ANVT");
//        int result = temp.change(student);
//        System.out.println("rows changed/update..."+result);  //direct setting value
//        
        
        //update user input
//        System.out.println("Enter information to change data :"); //user defined setting
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter old id :");
//        int id = sc.nextInt();
//        System.out.println("Enter new name :");
//        String name = sc.next();
//        
//        System.out.println("Enter new city :");
//        String city = sc.next();
//        
//        Student student = new Student();
//        student.setId(id);
//        student.setName(name);
//        student.setCity(city);
//        int result = temp.change(student);
//        System.out.println("rows changed/update..."+result); 
        
        // DELETE
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter id");
//        int id = sc.nextInt();
//        
//        int result = temp.remove(id);
//        System.out.println("deleted rows..."+result);
        
     //RETRIEVE  single data 
        
//        System.out.println("Enter id to retrive information :");
//        
//        Scanner sc = new Scanner(System.in);
//      System.out.println("Enter  id :");
//      int id = sc.nextInt();
//      
//      Student student = new Student();
//      student.setId(id);
//      
//     Student result = temp.getStudent(id);
//     System.out.println("fetched data.."+result);
     
     // Retrieve multiple data
     Student student =new Student();
     List<Student> result = temp.getAllStudent();
     for(Student s:result) {
    	 System.out.println("data Retrieved..."+s);
         
     }
    
     
        
        
    }
}
