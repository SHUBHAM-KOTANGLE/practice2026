package finalpractic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateAverageSalary {

    public static void main(String[] args) {
//        Group employees by department and calculate average salary
        List<Employeee> employeees = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Raj", "IT", 90000),
                new Employeee(4, "Priya", "HR", 70000),
                new Employeee(5, "Sneha", "HR", 85000),
                new Employeee(6, "Neha", "HR", 75000)
        );

        employeees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment));
        System.out.println();

//        Find the department with the highest total salary expenditure

        Map<String, Double> collect2  = employeees.stream()
                .collect(Collectors.groupingBy(
                        Employeee::getDepartment,
                        Collectors.averagingDouble(Employeee::getSalary)));

        System.out.println(collect2);
    }

}
