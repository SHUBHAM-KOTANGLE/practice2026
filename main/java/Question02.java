import java.util.*;
import java.time.*;

public class Question02 {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1,"Amit","IT",85000,28,"Pune",2022,true),
            new Employee(2,"Rahul","HR",60000,31,"Nagpur",2020,true),
            new Employee(3,"Sneha","IT",95000,26,"Mumbai",2023,true),
            new Employee(4,"Vikas","Finance",72000,35,"Delhi",2019,false),
            new Employee(5,"Neha","Sales",67000,30,"Pune",2021,true),
            new Employee(6,"Pooja","IT",91000,25,"Nagpur",2024,true),
            new Employee(7,"Rohit","Sales",78000,32,"Mumbai",2022,true),
            new Employee(8,"Karan","HR",58000,29,"Pune",2023,true)
        );

        /*
         * QUESTION 2
         * Print names of employees working in IT department.
         *
         * Solve using Java Stream API & Java.
         */

        // Write your solution here
//        Java
        List<Employee> listJava =new ArrayList<>();

        for (Employee employee:employees){
            if(employee.department().equals("IT")){
                System.out.println(employee.name() +"  " + employee.department());
            }
        }




//        Stream
        List<String> it = employees.stream()
                .filter(emp -> emp.department().equals("IT"))
                .map(emp -> emp.name() + emp.city())
                .toList();
//        System.out.println(it);

    }
}
