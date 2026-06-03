package guru.springframework.sfgpetclinic.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
