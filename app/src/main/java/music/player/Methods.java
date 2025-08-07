package music.player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Methods {
    private Account account;

    public Methods(Account account) {
        this.account = account;
    }

    //Creating account details for users
    public void setAccountDetails(Scanner scanner) {  
        try {
                BufferedWriter br = new BufferedWriter(new FileWriter("accountDetails.csv"));
                System.out.println("Enter your email address");
                System.out.println("test");
                String email = scanner.nextLine();
                System.out.println("Enter a valid password");
                String password = scanner.nextLine();
                account.setEmail(email);
                account.setPassword(password);
                br.write(account.toCsv());
                br.close();
        } catch (IOException e) {
            System.out.println("Unable to create account "+ e);
        }
    }

    public void validateDetails(String email, String password) {
        if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
            System.out.println("Login successful");  
        } 
    }

    public boolean checkAccount() {
        boolean exists = true;
        if (account.isEmpty()) {
            exists = false;
        }
        return exists;
    }
}
