package DesignPattern.Prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 2147483647l;
    private String name;
    private SerializableObject obj;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    public SerializableObject getObj() {
        return obj;
    }


    public Object clone() throws CloneNotSupportedException
    {
        Prototype prototype = (Prototype)super.clone();
        return prototype;
    }

    public Object deepClone() throws  ClassNotFoundException,  IOException
    {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream  = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();

    }


    class SerializableObject implements Serializable
    {
        private static final long serialVersionUID = 2147483647;
    }
}
