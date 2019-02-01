package JavaIO;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1942921703396791765L;
    private int ID;
    private String name;
    private double salary;
    private GregorianCalendar birth;

    public Employee(int ID, String name, double salary, int year, int month, int day)
    {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.birth = new GregorianCalendar(year, month, day);
    }

    public int getID()
    {
        return ID;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double increase)
    {
        this.salary += increase;
    }

    public GregorianCalendar getBirth() {
        return birth;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirth(GregorianCalendar birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {

        return ID +"-" + this.name;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
