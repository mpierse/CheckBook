import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class CheckbookTest {

    Checkbook checkbook;
    Checkbook checkbook2;
    ArrayList<Transaction> list;
    Transaction transaction = new Transaction("",new Payee(), TransactionType.DEBIT,1.50);
    Transaction transaction2 =new Transaction("test", new Payee(), TransactionType.CREDIT, 50.50);
    Checkbook checkbookOneParam = new Checkbook(3.00);
    Checkbook checkbookTwoParam = new Checkbook(new Payee(), 5.00);

    @org.junit.Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(transaction);
        list.add(transaction2);
        checkbook = new Checkbook(list);
        checkbook2 = new Checkbook();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void add1Test(){
    Transaction toAdd = new Transaction("addThis", new Payee(), TransactionType.DEBIT, 40.5);
    checkbook.add(toAdd);
    Assert.assertEquals(3,checkbook.size());
    }

    @Test
    public void add2Test(){
        Transaction toAdd = new Transaction("addThis", new Payee(), TransactionType.DEBIT, 40.5);
        checkbook.add(toAdd);
        Assert.assertTrue(checkbook.contains(toAdd));
    }

    @Test
    public void add3Test(){
        Transaction toAdd = new Transaction("addThis", new Payee(), TransactionType.DEBIT, 40.5);
        checkbook2.add(toAdd);
        Assert.assertFalse(checkbook2.isEmpty());
    }

    @Test
    public void emptytest(){
        Assert.assertTrue(checkbook2.isEmpty());
    }

    @Test
    public void remove1Test(){
        checkbook.remove(transaction);
        Assert.assertEquals(1,checkbook.size());
    }

    @Test
    public void remove2Test(){
        checkbook.remove(transaction);
        Assert.assertFalse(checkbook.contains(transaction));
    }

    @Test
    public void remove3Test(){
        checkbook2.add(new Transaction("", new Payee(), TransactionType.DEBIT,2.00));
        checkbook2.remove(transaction);
        Assert.assertFalse(checkbook2.contains(transaction));
    }

    @Test
    public void iterator1Test(){
        Iterator actual = checkbook.iterator();
        Assert.assertEquals(list.iterator().getClass(), actual.getClass());
    }

    @Test
    public void iterator2test(){
        Iterator actual = checkbook.iterator();
        Assert.assertTrue(actual.hasNext());
    }

    @Test
    public void iterator3test(){
        Iterator actual = checkbook.iterator();
        Assert.assertEquals(transaction,actual.next());
    }

    @Test
    public void toArray1test(){
        Transaction[] actual = checkbook.toArray();
        Assert.assertEquals(Transaction[].class, actual.getClass());
    }

    @Test
    public void toArray2test(){
        Transaction[] actual = checkbook2.toArray();
        Assert.assertEquals(Transaction[].class, actual.getClass());
    }

    @Test
    public void toArray3test(){
        Assert.assertNotSame(Transaction[].class, checkbook2.getClass());
    }

    @Test
    public void toArrayparam1test(){
        Transaction[] arr = new Transaction[0];
        Transaction[] actual = checkbook.toArray(arr);
        Assert.assertEquals(Transaction[].class, actual.getClass());
    }

    @Test
    public void toArrayparam2test(){
        Transaction[] arr = new Transaction[]{new Transaction("", new Payee(),TransactionType.DEBIT,3.00)};
        Transaction[] actual = checkbook.toArray(arr);
        Assert.assertEquals(3, actual.length);
    }

    @Test
    public void checkbookValue(){
       double actual = checkbook.checkbookValue();
    Assert.assertEquals(-49.0, actual);
    }

    @Test
    public void getTransactionsForDateTest(){
        Assert.assertEquals(checkbook.getTransactionsForDate(transaction.getDate()),transaction);
    }

    @Test
    public void getTransactionForPayeeTest(){
        Transaction [] arr = new Transaction[]{transaction};
        Assert.assertEquals(arr, checkbook.getTransactionsForPayee(transaction.getPayee()));
    }

    @Test
    public void getAllDebitTest(){
        Transaction [] arr = new Transaction[]{transaction};
        Assert.assertEquals(arr, checkbook.getAllDebit());
    }

    @Test
    public void getAllCreditTest(){
        Transaction [] arr = new Transaction[]{transaction2};
        Assert.assertEquals(arr, checkbook.getAllCredit());
    }

    @Test
    public void constructorOneParam(){
        Assert.assertEquals(1, checkbookOneParam.size());
    }

    @Test
    public void constructorTwoParam(){
        Assert.assertEquals(1, checkbookTwoParam.size());
    }
}