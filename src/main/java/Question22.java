import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question22 {

    public static void main(String[] args) {

        List<Order> orders = List.of(
            new Order(1,"Amit","Laptop",65000,"COMPLETED", LocalDate.now()),
            new Order(2,"Rahul","Mouse",800,"PENDING", LocalDate.now().minusDays(1)),
            new Order(3,"Amit","Phone",30000,"COMPLETED", LocalDate.now()),
            new Order(4,"Sneha","Desk",9000,"CANCELLED", LocalDate.now().minusDays(2)),
            new Order(5,"Neha","Chair",4500,"COMPLETED", LocalDate.now())
        );

        /*
         * QUESTION 22
         * Group orders customer wise and calculate total amount.
         *
         * Solve using Java Stream API & java .
         */
//      Java
        Map<String,Double> map1= new HashMap<>();
        for(Order order:orders){
            map1.put(order.customerName(), map1.getOrDefault(order.customerName(),0.0 )+order.amount());
        }
        System.out.println(map1 +"  ddd");

//      Stream
        // Write your solution here
        HashMap<String, Double> collect = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::customerName,
                        HashMap::new,
                        Collectors.summingDouble(Order::amount)));
        System.out.println(collect);
    }
}
