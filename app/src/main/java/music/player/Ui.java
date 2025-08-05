package music.player;

public class Ui {
    private Account acc;
    public Ui(Account acc) {
        this.acc = acc;
    }
    public static void printChoices() {
        System.out.println("What would you like to do?");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money?");
        System.out.println("3. Check your bank balance");
    }

    public static void showAccountDetails() {

    }

}

