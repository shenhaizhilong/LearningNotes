package hello_world;


class Outer
{
    private int[] numbers;
    Outer(int[] numbers)
    {
        this.numbers = numbers;
    }
    public void test()
    {
        System.out.println(numbers);
    }
    public void analyze()
    {
        Inner inner = new Inner();
        int min = inner.min();
        int max = inner.max();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
    class Inner
    {
        int min()
        {
            int results =numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                results = numbers[i]< results? numbers[i]:results;
            }
            return results;
        }
        int max()
        {
            int results = numbers[0];
            for (int i = 0; i < numbers.length; i++) {
                results = numbers[i] > results? numbers[i]:results;
            }
            return results;
        }

    }
}
public class NestedClassDemo
{
    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,69,0};
        Outer o = new Outer(n);
        o.analyze();
    }


}
