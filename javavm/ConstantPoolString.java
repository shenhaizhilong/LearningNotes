package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 12:45
 */
public class ConstantPoolString {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("op").append("String").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder().append("计算机").append("应用").toString();
        System.out.println(str2.intern() == str2);
       // String str3 = "java";
        String str4 = new StringBuilder("mmopppppppppppp").toString();
        System.out.println(str4.intern() == str4);

        String str5 = new StringBuilder().append("fjalfja").toString();
        System.out.println(str5.intern() == str5);

    }
}
