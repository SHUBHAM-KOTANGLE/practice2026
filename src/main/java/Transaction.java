import java.time.LocalDate;
public record Transaction(int id,String accountNo,String type,double amount,LocalDate date) {}