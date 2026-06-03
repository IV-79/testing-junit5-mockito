package guru.springframework.sfgpetclinic.bank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {
    @Test
    void shouldDepositMoney() {
        Account account = new Account();

        account.deposit(100);

        assertEquals(100, account.getBalance());
    }

    @Test
    void shouldAccumulateDeposits() {
        Account account = new Account();

        account.deposit(100);
        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    void shouldWithdrawMoney() {
        Account account = new Account();

        account.deposit(100);

        account.withdraw(40);

        assertEquals(60, account.getBalance());
    }

    @Test
    void shouldNotAllowWithdrawalAboveBalance() {
        Account account = new Account();

        account.deposit(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(150)
        );
    }

    @Test
    void shouldStoreTransactions() {

        Account account = new Account();

        account.deposit(100);
        account.withdraw(40);

        List<Account.Transaction> transactions =
                account.getTransactions();

        assertEquals(2, transactions.size());

        assertEquals(100,
                transactions.get(0).amount());

        assertEquals(100,
                transactions.get(0).balance());

        assertEquals(-40,
                transactions.get(1).amount());

        assertEquals(60,
                transactions.get(1).balance());
    }

    @Test
    void shouldPrintStatement() {

        Account account = new Account();

        account.deposit(100);
        account.withdraw(40);

        String statement = account.printStatement();

        assertNotNull(statement);

        assertTrue(statement.contains("100"));
        assertTrue(statement.contains("-40"));
        assertTrue(statement.contains("60"));
    }

    @Test
    void shouldCalculateTotalDeposits() {

        Account account = new Account();

        account.deposit(100);
        account.deposit(50);
        account.withdraw(20);

        assertEquals(150, account.totalDeposits());
    }

    @Test
    void shouldCalculateTotalWithdrawals() {

        Account account = new Account();

        account.deposit(100);
        account.withdraw(20);
        account.withdraw(30);

        assertEquals(50, account.totalWithdrawals());
    }
}
