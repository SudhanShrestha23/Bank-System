package music.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    @SuppressWarnings("FieldMayBeFinal")
    public Account account;
    public Ui ui;

    public Methods(Account account, Ui ui) {
        this.account = account;
        this.ui = ui;
    }

    //Creating account details for users
    public void setAccountDetails(Scanner scanner) {  
        
        
        File fileDirectory = new File(System.getProperty("user.dir","resources"));
        File actualFile = new File(fileDirectory,"src/main/resources/details.csv");
        try {
                BufferedWriter br = new BufferedWriter(new FileWriter(actualFile));
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

    public boolean validateDetails(String email, String password) {
        boolean correct = false;
        if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
            System.out.println("Login successful");  
            correct = true;
        } 
        return correct;
    }

    public boolean checkAccount() {
        boolean exists = true;
        if (account.isEmpty()) {
            exists = false;
        }
        return exists;
    }

    public void printAccountDetails() {
        System.out.printf("Balance: $%.2f",account.getBalance());
        System.out.println();
    }

    public List<Account> loadDetails()  {
        List<Account> accounts = new ArrayList<>();
        
        File fileDirectory = new File(System.getProperty("user.dir", "resources"));
        File actualFile = new File(fileDirectory, "src/main/resources/details.csv");
        try {
            FileReader reader = new FileReader(actualFile);
            try (BufferedReader br = new BufferedReader(reader)) {
                String line;
                while((line = br.readLine()) != null) {
                    String[] values;
                    System.out.println(br.readLine());
                    values = line.split(",");
                    String email = values[0];
                    String password = values[1];
                    float balance = Float.parseFloat(values[2]);
                    accounts.add(new Account(email, password, balance));
                }
            }
            System.out.println("File succesfully read");
        } catch (IOException e) {

        }
        accounts.add(new Account());
        return accounts;
    }

    public void splashScreenChoices(Scanner scanner) {
          //After login
          int choice;  
          do { 
                ui.printMainPage();
                choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.println("Enter the amount you would like to deposit");
                        float deposit = scanner.nextFloat();
                        scanner.nextLine();
                        account.depost(deposit);
                        break;
                    case 2:
                        System.out.println("Enter the amount you would like to withdraw");
                        float withdraw = scanner.nextFloat();
                        scanner.nextLine();
                        account.withdraw(withdraw);
                        break;
                    case 3:
                        printAccountDetails();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid input detected");
                }
            } while (choice != 5);
            
            System.out.println();
    }
}
