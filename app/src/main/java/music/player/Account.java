package music.player;

import java.util.List;

public class Account {
    private String email;
    private String password;

    private float balance;
    private List<Statement> statement;
    public Account() {
        email = "";
        password = "";
        balance = 0;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void depost(float deposit) {
        balance = balance + deposit;
    }

    public void withdraw(float withdrawal) {
        balance = balance - withdrawal;
    }

    public float getBalance() {
        return balance;
    }

    public boolean isEmpty() {
        boolean empty = false;
        if (email.isEmpty()) {
            empty = true;
        }
        return empty;
    }
    public String getPassword() {
        return password;
    }

    public String toCsv() {
        return email + "," + password + "," + balance;
    }
    
}
