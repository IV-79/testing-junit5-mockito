package guru.springframework.sfgpetclinic.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
