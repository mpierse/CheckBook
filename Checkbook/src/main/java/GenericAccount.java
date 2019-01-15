
public class GenericAccount <T extends AccountBook>{

    AccountBook accountBook;

    public GenericAccount(AccountBook accountBook) {
        this.accountBook = accountBook;
    }
}
