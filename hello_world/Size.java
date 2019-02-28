package hello_world;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/22 15:27
 */
public enum  Size {
    SMALL("S"),MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;
    private Size(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation(){return abbreviation;}


    public static void main(String[] args) {
        System.out.println("你好");
        System.out.println(Size.EXTRA_LARGE.getAbbreviation());
    }
}
