package Annotation;

import java.lang.reflect.Field;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/23 13:10
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz)
    {
        String name = "水果名称：";
        String color = "水果颜色: ";
        String provider = "供应商信息: ";
        Field[] fields = clazz.getDeclaredFields();

        for(Field field:fields)
        {
            if(field.isAnnotationPresent(FruitName.class))
            {
                System.out.println(name);
                FruitName fruitName = (FruitName)field.getAnnotation(FruitName.class);
                name += fruitName.value();
                System.out.println(name);
            }else if(field.isAnnotationPresent(FruitColor.class))
            {
                System.out.println(color);
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                color += fruitColor.fruitColor().toString();
                System.out.println(color);
            }else if(field.isAnnotationPresent(FruitProvider.class))
            {
                System.out.println(provider);
                FruitProvider fruitProvider = (FruitProvider)field.getAnnotation(FruitProvider.class);
                provider += "Id: " + fruitProvider.id() + ", Name: " + fruitProvider.name() + ", Address: " + fruitProvider.address();

                System.out.println(provider);
            }
        }


    }

    public static void main(String[] args) {

        System.out.println("你好");
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
