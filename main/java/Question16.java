import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question16 {

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
         * QUESTION 16
         * Find category wise average price.
         *
         * Solve using Java Stream API & Java.
         */
//      Java
        Map<String,List<Product>> map = new HashMap<>();
        Map<String,Double> doubleMap = new HashMap<>();
        for(Product product:products){
            List<Product> list = map.getOrDefault(product.category(), new ArrayList<>());
            list.add(product);
            map.put(product.category(), list);
        }
        for (Map.Entry<String, List<Product>> entry :map.entrySet()){
            List<Product> value = entry.getValue();
            double sum =0;
            for(Product product:value){
                sum = sum + product.price();
            }
            double avg = value.isEmpty() ? 0 : sum / value.size() ;
            doubleMap.put(entry.getKey(), avg);

        }
        System.out.println(doubleMap);

        // Write your solution here
        HashMap<String, Double> collect = products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        HashMap::new,
                        Collectors.averagingDouble(Product::price)));
        System.out.println(collect);

    }
}



















