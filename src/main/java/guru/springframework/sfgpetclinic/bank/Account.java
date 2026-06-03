package guru.springframework.sfgpetclinic.bank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private int balance = 0;

    private final List<Transaction> transactions =
            new ArrayList<>();

    public record Transaction(
            LocalDate date,
            int amount,
            int balance
    ) {
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if(balance < amount) {
            throw new IllegalArgumentException("Insufficient Balance");
        }

        balance -= amount;
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder("DATE | AMOUNT | BALANCE\n");
        for(Transaction transaction : transactions) {
            statement.append(transaction.date.toString())
                    .append(" | ")
                    .append(transaction.amount).append(" | ")
                    .append(transaction.balance).append("\n");
        }

        return statement.toString();
    }
}
