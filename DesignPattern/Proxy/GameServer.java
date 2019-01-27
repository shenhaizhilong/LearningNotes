package DesignPattern.Proxy;

import java.util.logging.Logger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 18:15
 */
public class GameServer implements Server {
    private static final Logger logger = Logger.getLogger(GameServer.class.getName());
    @Override
    public void enter(User user) {
        logger.info( user + "enters the server");
    }
}
