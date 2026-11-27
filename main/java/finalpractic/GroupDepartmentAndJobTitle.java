package finalpractic;



import production.practice26.Employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDepartmentAndJobTitle {
    public static void main(String[] args) {
//        Group employees first by department and then by designation.
        List<Employee> employeeessss = List.of(
                new Employee(1, "Amit", "IT", "Developer"),
                new Employee(2, "Rahul", "IT", "Developer"),
                new Employee(3, "Priya", "IT", "Tester"),
                new Employee(4, "Sneha", "HR", "Manager"),
                new Employee(5, "Neha", "HR", "Recruiter"),
                new Employee(6, "Raj", "HR", "Manager")
        );

        Map<String, Map<String, List<Employee>>> collect = employeeessss.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getDesignation)));

        System.out.println(collect);

        Map<String, Map<String, List<String>>> collect3 = employeeessss.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        LinkedHashMap::new, // preserves IT -> HR order
                        Collectors.groupingBy(
                                Employee::getDesignation,
                                LinkedHashMap::new, // preserves Developer -> Tester and Manager -> Recruiter order
                                Collectors.mapping(Employee::getName, Collectors.toList())
                        )
                ));

        System.out.println(collect3);

        Map<String, Map<String, List<String>>> collect7 = employeeessss.stream() // 1. Converts the List of Employee objects into a Stream
                .collect(Collectors.groupingBy(                                 // 2. Starts outer grouping to build the main Map<Department, InnerMap>
                        Employee::getDepartment,                                // 3. Outer Key: extracts department name ("IT", "HR") for each employee
                        LinkedHashMap::new,                                     // 4. Outer Map Type: uses LinkedHashMap to preserve insertion order (IT -> HR)
                        Collectors.groupingBy(                                  // 5. Outer Value (Downstream): groups employees inside each department by role
                                Employee::getDesignation,                       // 6. Inner Key: extracts designation ("Developer", "Tester", etc.)
                                LinkedHashMap::new,                             // 7. Inner Map Type: uses LinkedHashMap to preserve role order (Manager -> Recruiter)
                                Collectors.mapping(                             // 8. Inner Value (Downstream): transforms each Employee before collecting
                                        Employee::getName,                      // 9. Mapper: extracts only the String name ("Amit") instead of the whole Employee object
                                        Collectors.toList()                     // 10. Final Collector: gathers those extracted names into a List<String>
                                )                                               // 11. Closes Collectors.mapping()
                        )                                                       // 12. Closes inner Collectors.groupingBy()
                ));                                                             // 13. Closes outer Collectors.groupingBy() and .collect()

        System.out.println(collect7);                                            // 14. Prints the final nested map structure to the console

    }
}
