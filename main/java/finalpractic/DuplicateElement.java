package finalpractic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElement {

        public static void main(String[] args) {
    //        Find duplicate elements and their frequency
            List<Integer> numbers = List.of(
                    10, 20, 30, 10, 40, 20, 50, 10, 30, 60
            );


            Map<Integer, Long> collect = numbers.stream()
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

            collect.entrySet().removeIf(entry -> entry.getValue() <= 1 );

            System.out.println(collect);

        }

    }
