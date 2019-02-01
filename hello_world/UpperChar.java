package hello_world;


public class UpperChar {
    static final int mask = 65503;

    public static char Upper(char c)
    {
        //turn off the 6th bit
        return (char)((int)c& mask);
    }
    public static char Lower(char c)
    {
        // turn on the 6th bit
        return (char)((int) c| 0x20);
    }

    public static void main(String[] args) {
        char a = 'a';
        for (int i=0;i < 26; i++)
        {
            char U = Upper((char) ('a'+i));
            System.out.print(U);
            System.out.print(Lower(U));
            System.out.println('a'+i);

        }
        System.out.println(Upper('A'));


    }


}
