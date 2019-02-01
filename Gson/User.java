package Gson;

import com.google.gson.annotations.SerializedName;

public class User {
    public String name;
    public int age;

    @SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    public String emailAddress;

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, String emailAddress)
    {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddresss(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, age, emailAddress);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj  == null)
            return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
