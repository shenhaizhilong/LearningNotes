package hello_world;

import java.util.function.DoubleFunction;

/**
 * Created by shenhaizhilong on 7/2/2017.
 */
public class Integrate
{
    public double integrate(DoubleFunction<Double> f, double a, double b)
    {
        return (f.apply(a) + f.apply(b))*(b-a)/2.0;
    }

    public static void main(String[] args)
    {
        DoubleFunction<Double> f = (x)->x+10;
        Double d = f.apply(10);
        System.out.println(d);
        Integrate integrate = new Integrate();
        Double res = integrate.integrate(f,3,7);
        System.out.println(res);
    }
}
