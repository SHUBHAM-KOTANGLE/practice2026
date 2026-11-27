package finalpractic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondHighestSalary {

    public static void main(String[] args) {

//        Find the second-highest salary in each department

        List<Employeee> employeees = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Raj", "IT", 90000),
                new Employeee(4, "Priya", "HR", 70000),
                new Employeee(5, "Sneha", "HR", 85000),
                new Employeee(6, "Neha", "HR", 75000)
        );


        List<Employeee> list2 = employeees.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                .toList();
        Map<String, List<Employeee>> collect1 = list2.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment));
        List<Map.Entry<String, List<Employeee>>> list1 = collect1.entrySet().stream()
                .skip(1)
                .toList();

        System.out.println(list1);

        Map<String, Employeee> collect = employeees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                                .orElse(null)
                )));

        System.out.println(collect);


    }
}
