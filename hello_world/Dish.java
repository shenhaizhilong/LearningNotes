package hello_world;

import java.lang.reflect.Type;

/**
 * Created by shenhaizhilong on 7/2/2017.
 */
public class Dish
{
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name,boolean vegetarian, int calories, Type type)
    {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }
    public boolean isVegetarian()
    {
        return vegetarian;
    }
    public int getCalories()
    {
        return calories;
    }
    public Type getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public enum Type{MEAT, FISH, OTHER }
}
