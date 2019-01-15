import java.time.LocalDate;

public interface AccountBook {
    public Integer getId();
    public LocalDate getDate();
    public TransactionType getType();
    public String getMemo() ;
    public void setMemo(String memo);
    public Payee getPayee();
    public void setPayee(Payee payee);
    public Double getAmount();
}
