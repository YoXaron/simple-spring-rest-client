package com.yoxaron.spring.rest;

import com.yoxaron.spring.rest.configuration.MyConfig;
import com.yoxaron.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        //get all
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        //get by ID
        Employee empById = communication.getEmployee(2);
        System.out.println(empById);

        //add new employee
        Employee emp = new Employee("Ivan", "Sidorov", "HR", 500);
        communication.saveEmployee(emp);

        //update employee
        emp = new Employee("Ivan", "Sidorov", "IT", 900);
        emp.setId(9);
        communication.saveEmployee(emp);

        //delete employee
        communication.deleteEmployee(9);
    }
}
