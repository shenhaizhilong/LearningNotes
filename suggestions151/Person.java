package suggestions151;

import java.io.*;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 18:41
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -7503595524399779056L;
    private String name;
    private Salary salary;
    private int hash = 0;

    public Person(String name, Salary salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    //序列化委托方法
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
        out.writeDouble(this.salary.getBaseSalary());
    }

    // 反序列化委托方法
    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException
    {
        input.defaultReadObject();
        this.salary = new Salary(input.readDouble(), 0.0);

    }

    @Override
    public String toString() {
        return String.format("{name: %s, salary: %s}", this.name, this.salary);
    }

    @Override
    public int hashCode() {

        if(hash == 0)
        {
            hash = hash*31 + this.name.hashCode();
            hash = hash*31 + this.salary.hashCode();
        }
        return hash;
    }
}
