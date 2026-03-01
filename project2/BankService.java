import java.util.ArrayList;

class BankService {

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account Created Successfully!");
    }

    public BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public void depositMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public void withdrawMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public void transferMoney(int fromAcc, int toAcc, double amount) {
        BankAccount sender = findAccount(fromAcc);
        BankAccount receiver = findAccount(toAcc);

        if (sender != null && receiver != null) {
            sender.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer Completed!");
        } else {
            System.out.println("One or Both Accounts Not Found!");
        }
    }

    public void displayAllAccounts() {
        for (BankAccount acc : accounts) {
            acc.displayDetails();
        }
    }
}
