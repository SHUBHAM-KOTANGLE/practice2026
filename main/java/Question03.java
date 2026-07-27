import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question03 {

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
         * QUESTION 3
         * Find average salary department wise.
         *
         * Solve using Java Stream API & Java.
         */

        // Write your solution here
//       Java
       Map<String, double[]> map = new HashMap<>();
       for(Employee employee:employees){
           double[] arr = map.getOrDefault(employee.department(), new double[2]);
           arr[0]  += employee.salary();
           arr[1]++;

           map.put(employee.department(),arr);
       }
        System.out.println(map);
       for(Map.Entry<String, double[]> entry:map.entrySet()){

           System.out.println("Department - "+entry.getKey()+"  "+ entry.getValue()[0] / entry.getValue()[1]);

       }



//        Stream
        Map<String, Double> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
//        System.out.println(collect);

    }
}
