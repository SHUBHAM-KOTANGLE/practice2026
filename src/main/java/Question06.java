import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question06 {

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
         * QUESTION 6
         * Count employees city wise.
         *
         * Solve using Java Stream API & java.
         */

        // Write your solution here
//        java
        Map<String,Integer> map = new HashMap<>();
        int count=0;
        for(Employee employee:employees){

            int i = map.getOrDefault(employee.city(), 0) + 1;
            map.put(employee.city(),i);

        }
        System.out.println(map);



//        java
        Map<String, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::city, Collectors.counting()));
//        System.out.println(collect);

    }
}
