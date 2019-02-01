package hello_world;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;
/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>
{
    static class ToDoItem implements Comparable<ToDoItem>
    {
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String item, char pri, int sec)
        {
            primary = pri;
            secondary = sec;
            this.item = item;
        }
        public int compareTo(ToDoItem toDoItem)
        {
            if(primary> toDoItem.primary)
            {
                return +1;
            }
            if (primary == toDoItem.primary)
            {
                if(secondary > toDoItem.secondary)
                    return +1;
                else if(secondary == toDoItem.secondary)
                    return 0;

            }
            return -1;
        }
        public String toString()
        {
            return Character.toString(primary) + secondary + ":" + item;
        }

    }
    public void add(String td, char pri, int sec)
    {
        super.add(new ToDoItem(td, pri, sec));
    }
    public static void main(String[] args)
    {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash", 'C', 4);
        toDoList.add("Feed dog", 'A', 2);
        toDoList.add("Feed bird", 'B', 7);
        toDoList.add("Mow lawn", 'C', 3);
        toDoList.add("Water lawn", 'A', 1);
        toDoList.add("Feed cat", 'B', 1);
        while (!toDoList.isEmpty())
        {
            System.out.println(toDoList.remove());
        }

    }
}
