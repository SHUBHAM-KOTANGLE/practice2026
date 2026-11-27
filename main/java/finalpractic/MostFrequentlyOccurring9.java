package finalpractic;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentlyOccurring9 {

    public static void main(String[] args) {
//        Find the most frequently occurring word
        List<String> words = List.of(

                "java", "spring", "java",
                "hibernate", "spring", "java",
                "microservices", "spring",
                "apple","apple","apple"
        );
        Map.Entry<String, Long> stringLongEntry = words.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(stringLongEntry);

        Map.Entry<String, Long> mostFrequent = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println(mostFrequent);



    }
}
