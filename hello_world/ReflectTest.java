package hello_world;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by shenhaizhilong on 7/3/2017.
 */
public class ReflectTest
{
    public static void main(String[] args)
    {
        Class c1 = String.class;
        Class c2 = int.class;
        System.out.println(c1.getSimpleName());
        System.out.println(c1.getName());

        printClassMethods(10);

        Apple apple = new Apple();
        printFields(apple);
        printConstructionInfo("apple");


        ABC abc = new ABC();
        Class c = abc.getClass();
        try{
            Method method = c.getMethod("add", int.class,int.class);
            //Method method = c.getMethod("add", new Class[]{int.class,int.class});
            method.invoke(abc,10,100);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    //打印类声明的字段
    public static void printFields(Object object)
    {
        Class c = object.getClass();
        System.out.println("****************************************");
        System.out.println("Class Name:" + c.getName());
        Field[] fields = c.getDeclaredFields();
        for(Field field:fields)
        {
            Class type = field.getType();
            System.out.println("Type:" + type.getName() + ",Field: "+ field.getName());

        }
    }
    //打印类的属性与方法（包括继承的）
    public static void printClassMethods(Object object)
    {
        Class c = object.getClass();
        System.out.println("Class Name:" + c.getName());
        Method[] methods = c.getMethods();
        for(Method method : methods)
        {
            System.out.println("Method Name:" + method.getName());
            Class returnType = method.getReturnType();
            System.out.println("Return Type:" + returnType.getName());
            Class[] parameterTypes = method.getParameterTypes();
            for(Class parameterType : parameterTypes)
            {
                System.out.println(parameterType.getName());
            }


        }
    }

    //打印类的构造器
    public static void printConstructionInfo(Object object)
    {
        System.out.println("****************************************");
        Class c = object.getClass();
        Constructor[] constructors = c.getConstructors();
        for(Constructor constructor: constructors)
        {
            System.out.println();
            System.out.print(constructor.getName() +"(");
            Class[] parametersTypes = constructor.getParameterTypes();
            for(Class parameterType : parametersTypes)
            {
                System.out.print(parameterType.getSimpleName() + ",");
            }
            System.out.print(")");

        }

    }



}

class ABC
{
    public void add(int a, int b)
    {
        System.out.println(a+b);
    }
    public void toUpper(String a)
    {
        System.out.println(a.toUpperCase());
    }
}
