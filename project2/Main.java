import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        int choice;

        while (true) {
            System.out.println("\n===== Welcome to Web Plus Bank =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    System.out.println("Select Account Type:");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    int type = sc.nextInt();

                    if (type == 1) {
                        bankService.createAccount(new SavingsAccount(accNo, name, balance));
                    } else {
                        bankService.createAccount(new CurrentAccount(accNo, name, balance));
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int dAcc = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double dAmount = sc.nextDouble();
                    bankService.depositMoney(dAcc, dAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int wAcc = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double wAmount = sc.nextDouble();
                    bankService.withdrawMoney(wAcc, wAmount);
                    break;

                case 4:
                    System.out.print("From Account: ");
                    int from = sc.nextInt();
                    System.out.print("To Account: ");
                    int to = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    bankService.transferMoney(from, to, amt);
                    break;

                case 5:
                    bankService.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank You for Banking with Us!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
