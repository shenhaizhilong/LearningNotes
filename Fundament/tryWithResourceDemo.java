package Fundament;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class tryWithResourceDemo {

    public static void main(String[] args) throws IOException {
        Vector<String> vector = new Vector<>(10);
        ArrayList<String> list = new ArrayList<>(10);
        try(Scanner in = new Scanner(new FileInputStream("test10.txt"), "UTF-8"); PrintWriter out = new PrintWriter("out.txt"))
        {
            while (in.hasNext())
            {

                out.write(in.nextLine().toUpperCase() + "\n");
            }
        }
    }
}
