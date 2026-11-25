package finalpractic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighestSalary {

    public static void main(String[] args) {

//        Find the second-highest salary in each department

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 80000),
                new Employee(2, "Rahul", "IT", 95000),
                new Employee(3, "Raj", "IT", 90000),
                new Employee(4, "Priya", "HR", 70000),
                new Employee(5, "Sneha", "HR", 85000),
                new Employee(6, "Neha", "HR", 75000)
        );


        List<Employee> list = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
        Map<String, List<Employee>> collect1 = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        List<Map.Entry<String, List<Employee>>> list1 = collect1.entrySet().stream()
                .skip(1)
                .toList();

        System.out.println(list1);


    }
}
