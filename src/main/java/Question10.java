import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question10 {

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
         * QUESTION 10
         * Group employees by department and sort by salary.
         *
         * Solve using Java Stream API & java.
         */

        // Write your solution here
//      Java
        Map<String,List<Employee>> mapEmp = new HashMap<>();

        for (Employee employee:employees){
            List<Employee> orDefault = mapEmp.getOrDefault(employee.department(), new ArrayList<>());
            orDefault.add(employee);//***********
            mapEmp.put(employee.department(),orDefault);
        }
        for(Map.Entry<String,List<Employee>> entry:mapEmp.entrySet()){
            List<Employee> value = entry.getValue();
            value.sort(Comparator.comparingDouble(Employee::salary).reversed());
            mapEmp.put(entry.getKey(),value);
        }
        for(Map.Entry<String,List<Employee>> entry:mapEmp.entrySet()){
            System.out.println("FINAL  "+entry.getKey()+"  "+entry.getValue());
        }









//      Stream
        List<Map.Entry<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Employee::department),
                        map -> map.entrySet()
                                .stream()
                                .sorted(Comparator.comparingDouble(entry ->
                                        entry.getValue()
                                                .stream()
                                                .mapToDouble(Employee::salary)
                                                .max()
                                                .orElse(0.0)))
                                .toList()));
        for(Map.Entry<String, List<Employee>> emp :collect){
            System.out.println(emp.getKey() +"  "+emp.getValue());
        }



    }
}
