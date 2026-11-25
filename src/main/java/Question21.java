import java.util.*;
import java.time.*;

public class Question21 {

    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order(1,"Amit","Laptop",65000,"COMPLETED", LocalDate.now()),
            new Order(2,"Rahul","Mouse",800,"PENDING", LocalDate.now().minusDays(1)),
            new Order(3,"Amit","Phone",30000,"COMPLETED", LocalDate.now()),
            new Order(4,"Sneha","Desk",9000,"CANCELLED", LocalDate.now().minusDays(2)),
            new Order(5,"Neha","Chair",4500,"COMPLETED", LocalDate.now())
        );

        /*
         * QUESTION 21
         * Find today's orders.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        List<Order> list = orders.stream()
                .filter(order -> order.orderDate().equals(LocalDate.now()))
                .toList();
        System.out.println(list);

    }
}
