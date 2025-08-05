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

    public boolean isEmpty() {
        boolean empty = false;
        if (email.isEmpty()) {
            empty = true;
        }
        return empty;
    }
}
