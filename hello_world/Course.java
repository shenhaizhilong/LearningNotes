package hello_world;

/**
 * Created by shenhaizhilong on 4/30/2017.
 */
public enum  Course
{
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind)
    {
        values = kind.getEnumConstants();
    }
    public Food randomSelection()
    {
        return Enums.random(values);
    }
}
