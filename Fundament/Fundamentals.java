package Fundament;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class Fundamentals {
    public static void main(String[] args) {
        String a = "a哈哈我爱你";
        System.out.println(a.length());
        int cpCount = a.codePointCount(0, a.length());
        System.out.println(cpCount);
        System.out.println(a.charAt(0));
        int[] codePoints = a.codePoints().toArray();
        for (int i = 0; i < codePoints.length; i++) {
            System.out.println(codePoints[i] + " " + (char)codePoints[i]);
        }
       // System.out.println(codePoints[0]);
        String str = new String(codePoints,0, codePoints.length);
        System.out.println(str);
        System.out.println("\uffff");
        System.out.println("\u0000");
        int aa=0xd835;
        int bb=0xdd46;
        System.out.println((aa+bb));
        System.out.println(0x1D546);

        System.out.println("\ud835\udd46");

        String c="\uD835\uDD46";
        System.out.println(c.length());
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
        LocalDate date1 = date.plusDays(1000);
        System.out.println(date1.getYear());
        System.out.println(date1.getMonthValue());
        System.out.println(date1.getDayOfMonth());


    }
}
