class CurrentAccount extends BankAccount {

    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
