import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question07 {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 85000, 28, "Pune", 2022, true),
                new Employee(2, "Rahul", "HR", 60000, 31, "Nagpur", 2020, true),
                new Employee(3, "Sneha", "IT", 95000, 26, "Mumbai", 2023, true),
                new Employee(4, "Vikas", "Finance", 72000, 35, "Delhi", 2019, false),
                new Employee(5, "Sneha", "Sales", 67000, 30, "Pune", 2021, true),
                new Employee(6, "Pooja", "IT", 91000, 25, "Nagpur", 2024, true),
                new Employee(7, "Rohit", "Sales", 78000, 32, "Mumbai", 2022, true),
                new Employee(8, "Pooja", "HR", 58000, 29, "Pune", 2023, true)
        );

        /*
         * QUESTION 7
         * Find duplicate employee names (modify data if needed).
         *
         * Solve using Java Stream API & java.
         */

        // Write your solution here
//        java
//        without set
        Map<String,Integer> map = new HashMap<>();
        List<String> list4 =new ArrayList<>();
        for (Employee employee:employees){
            map.put(employee.name(),map.getOrDefault(employee.name(),0)+1);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            if(entry.getValue() > 1){
                list4.add(entry.getKey());
            }
        }
        System.out.println("Without Set "+list4);


//      with set
        Set<String> set1 =new HashSet<>();
        List<String> list12 = new ArrayList<>();
        for(Employee employee:employees){
            if(!set1.add(employee.name())){
                list12.add(employee.name());
            }
        }
//        System.out.println(frequency);
        System.out.println("SET = "+set1    +" ||||  LIST = "+ list12);




//        stream
//        with use of set
        Set set = new HashSet();
        List<Employee> list = employees.stream()
                .filter(emp -> !set.add(emp.name()))
                .toList();
//        System.out.println(list);
//      without set
        List<String> optimizedList = employees.stream()
                .collect(Collectors.groupingBy(Employee::name, Collectors.counting())) // Map<String, Long>
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(optimizedList);


    }
}
