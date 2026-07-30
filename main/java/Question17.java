import java.util.*;
import java.time.*;

public class Question17 {

    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order(1,"Amit","Laptop",65000,"COMPLETED", LocalDate.now()),
            new Order(2,"Rahul","Mouse",800,"PENDING", LocalDate.now().minusDays(1)),
            new Order(3,"Amit","Phone",30000,"COMPLETED", LocalDate.now()),
            new Order(4,"Sneha","Desk",9000,"CANCELLED", LocalDate.now().minusDays(2)),
            new Order(5,"Neha","Chair",4500,"COMPLETED", LocalDate.now())
        );

        /*
         * QUESTION 17
         * Find completed orders.
         *
         * Solve using Java Stream API & Java.
         */

        // Write your solution here
        List<Order> completed = orders.stream()
                .filter(order -> order.status().equals("COMPLETED"))
                .toList();
        System.out.println(completed);

    }
}
