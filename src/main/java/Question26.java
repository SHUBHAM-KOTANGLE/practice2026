import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question26 {

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
         * QUESTION 26
         * Find students scoring above average.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        Double collect = students.stream()
                .collect(Collectors.averagingDouble(Student::marks));
        List<Student> list = students.stream().filter(student -> student.marks() > collect)
                .toList();
        System.out.println( "AVG "+collect +" "+ list);


    }
}
