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
        try(ObjectOutputStream fo = new ObjectOutputStream(new FileOutputStream(f))) {
            fo.writeObject(empl);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream fi = new ObjectInputStream(new FileInputStream(f))) {
            newEmpl = (Employee) fi.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(newEmpl);
    }
}