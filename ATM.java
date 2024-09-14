import java.util.Scanner;
public class ATM {
    private double balance;
    private final String username;
    private final String password;
    public ATM(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.print("Set your Username: ");
        String username = scanner.nextLine();
        String password;
        do {
            System.out.print("Set a 4-digit Password: ");
            password = scanner.nextLine();
            if (!password.matches("\\d{4}")) {
                System.out.println("Invalid password. Password must be exactly 4 digits.");
            }
        } while (!password.matches("\\d{4}"));
        ATM myATM = new ATM(username, password, 500.0);
        System.out.println("\nATM Login");
        System.out.print("Enter Username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter 4-digit Password: ");
        String enteredPassword = scanner.nextLine();
        if (enteredUsername.equals(myATM.username) && enteredPassword.equals(myATM.password)) {
            System.out.println("Login Successful!");
            int option;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        myATM.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        myATM.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        myATM.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 4);

        } else {
            System.out.println("Login Failed. Incorrect username or password.");
        }

        scanner.close();
    }
}
