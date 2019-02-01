package hello_world;

/**
 * Created by shenhaizhilong on 4/17/2017.
 */
import java.util.*;
 class Product
{
    private final int id;
    private String description;
    private double price;
    public Product(int IDnumber, String descr, double price)
    {
        this.id = IDnumber;
        this.description = descr;
        this.price = price;
    }
    public String toString()
    {
        return id + ":" + description + ", price:$" + price;
    }
    public void   priceChange(double change)
    {
        price +=change;
    }
    public static IGenerator<Product> generator = new IGenerator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next()
        {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble()*1000.0) +0.99);
        }
    };
}

class Shelf extends ArrayList<Product>
{
    public Shelf(int nProducts)
    {
        Generators.fill(this, Product.generator, nProducts);
    }
}
class Aisle extends ArrayList<Shelf>
{
    public Aisle(int nShelves, int nProducts)
    {
        for(int i=0; i< nShelves; i++)
        {
            add(new Shelf(nProducts));
        }
    }
}
class CheckoutStand{}
class Office{}
public class Store extends ArrayList<Aisle>
{
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private  Office office = new Office();
    public Store(int nAisle, int nShelves, int nProducts)
    {
        for (int i=0; i < nAisle; i++)
        {
            add(new Aisle(nShelves, nProducts));
        }
    }
   public String toString()
   {
       StringBuilder results = new StringBuilder();
       for(Aisle aisle: this)
       {
           for(Shelf s: aisle)
           {
               for(Product p: s)
               {
                   results.append(p);
                   results.append("\n");
               }
           }
       }
       return results.toString();
   }
    public static void main(String[] args)
    {
        System.out.println(new Store(14, 5, 10));
    }
}

