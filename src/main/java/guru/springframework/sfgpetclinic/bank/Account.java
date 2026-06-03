package guru.springframework.sfgpetclinic.bank;

public class Account {
    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if(balance < amount) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        balance -= amount;
    }
}
