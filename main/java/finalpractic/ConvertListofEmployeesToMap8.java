package finalpractic;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListofEmployeesToMap8 {

    public static void main(String[] args) {
        List<Employeee> employees = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Priya", "HR", 70000),
                new Employeee(4, "Sneha", "HR", 85000)
        );

//        Convert employees into a Map where the department is the key and the highest-paid employee is the value.
        Map<String, String> collect = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                                        .findFirst()
                                        .map(emp -> emp.getName())
                                        .orElse(null)
                        )));
        System.out.println(collect);


        Map<String, String> collect4 = employees.stream()
                .collect(Collectors.toMap(
                        Employeee::getDepartment,                                              // 1. Key: Department ("IT", "HR")
                        Function.identity(),                                                   // 2. Value: Full Employeee object (so we can compare salaries)
                        BinaryOperator.maxBy(Comparator.comparingDouble(Employeee::getSalary)), // 3. Merge Function: keeps the higher-paid Employeee on duplicate key
                        LinkedHashMap::new                                                     // 4. Optional: preserves IT -> HR order
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getName(),
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println(collect4);




    }
}
