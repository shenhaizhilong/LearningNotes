package JavaIO;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Pattern:");
        String patternString = in.nextLine();
        Pattern pattern = Pattern.compile(patternString);
        while (true)
        {
            System.out.println("Enter string to Match:");
            String input = in.nextLine();
            if(input == null || input.equals("")) return;
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches())
            {
                System.out.println("Match:");
                int g = matcher.groupCount();
                if(g>0)
                {
                    for (int i = 0; i < input.length(); i++) {

                        //Print any empty groups
                        for (int j = 1; j <= g; j++) {
                            if(i == matcher.start(j) && i == matcher.end(j))
                                System.out.println("()");
                        }

                        //Print ( non-empty groups starting here

                        for (int j = 1; j <=g; j++) {
                            if(i==matcher.start(j) && i != matcher.end(j))
                                System.out.println('(');
                        }

                        System.out.println(input.charAt(i));

                        //Print ) non-empty groups ending here
                        for (int j = 1; j <=g; j++) {
                            if( i+1 !=matcher.start(j) && i+1 ==matcher.end(j))
                                System.out.println(')');
                        }
                        System.out.println();

                    }
                }
            }else {
                System.out.println("No match");
            }
        }
    }
}
