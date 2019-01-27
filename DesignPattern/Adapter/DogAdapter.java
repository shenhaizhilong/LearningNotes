package DesignPattern.Adapter;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 17:46
 */
public class DogAdapter implements Cat {

    private Dog dog;
    public DogAdapter(Dog dog)
    {
        this.dog = dog;
    }
    @Override
    public void miaowmiaow() {
        dog.bark();
    }

    public static void main(String[] args) {
        Dog dog = new BlackDog();
        Cat cat = new DogAdapter(dog);
        cat.miaowmiaow();
    }
}
