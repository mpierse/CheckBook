import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

public class Transaction {
    private final AtomicReference<Integer> id = new AtomicReference<Integer>();
    private final AtomicReference<LocalDate> date = new AtomicReference<LocalDate>();
    private String memo;
    private Payee payee;
    private TransactionType typee; // Credit (reduces the checkbook), Debit (increases the checkbook)
    private Double amount;

    public Transaction(String memo, Payee payee, TransactionType typee, Double amount) {
        this.typee = typee;
        this.memo = memo;
        this.payee = payee;
        this.amount = amount;
    }

    public Integer getId() {
        return id.get();
    }

    public LocalDate getDate() {
        return date.get();
    }

    public TransactionType getType() {
        return typee;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }

    public Double getAmount() {
        if (this.typee == TransactionType.DEBIT) {
            return amount;
        }
        return (-1.0 * amount);
    }
}
