package DesignPattern.Proxy;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 18:18
 */
public class User {
    private final String name;
    private final int age;
    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }
}
