package ali;

import java.io.*;
import java.util.Scanner;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/21 00:00
 */
public class CalcRT {

    public void handleLog(String inputLog, String outputLog) throws IOException
    {
        try(PrintWriter writer = new PrintWriter(outputLog, "UTF-8"))
        {
            writer.write(String.format("%-22s %-40s %-5s  %-6s\n", "Time", "Url", "Qps", "RT"));

            String preDateTime = "";
            String preUrl = "";
            int currCount = 0;
            int sumTime = 0;
            String line = "";
            String[] items =  {};

            try(Scanner scanner = new Scanner(new File(inputLog), "UTF-8"))
            {
                while (scanner.hasNextLine())
                {
                    line = scanner.nextLine();
                    line = line.trim();
                    items = line.split(" ");

                    // if items.length != 5, then skip this line
                    if(items.length == 5)
                    {
                        String currDateTime  = items[0] + " " + items[1];
                        String currUrl = items[2];
                        if(currDateTime.equals(preDateTime) && currUrl.equals(preUrl))
                        {
                            currCount++;
                            if(!items[4].matches("[0-9]+ms"))continue;
                            sumTime += Integer.parseInt(items[4].replace("ms",""));
                        }else {
                            if(!currDateTime.equals(preDateTime) && currCount != 0)
                            {
                                String outputLine = String.format("%-22s %-40s %-5s  %-6s\n", preDateTime, preUrl, currCount, sumTime/currCount);
                                writer.write(outputLine);
                            }
                            currCount = 1;
                            if(!items[4].matches("[0-9]+ms"))continue;
                            sumTime = Integer.parseInt(items[4].replace("ms",""));
                        }

                        // update pre line datetime and url
                        preDateTime = currDateTime;
                        preUrl = currUrl;


                    }
                }
            }

            // handle last line
            if(!preDateTime.isEmpty() && currCount != 0)
            {
                String outputLine = String.format("%-22s %-40s %-5s  %-6s\n", preDateTime, preUrl, currCount, sumTime/currCount);
                writer.write(outputLine);
            }

        }

    }

   

}
