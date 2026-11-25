import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class Question13 {

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
         * QUESTION 13
         * Find most expensive product in every category.
         *
         * Solve using Java Stream API & java.
         */

        // Write your solution here
//        JAVA
        Map<String, List<Product>> categoryMap = new HashMap<>();
                
        for (Product product:products){
            List<Product> emptyList = categoryMap.getOrDefault(product.category(), new ArrayList<>());
            emptyList.add(product);
            categoryMap.put(product.category(), emptyList);
        }
        Map<String,Product> exp = new HashMap<>();
//        double expensive = 0.0;
        for(Map.Entry<String,List<Product>> entry:categoryMap.entrySet()){

            List<Product> value = entry.getValue();
//            Collections.max(Comparator.comparingDouble(Product::price));
            value.sort(Comparator.comparingDouble(Product::price).reversed());
            exp.put(entry.getKey(),value.get(0));
        }
//        OPTIMISED ONE INSTED OF SORT
//        for (Map.Entry<String, List<Product>> entry : categoryMap.entrySet()) {
//            List<Product> value = entry.getValue();
//            Product mostExpensive = Collections.max(value, Comparator.comparingDouble(Product::price));
//            exp.put(entry.getKey(), mostExpensive);
//        }
        for (Map.Entry<String, Product > entry :exp.entrySet()){
            System.out.println(entry.getKey()  +" -  "+entry.getValue());
        }
        
        
        
        
        
        
        
//        stream
        LinkedHashMap<String, List<Product>> collect = products.stream().sorted(Comparator.comparingDouble(Product::price).reversed())
                .collect(Collectors.groupingBy(
                        Product::category,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
        for(Map.Entry<String, List<Product>> entry :collect.entrySet()){
            System.out.println(entry.getKey() +"  "+ entry.getValue());
        }

    }
}























