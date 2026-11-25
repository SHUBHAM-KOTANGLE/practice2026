import java.util.*;
import java.time.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Question24 {

    public static void main(String[] args) {

        List<Student> students = List.of(
            new Student(1,"Amit",78,"CSE",3),
            new Student(2,"Rahul",88,"IT",3),
            new Student(3,"Sneha",91,"CSE",4),
            new Student(4,"Neha",84,"ECE",2),
            new Student(5,"Pooja",95,"IT",4),
            new Student(6,"Karan",73,"ECE",2)
        );

        /*
         * QUESTION 24
         * Find average marks year wise.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        HashMap<Integer, Double> collect = students.stream()
                .collect(Collectors.groupingBy(
                        Student::year,
                        HashMap::new,
                        Collectors.averagingDouble(Student::marks)
                ));
        System.out.println(collect);

    }
}
