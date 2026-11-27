package finalpractic;




import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Top2HighestPaidEmployees {

//    Find the top 2 highest-paid employees in each department
    public static void main(String[] args) {
        List<Employeee> employees = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Raj", "IT", 90000),
                new Employeee(4, "Priya", "HR", 70000),
                new Employeee(5, "Sneha", "HR", 85000),
                new Employeee(6, "Neha", "HR", 75000)
        );

        record empSalary(String name,Double salary){
        }
        employees.stream()
                .map(e -> new empSalary(
                        e.getName(),
                        e.getSalary()))
                .toList();

        Map<String, List<Employeee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                                .limit(2)
                                .collect(Collectors.toList())
                )));

        collect.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(collect);


        Map<String, List<String>> collect1 = collect.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(e -> e.getName() + e.getDepartment() + e.getSalary())
                                .toList()
                ));

        System.out.println(collect1);


//        {HR=[Sneha:85000, Neha:75000], IT=[Rahul:95000, Raj:90000]}
        Map<String, List<String>> converted = collect.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,// HR , IT
                        entry -> entry.getValue().stream()
                                .map(e -> e.getName() + ":" + (int) e.getSalary())
                                .toList()
                ));

        System.out.println(converted);
    }

}
