package hello_world;

/**
 * Created by shenhaizhilong on 4/30/2017.
 */
public interface Food
{
    enum Appetizer implements Food{
        SALAD,SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINDALOD;
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_ROREST_CAKE,
        FRUID,CREME_CARAMEL;
    }
    enum Coffee implements Food{
        BLACK_COFFEE, DECAF_COFFEE,ESPRESSD,LATTE,CAPPUCCINO,TEA,MERB_TEA;
    }
}
