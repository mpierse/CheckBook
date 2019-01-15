import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Checkbook {

private ArrayList<Transaction> transactionList = new ArrayList<>();

    public Checkbook(){}

    public Checkbook(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Checkbook(double cashAmount){
        this.add(new Transaction("",new Payee(),TransactionType.DEBIT, cashAmount));
    }

    public Checkbook(Payee owner, double cashAmount){
        this.add(new Transaction("",owner,TransactionType.DEBIT, cashAmount));
    }

    public int size(){
    return transactionList.size();
    }

    public boolean isEmpty(){
    return transactionList.isEmpty();
    }

    public boolean contains(Transaction transaction){
    return transactionList.contains(transaction);
    }

    public boolean add(Transaction transaction){
    return transactionList.add(transaction);
    }

    public void remove(Transaction transaction) {
        transactionList.remove(transaction);
    }

    public Iterator iterator() {
        return transactionList.iterator();
    }

    public Transaction[] toArray() {
        Transaction[] arr = transactionList.toArray(new Transaction[0]);
        return arr;
    }

    public Transaction[] toArray(Transaction[] input) {
        for (Transaction t : input) {
            transactionList.add(t);
        }
        return transactionList.toArray(new Transaction[transactionList.size()]);
    }

    public double checkbookValue() {
        double result = 0.0;
        for (Transaction t: transactionList ){
            result += t.getAmount();
        }
        return result;
    }

    public Transaction getTransactionsForDate(LocalDate date) {
        for (Transaction t: transactionList) {
            if(t.getDate()==date) return t;
        }
        return null;
    }

    public Transaction[] getTransactionsForPayee(Payee payee) {
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t: transactionList) {
            if(t.getPayee()==payee) list.add(t);
        }
        return list.toArray(new Transaction[0]);
    }

    public Transaction[] getAllDebit() {
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t: transactionList) {
            if(t.getType()==TransactionType.DEBIT) list.add(t);
        }
        return list.toArray(new Transaction[0]);
    }

    public Transaction[] getAllCredit() {
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t: transactionList) {
            if(t.getType()==TransactionType.CREDIT) list.add(t);
        }
        return list.toArray(new Transaction[0]);
    }
}
