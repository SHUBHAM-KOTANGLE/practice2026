import java.time.LocalDate;
public record Order(int id,String customerName,String productName,double amount,String status,LocalDate orderDate) {}