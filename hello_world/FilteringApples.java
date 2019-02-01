package hello_world;

/**
 * Created by shenhaizhilong on 5/3/2017.
 */
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FilteringApples{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                "brown".equals(a.getColor()));
        System.out.println(weirdApples);
        //Stream 顺序处理

        List<Apple> heavyApples3 = inventory.stream().filter((Apple a) ->a.getWeight()>150).collect(Collectors.toList());
        System.out.println("Steam in order");
        System.out.println(heavyApples3);
        List<Apple> heavyApples4 = inventory.parallelStream().filter((Apple a)->a.getWeight()>150).collect(Collectors.toList());
        System.out.println("Parallel Steam ");
        System.out.println(heavyApples4);

        List<Apple> redApples = filterApples2(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple)
            {
                return "red".equals((apple.getColor()));
            }
        });

        System.out.println("匿名类");
        System.out.println(redApples);

        List<Apple> redApples2 = filter(inventory, (Apple apple)-> apple.getColor().equals("red"));
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        List<Integer> evenNumbers = filter(numbers, (Integer i)->i%2==0);

        List<String> str = Arrays.asList("a","b","c","d","A","B");
        str.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        System.out.println(str);
        str.sort((s1,s2)->s1.compareTo(s2));
        System.out.println(str );
        str = Arrays.asList("a","b","c","d","A","B");
        str.sort(String::compareToIgnoreCase);

        Function<String,Integer> stringToInteger = Integer::parseInt;
        int b = stringToInteger.apply("10");
        System.out.println(b);




    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }



    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }

        }
        return result;
    }
    public static List<Apple> filterApples2(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }

        }
        return result;
    }
    public static <T> List<T> filter(List<T> list, hello_world.Predicate<T> predicate)
    {
        List<T> results = new ArrayList<>();
        for (T e: list)
        {
            if(predicate.test(e)){
                results.add(e);
            }
        }
        return results;
    }


}
