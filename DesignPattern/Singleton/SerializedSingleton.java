package DesignPattern.Singleton;

import java.io.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/25 1:35
 */
public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = 3973835013585169467L;
    private SerializedSingleton(){}
    private static class SingletonHelper
    {
        private static final SerializedSingleton singleton = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance()
    {
        return SingletonHelper.singleton;
    }

    protected Object readResolve()
    {
        return getInstance();
    }

    public static void main(String[] args) throws FileNotFoundException,IOException,ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.txt"));
        out.writeObject(instanceOne);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.txt"));
        SerializedSingleton instanceTwo = (SerializedSingleton)in.readObject();
        in.close();
        System.out.println("one " + instanceOne.hashCode());
        System.out.println("two " + instanceTwo.hashCode());
        // my results, So it destroys the singleton pattern, to overcome this scenario all
        // we need to do it provide the implementation of readResolve() method.
        // one 621009875
        // two 381259350

        // after we provide the readResolve method, hashcode is the same one
        // one 621009875
        // two 621009875
    }
}
