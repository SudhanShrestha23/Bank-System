package music.player;

public class Ui {
    private Account acc;
    public Ui(Account acc) {
        this.acc = acc;
    }

    public void printLandingPage() {
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Exit");
    }
    public void printMainPage() {
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money?");
        System.out.println("3. Check your bank balance");
        System.out.println("4. Change password");
        System.out.println("5. Logout");
    }

    public static void showAccountDetails() {

    }

}

