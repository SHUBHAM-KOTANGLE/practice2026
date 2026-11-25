package finalpractic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateAverageSalary {

    public static void main(String[] args) {
//        Group employees by department and calculate average salary
        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 80000),
                new Employee(2, "Rahul", "IT", 95000),
                new Employee(3, "Raj", "IT", 90000),
                new Employee(4, "Priya", "HR", 70000),
                new Employee(5, "Sneha", "HR", 85000),
                new Employee(6, "Neha", "HR", 75000)
        );

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println();

//        Find the department with the highest total salary expenditure

        Map<String, Double> collect2  = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(collect2);
    }

}
