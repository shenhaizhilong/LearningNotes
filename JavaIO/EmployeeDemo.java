package JavaIO;

import java.io.*;
import java.util.Date;
import java.util.EnumMap;

public class EmployeeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        String filename = "objects.txt";
        System.out.println("Write all the objects to " + filename);
        Employee tom = new Employee(10091, "Tom", 12000.0, 1989, 12, 1);
        Employee tom2 = new Employee(10092, "Tom", 1200.0, 1989, 12, 1);
        System.out.println(tom);
        System.out.println(tom2);
        System.out.println(tom.hashCode());
        System.out.println(tom2.hashCode());

        Manager boss = new Manager(1000, "Jason", 20000.0, 1989, 12, 2);
        System.out.println(boss);
        System.out.println(boss.hashCode());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(tom);
        objectOutputStream.writeObject(tom2);
        objectOutputStream.writeObject(boss);
        objectOutputStream.close();


        System.out.println("read all the objects from the " + filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        Employee e1 = (Employee) objectInputStream.readObject();
        Employee e2 = (Employee) objectInputStream.readObject();
        Employee e3 = (Employee) objectInputStream.readObject();

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);


        Employee harry = new Employee(10095, "Harry Hacker",11000.0, 1990, 1, 10);

        Manager carl = new Manager(10001, "Carl Cracker",14000.0, 1985, 1, 1);
        Manager tony = new Manager(10000, "Tony Tester", 20000.0, 1984, 1,2);
        carl.setSecretary(harry);
        tony.setSecretary(harry);

        System.out.println("Before serializable");
        Employee[] staff = new Employee[3];
        staff[0] = harry;
        staff[1] = carl;
        staff[2] = tom;
        for (Employee e :
                staff) {
            System.out.println(e);
        }
        try(ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            objectOutputStream1.writeObject(staff);
        }

        System.out.println("read all the objects");
        try(ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(filename)))
        {
            Employee[] newStaff = (Employee[])objectInputStream1.readObject();
            newStaff[0].raiseSalary(10);
            System.out.println( newStaff[0].toString() + ", " + newStaff[0].getSalary());
            for (Employee e :
                    newStaff) {
                System.out.println( e.toString() + ", " + e.getSalary());
            }
           carl = (Manager)newStaff[1];
            System.out.println(carl.getSecretary().toString() + ", " + carl.getSecretary().getSalary());

        }

    }
}
