package JavaIO;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class SerialCloneTest {
    public static void main(String[] args) {

        NewEmployee tom = new NewEmployee("Tom Hacker", 34000, 1989, 10,1);
        NewEmployee tom2 = (NewEmployee) tom.clone();


        tom.raiseSalary(10);
        if(tom2 !=null)
        {
            System.out.println(tom2);
        }

        System.out.println(tom);

    }
}

class SerialCloneable implements Cloneable, Serializable
{
    private static final long serialVersionUID = 8762289310337606049L;

    @Override
    public Object clone()
    {
        try{
            //save the object to a byte array
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            ObjectOutputStream oOut = new ObjectOutputStream(bOut);
            oOut.writeObject(this);
            oOut.close();

            //read a clone of the object from the byte array
            ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
            bOut.close();
            ObjectInputStream  objectInputStream = new ObjectInputStream(bIn);
            Object ret = objectInputStream.readObject();
            objectInputStream.close();
            bIn.close();
            return ret;



        }catch (IOException e)
        {
            System.out.println(e.getMessage());
            return null;
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

/**
 the Employee class, redefine to extend the SerialClone class.
 **/

class NewEmployee extends SerialCloneable
{
    private String name;
    private double salary;
    private Date hireDay;

    public NewEmployee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month -1 , day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public double getSalary() {
        return salary;
    }

    public void  raiseSalary(double byPercent)
    {
        double raise = salary*byPercent/100;
        salary += raise;
    }

    @Override
    public String toString() {
            return getClass().getName() + "{name=" + name +",salary=" + salary + ",hireDay=" + hireDay+"]";
    }
}