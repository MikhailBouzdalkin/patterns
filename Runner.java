import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runner {
    public static void main(String args[]) {


        File f = new File("D:\\Text.txt");
        ArrayList<User> arr = new ArrayList<User>();

        arr.add(new User("A", "login", "123", "male", "05.05.2010"));
        arr.add(new User("B", "login", "123", "male", "05.05.2010"));
        arr.add(new User("C", "login", "123", "male", "05.05.2010"));

        User.writeToFIle(f, arr);
        ArrayList<User> arr1 = new ArrayList<User>();

        User.readFromFIle(f, arr1);

        Collections.sort(arr1);
        System.out.println(arr1);

    }

}