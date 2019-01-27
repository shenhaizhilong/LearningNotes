package DesignPattern.Decorator;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 10:19
 */
public interface Troll {
    // attack you
    void attack();
    // run away from the battle
    void fleeBattle();

    int getAttackPower();
}
