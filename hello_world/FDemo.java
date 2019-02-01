package hello_world;

public class FDemo
{
    int x;
    public FDemo(int x)
    {
        this.x  = x;
    }
    //called when object is recycled
    protected void finalize()
    {
        System.out.println("Finalizing x: " + this.x);
    }

    // generate an object that is immediately destroyed
    public void generator(int i)
    {
        FDemo demo = new FDemo(i);
    }
    public static void main(String[] args) {
        FDemo fDemo = new FDemo(0);
        for (int i = 0; i < 10000000; i++) {
            fDemo.generator(i);
        }
    }
}
