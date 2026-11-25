import java.util.*;
import java.time.*;

public class Question28 {

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
            new Transaction(1,"ACC1","CREDIT",10000, LocalDate.now()),
            new Transaction(2,"ACC1","DEBIT",5000, LocalDate.now()),
            new Transaction(3,"ACC2","CREDIT",70000, LocalDate.now().minusDays(1)),
            new Transaction(4,"ACC2","DEBIT",10000, LocalDate.now()),
            new Transaction(5,"ACC3","CREDIT",90000, LocalDate.now())
        );

        /*
         * QUESTION 28
         * Find all transactions greater than 50000.
         *
         * Solve using Java Stream API.
         */

        // Write your solution here
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.amount() > 50000)
                .toList();
        System.out.println(list);

    }
}
