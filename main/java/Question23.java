import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question23 {

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
         * QUESTION 23
         * Find topper of every branch.
         *
         * Solve using Java Stream API.
         */
//java
        Map<String,List<Student>> map = new HashMap<>();
        for(Student student:students){

            List<Student> list = map.getOrDefault(student.branch(), new ArrayList<>());
            list.add(student);
            map.put(student.branch(),list);

        }




//        string
        // Write your solution here
        Map<String, Optional<Student>> collect = students.stream()
//                .map(student -> student.branch() + student.marks())
                .collect(Collectors.groupingBy(
                        Student::branch,
                        HashMap::new,
                        Collectors.maxBy(Comparator.comparingDouble(Student::marks))
                ));
        System.out.println(collect);

    }
}
