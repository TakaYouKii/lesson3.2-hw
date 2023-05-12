
public class BankAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double som) {
        amount += som;
    }

    public void withDraw(int sum) throws LimitedException {

        if (amount < sum) {
            throw new LimitedException("На вашем счету мало средств. Счет: " + amount, amount);
        }
        amount -= sum;
    }

    public BankAccount(double amount) {
        this.amount = amount;
    }
}