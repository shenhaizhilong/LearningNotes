package Annotation;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/23 13:05
 */
public class Apple {
    @FruitName("Apple")
    private String Name;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String color;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String provider;

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return Name;
    }

    public String getProvider() {
        return provider;
    }

    public void displayName()
    {
        System.out.println("Apple");
    }
}
