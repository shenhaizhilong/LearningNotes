package JavaIO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String str = "cabdddd01223";
        String s = "([a-z]*+)([\\d]+)";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches())
        {
            if(matcher.groupCount()>=2)
            {
                System.out.println("group 0: " + matcher.group(0) +",group 1:" + matcher.group(1) +",group 2:" + matcher.group(2));
            }

        }

        str = "abcdefg0001234";
        s = "([a-z0-3])";
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(str);
        while (matcher.find())
        {
            int start = matcher.start();
            int end = matcher.end();
            String match = str.substring(start, end);
            System.out.println(match+",");
        }

        s = "[0-9]";
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(str);
        String out = matcher.replaceAll("#");
        System.out.println(out);


        s = "([a-z]*+)([\\d]+)";
        str = "abcd90";
        pattern = Pattern.compile(s);
        matcher = pattern.matcher(str);
        out = matcher.replaceAll("$2 9#");
        System.out.println(out);

        out = matcher.replaceAll("$1 9#");
        System.out.println(out);


        out = matcher.replaceAll("$0 9#");
        System.out.println(out);
    }
}
