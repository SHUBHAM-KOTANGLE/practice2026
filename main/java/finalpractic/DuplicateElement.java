package finalpractic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateElement {

        public static void main(String[] args) {
    //        Find duplicate elements and their frequency
            List<Integer> numbers = List.of(
                    10, 20, 30, 10, 40, 20, 50, 10, 30, 60
            );


            List<Map.Entry<Integer, Long>> list = numbers.stream()
                    .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                    .entrySet()
                    .stream().filter(num -> num.getValue() > 1).toList();
            System.out.println(list);

        }

    }
