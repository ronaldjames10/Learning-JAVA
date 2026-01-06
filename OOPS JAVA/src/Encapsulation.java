class BankAccount {

    // Private data
    private double balance;

    // Setter method
    public void setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
        }
    }

    // Getter method
    public double getBalance() {
        return balance;
    }
}

public class Encapsulation {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setBalance(5000);
        System.out.println("Balance: " + account.getBalance());
    }
}
