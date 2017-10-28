import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee empl = new Employee();
        Employee newEmpl = new Employee();
        scan.useDelimiter(";");
        empl.setName(scan.next());
        empl.setPosition(scan.next());
        empl.setSalary(scan.nextDouble());
        try {
            empl.setSurcharge(scan.nextDouble());
        } catch (SurchargeException e) {
            e.printStackTrace();
        }
        System.out.println(empl);
        File f = new File("Text.txt");
        ObjectOutputStream fo = null;


        try {
            fo = new ObjectOutputStream(new FileOutputStream(f));
            fo.writeObject(empl);

        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        } finally {
            try {
                if (fo != null) {
                    fo.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectInputStream fi = null;
        try {
            fi = new ObjectInputStream(new FileInputStream(f));
            newEmpl = (Employee) fi.readObject();

        } catch (ClassNotFoundException e) {
            System.err.println("Cannot read the class");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find the file");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi != null) {
                    fi.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        System.out.println(newEmpl);
    }
}