package suggestions151;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 18:56
 */
public class Serialize {
    public static void main(String[] args) {

        Salary salary = new Salary(3000, 2500);
        System.out.println(salary.hashCode());
        Person person = new Person("Tom", salary);
        System.out.println(person);
        serialize(person);
        deserialize();






    }

    public static void serialize(Person person)
    {
        try
        {
            SerializationUtils.writeObject(person, "d:\\a.txt");
        }catch (FileNotFoundException ex1)
        {
            ex1.printStackTrace();
        }catch (IOException ex2)
        {
            ex2.printStackTrace();
        }

        System.out.println("Serialize done");
    }

    public static void deserialize()
    {
        try {
            Person person = (Person) SerializationUtils.readObject("d:\\a.txt");
            System.out.println(person);
        }catch (FileNotFoundException ex1)
        {
            System.out.println(ex1.getMessage());
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
}
