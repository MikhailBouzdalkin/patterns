import java.io.*;
import java.util.Scanner;

/**
 * Created by PC on 21.09.2017.
 */
public class Employee implements Serializable {
    private String name;
    private String position;
    private double salary;
    private double surcharge;
    private final static double BASIC_SURCHAGE = 20;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", surcharge=" + surcharge +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSurcharge()  {

        return surcharge;
    }

    public void setSurcharge(double surcharge) throws SurchargeException {
        if (surcharge<0){
            throw new SurchargeException("Negative coefficient");
        }

        this.surcharge = BASIC_SURCHAGE * surcharge;
    }


}