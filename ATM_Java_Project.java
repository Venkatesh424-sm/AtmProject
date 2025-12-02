import java.util.*;

// Invalid login
class InvalidLoginException extends Exception {
    public InvalidLoginException(String msg) {
        super(msg);
    }
}

// Invalid amount
class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

// Bank Account Class
class BankAccount {
    private String accountId;
    private String password;
    private double balance;

    public BankAccount(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
        this.balance = 0;
    }

    public String getAccountId() {
        return accountId;
    }

    // Login validation
    public void validateLogin(String id, String pass) throws InvalidLoginException {
        if (!accountId.equals(id) || !password.equals(pass)) {
            throw new InvalidLoginException("Invalid Account ID or Password");
        }
    }

    // Deposit
    public void deposit(double amt) throws InvalidAmountException {
        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero!");
        }
        balance += amt;
        System.out.println("✅ Amount Deposited Successfully");
    }

    // Withdraw
    public void withdraw(double amt) throws InvalidAmountException {
        if (amt <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero!");
        }
        if (amt > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amt;
            System.out.println("✅ Withdrawal Successful");
        }
    }

    // Balance check
    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

// ATM System Class
public class ATMSystem {

    static HashMap<String, BankAccount> db = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Registration
    public static void register() {
        System.out.print("Enter Contact Number (Account ID): ");
        String id = sc.next();

        if (db.containsKey(id)) {
            System.out.println("⚠ Already Registered! Please Login.");
            return;
        }

        System.out.print("Create Password: ");
        String pass = sc.next();
        db.put(id, new BankAccount(id, pass));
        System.out.println("✅ Account Created Successfully!");
    }

    // Login
    public static void login() {
        try {
            System.out.print("Enter Account ID: ");
            String id = sc.next();

            if (!db.containsKey(id)) {
                System.out.println("❌ Account not found! Please Register.");
                return;
            }

            System.out.print("Enter Password: ");
            String pass = sc.next();
            BankAccount user = db.get(id);

            user.validateLogin(id, pass);
            System.out.println("✅ Login Successful!");
            atmMenu(user);

        } catch (InvalidLoginException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // ATM Menu
    public static void atmMenu(BankAccount user) {
        int ch;
        do {
            try {
                System.out.println("\n------ ATM MENU ------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit (Logout)");
                System.out.print("Choose Option: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        user.checkBalance();
                        break;

                    case 2:
                        System.out.print("Enter Amount: ");
                        user.deposit(sc.nextDouble());
                        break;

                    case 3:
                        System.out.print("Enter Amount: ");
                        user.withdraw(sc.nextDouble());
                        break;

                    case 4:
                        System.out.println("🔒 Logged Out Successfully.");
                        break;

                    default:
                        System.out.println("❌ Invalid Choice");
                }

            } catch (InvalidAmountException e) {
                System.out.println("❌ " + e.getMessage());
                ch = 0;  // continue menu
            }

        } while (ch != 4);
    }

    // Main Menu
    public static void main(String[] args) {

        int ch;
        do {
            System.out.println("\n====== WELCOME TO ATM ======");
            System.out.println("1. Register (New User)");
            System.out.println("2. Login");
            System.out.println("3. Exit System");
            System.out.print("Choose: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: register(); break;
                case 2: login(); break;
                case 3: System.out.println("🙏 Thank you! Visit again."); break;
                default: System.out.println("❌ Invalid Choice");
            }
        } while (ch != 3);

        sc.close();
    }
}
