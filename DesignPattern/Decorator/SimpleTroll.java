package DesignPattern.Decorator;

import java.util.logging.Logger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 10:22
 */
public class SimpleTroll implements Troll {
    private static final Logger logger = Logger.getLogger(SimpleTroll.class.getName());

    @Override
    public void attack() {
        logger.info("the troll try to attack you");
    }

    @Override
    public void fleeBattle() {
        logger.info("the troll runs away");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }
}
