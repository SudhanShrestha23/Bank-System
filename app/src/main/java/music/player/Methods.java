package music.player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Methods {

    public void setAccountDetails(Scanner sc) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("password.csv"));
        System.out.println("Enter your email address");

        System.out.println("Enter a valid password");


    }



}
