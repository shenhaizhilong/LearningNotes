package hello_world;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


/**
 * Created by shenhaizhilong on 7/2/2017.
 */
public class DishTest
{
    public static void main(String[] args)
    {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT ),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french friends", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<String> threeHighCaloricDishName = menu.stream().filter(d->d.getCalories()>300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishName);

        //just like iterator 只会遍历一次
        List<String> list = Arrays.asList("Java","C","C++", "c#","Python","Ruby","Matlab");
        Stream<String> s = list.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::print);

        //Iterator
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext())
        {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
        System.out.println(names);

        List<String> names2 = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(names2);
        menu.stream().forEach(System.out::println);

        long count = menu.stream().filter(d->d.getCalories()>300).distinct().count();
        System.out.println(count);
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianMenu);

        //distinct
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,3,5,7,9);
        numbers.stream().filter(i->i%2==1).distinct().forEach(System.out::println);
        //截断流
        List<Dish> dishes = menu.stream().filter(d->d.getCalories()>300).limit(3).collect(Collectors.toList());
        System.out.println(dishes);
        List<Dish> dishes1 = menu.stream().filter(d->d.getCalories()>400).skip(2).limit(3).collect(Collectors.toList());
        System.out.println(dishes1);

        List<Dish> meatDishes = menu.stream().filter(d->d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
        System.out.println(meatDishes);

        List<Integer> dishNamelengths = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(dishNamelengths);

        List<String> words = Arrays.asList("Hello,","World");
        List<String[]> d = words.stream().map(w->w.split("")).distinct().collect(Collectors.toList());
        for (String[] ss:d) {
            for(String a:ss)
            {
                System.out.print(a);
            }

        }

        System.out.println("FlatMap");
        List<String> c = words.stream().map(w->w.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(c);

        //square
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = nums.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(squares);

        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);
        List<int[]> number3 = number1.stream().flatMap(i->number2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());
        number3.stream().forEach( i-> System.out.println("(" +i[0]+"," +i[1]+")"));

        System.out.println("*****************************");
        List<int[]> number4 = number1.stream().flatMap(i->number2.stream().filter(j->j%3==0).map(j->new int[]{i,j})).collect(Collectors.toList());
        number4.stream().forEach(i-> System.out.println("(" +i[0]+"," +i[1]+")"));

        //Stream<Integer> to IntStream
        int calories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calories);
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        OptionalInt minCalories = menu.stream().mapToInt(Dish::getCalories).min();
        OptionalDouble averCalories =menu.stream().mapToInt(Dish::getCalories).average();
        System.out.println("Max:" + maxCalories + " Min:" + minCalories + " Aver:" + averCalories);
        System.out.println("Max:" + maxCalories.getAsInt() + " Min:" + minCalories.getAsInt() + " Aver:" + averCalories.getAsDouble());

        //IntStream to Stream<Integer>
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();// 通过装箱将数值流转为stream

        //
        IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(i->(i&1)==1);
        System.out.println(evenNumbers.count());

        Stream<int[]> pythagoreanTribles = IntStream.rangeClosed(1,100).boxed().flatMap(a->IntStream.rangeClosed(a,100).filter(b->Math.sqrt(a*a+b*b)%1==0).mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)}));

        pythagoreanTribles.limit(50).forEach(t-> System.out.println(t[0] +"," +t[1]+","+t[2]));

        System.out.println("*****************************");
        //use the value to create a stream
        Stream<String> stream1 = Stream.of("Python", "Java", "Lambda","C++");
        stream1.map(String::toUpperCase).forEach(System.out::println);

        //Empty Stream
        Stream<String> stream2 = Stream.empty();
        //use the array to create a stream
        int[] numbers3 = {2,3,4,5,6};
        int sum = Arrays.stream(numbers3).sum();
        System.out.println(sum);

        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("test.txt"), Charset.defaultCharset()))
        {
            uniqueWords = lines.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("*****************************");
        System.out.println("UniqWordsCount is:" + uniqueWords);

        //无限流
        //Stream.iterate() and Stream.generate();
        Stream.iterate(1, n->n*2).limit(11).forEach(System.out::println);
        Stream.iterate(new int[]{0,1}, t->new int[]{t[1],t[0]+t[1]}).limit(47).map(t->t[0]).forEach(System.out::println);

        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);
        int sum1 = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(sum1);
        double average = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(average);



        int totalCalories = menu.stream().collect(reducing(0,Dish::getCalories,(i,j)->(i+j)));
        System.out.println("totalCalories:" + totalCalories);
        //joining string
        String shortName = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortName);

        String shortName1 = menu.stream().collect(reducing("",Dish::getName,(d1,d2)->d1 + d2+", "));
        System.out.println(shortName1);
        String shortName2 = menu.stream().map(Dish::getName).collect(reducing((s1,s2)->s1+", "+s2)).get();
        System.out.println(shortName2);

        //group by
        //方法引用
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        // Lambda expression
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(
                dish->{if(dish.getCalories()<=400) return   CaloricLevel.DIET;
                else if(dish.getCalories()<=700) return  CaloricLevel.NORAML;
                else return CaloricLevel.FAT;}));
        System.out.println(dishesByCaloricLevel);

        // 多级分组
        Map<Dish.Type,Map<CaloricLevel,List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,groupingBy(
                        dish->{if(dish.getCalories()<=400) return   CaloricLevel.DIET;
                        else if(dish.getCalories()<=700) return  CaloricLevel.NORAML;
                        else return CaloricLevel.FAT;}
                ))
        );
        System.out.println(dishesByTypeCaloricLevel);

        //第一个groupby 的第二个收集器可以是任何类型
        Map<Dish.Type,Long> typesCount =  menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        //maxBy 工厂方法生成的收集器
        Map<Dish.Type, Optional<Dish>> mostCalorcByType = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCalorcByType);
        Map<Dish.Type, Dish> mostCalorcByType2 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));


        int totalCalories2 = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories2);



    }


}

enum CaloricLevel{DIET, NORAML, FAT}




