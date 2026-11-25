package finalpractic;

import java.util.*;
import java.util.stream.Collectors;

public class Problrm1 {





     public static void highest(List<Employee> employees){
         Map<String, HashSet<Double>> map= new HashMap<>();
         for (Employee employee:employees){
             HashSet<Double> orDefault = map.getOrDefault(employee.getDepartment(), new HashSet<>());
             orDefault.add(employee.getSalary());
             map.put(employee.getDepartment(), orDefault);
         }
         Map<String,Employee> ans = new HashMap<>();
         for(Map.Entry<String, HashSet<Double>> entry :map.entrySet()){


            for ( Double val:entry.getValue()){


            }


         }
     }



    public static void main(String[] args) {
        //        Using Streams, find the highest-paid employee in each department
        List<Employee> employeess = List.of(
                new Employee(1, "Amit", "IT", 80000),
                new Employee(2, "Rahul", "IT", 95000),
                new Employee(3, "Priya", "HR", 70000),
                new Employee(4, "Sneha", "HR", 85000),
                new Employee(5, "Vikas", "Finance", 90000),
                new Employee(6, "Karan", "Finance", 75000)
        );
        highest(employeess);

        Map<String, Employee> collect = employeess.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
        System.out.println(collect);
    }

}
