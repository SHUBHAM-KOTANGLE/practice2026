package finalpractic;

import java.util.*;
import java.util.stream.Collectors;

public class Problrm1 {





     public static void highest(List<Employeee> employeees){
         Map<String, HashSet<Double>> map= new HashMap<>();
         for (Employeee employeee : employeees){
             HashSet<Double> orDefault = map.getOrDefault(employeee.getDepartment(), new HashSet<>());
             orDefault.add(employeee.getSalary());
             map.put(employeee.getDepartment(), orDefault);
         }
         Map<String, Employeee> ans = new HashMap<>();
         for(Map.Entry<String, HashSet<Double>> entry :map.entrySet()){


            for ( Double val:entry.getValue()){


            }


         }
     }



    public static void main(String[] args) {
        //        Using Streams, find the highest-paid employee in each department
        List<Employeee> employeesses = List.of(
                new Employeee(1, "Amit", "IT", 80000),
                new Employeee(2, "Rahul", "IT", 95000),
                new Employeee(3, "Priya", "HR", 70000),
                new Employeee(4, "Sneha", "HR", 85000),
                new Employeee(5, "Vikas", "Finance", 90000),
                new Employeee(6, "Karan", "Finance", 75000)
        );
        highest(employeesses);

        Map<String, Employeee> collect = employeesses.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employeee::getSalary)), Optional::get)));
        System.out.println(collect);
    }

}
