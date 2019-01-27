package DesignPattern.Decorator;

import java.util.logging.Logger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 10:25
 */
public class SwordTroll implements Troll {
    private static final Logger logger = Logger.getLogger(SwordTroll.class.getName());
     private Troll troll;
    public SwordTroll(Troll troll)
    {
        this.troll = troll;
    }
    @Override
    public void attack() {
        troll.attack();
        logger.info("the troll attack with you with a sword");
    }

    @Override
    public int getAttackPower() {
        return troll.getAttackPower() + 20;
    }

    @Override
    public void fleeBattle() {
        troll.fleeBattle();
    }
}
