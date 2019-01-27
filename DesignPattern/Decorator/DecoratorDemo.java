package DesignPattern.Decorator;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 10:30
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        SimpleTroll simpleTroll = new SimpleTroll();
        simpleTroll.attack();
        simpleTroll.fleeBattle();

        SwordTroll swordTroll = new SwordTroll(simpleTroll);
        swordTroll.attack();
        swordTroll.fleeBattle();
    }
}
