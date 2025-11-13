import java.util.*;

class Invoice {
    String transactionId;
    Invoice(String id) {
        transactionId = id;
    }
    public String toString() {
        return transactionId;
    }
}

public class InvoiceConstructorRef {
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("TXN1001", "TXN1002", "TXN1003");
        List<Invoice> invoices = new ArrayList<>();
        ids.forEach(id -> invoices.add(new Invoice(id)));
        invoices.forEach(System.out::println);
    }
}
