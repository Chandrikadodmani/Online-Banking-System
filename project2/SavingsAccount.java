class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Cannot withdraw! Minimum balance ₹1000 must be maintained.");
        }
    }
}
