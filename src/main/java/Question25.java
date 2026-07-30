import java.util.*;
import java.time.*;

public class Question25 {

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
         * QUESTION 25
         * Sort students by marks descending.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        List<Student> list = students.stream()
                .sorted(Comparator.comparingDouble(Student::marks).reversed())
                .toList();
        System.out.println(list);

    }
}
