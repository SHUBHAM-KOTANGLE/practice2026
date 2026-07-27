import java.util.*;
import java.time.*;
import java.util.stream.Collector;

public class Question15 {

    public static void main(String[] args) {

        List<Product> products = List.of(
            new Product(1,"Laptop","Electronics",65000,10,4.8),
            new Product(2,"Mouse","Electronics",800,50,4.2),
            new Product(3,"Chair","Furniture",4500,15,4.7),
            new Product(4,"Desk","Furniture",9000,8,4.5),
            new Product(5,"Phone","Electronics",30000,20,4.9),
            new Product(6,"Bottle","Home",500,40,4.1),
            new Product(7,"Fan","Home",2500,18,4.6),
            new Product(8,"Book","Education",700,100,4.9)
        );

        /*
         * QUESTION 15
         * Find top 5 highest rated products.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        List<Product> list = products.stream().sorted(Comparator.comparingDouble(Product::rating).reversed())
                .limit(5)
                .toList();
        System.out.println(list);

    }
}
