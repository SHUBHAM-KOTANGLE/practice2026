package finalpractic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestTotalSalaryExpenditure {

    public static void main(String[] args) {
//        Find the department with the highest total salary expenditure
        List<Employeee> employeees = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Priya", "HR", 70000),
                new Employeee(4, "Sneha", "HR", 85000),
                new Employeee(5, "Vikas", "Finance", 90000),
                new Employeee(6, "Karan", "Finance", 75000)
        );

        Map.Entry<String, Double> stringDoubleEntry = employeees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment,
                        Collectors.summingDouble(Employeee::getSalary))
                ).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(stringDoubleEntry);


    }
}
