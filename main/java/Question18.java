import java.util.*;
import java.time.*;

public class Question18 {

    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order(1,"Amit","Laptop",65000,"COMPLETED", LocalDate.now()),
            new Order(2,"Rahul","Mouse",800,"PENDING", LocalDate.now().minusDays(1)),
            new Order(3,"Amit","Phone",30000,"COMPLETED", LocalDate.now()),
            new Order(4,"Sneha","Desk",9000,"CANCELLED", LocalDate.now().minusDays(2)),
            new Order(5,"Neha","Chair",4500,"COMPLETED", LocalDate.now())
        );

        /*
         * QUESTION 18
         * Calculate total revenue.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        Optional<Double> reduce = orders.stream()
                .map(order -> order.amount())
                .reduce((a, b) -> a + b);
        System.out.println(reduce.get());

    }
}










