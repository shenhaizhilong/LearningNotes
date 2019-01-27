package DesignPattern.Proxy;

import java.util.logging.Logger;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/27 18:22
 */
public class GameServerProxy implements Server {
    private static final Logger logger = Logger.getLogger(GameServerProxy.class.getName());
    private final int numsAllowed;
    private int currNums;
    private Server gameServer;
    private static final int Age_Allowed = 18;
    public GameServerProxy(Server gameServer, int numsAllowed)
    {
        this.gameServer = gameServer;
        this.numsAllowed = numsAllowed;
    }
    @Override
    public void enter(User user) {
        if(user.getAge() < 18)
        {
            logger.info(user.toString() + " is a child, who is not allowed enter the game server");
            return;
        }
        if(currNums >= numsAllowed)
        {
            logger.info(user.toString() + " too many users, you are not allowed enter the game server");
            return;
        }
        gameServer.enter(user);
        currNums++;

    }

    public static void main(String[] args) {

        Server server = new GameServer();
        Server proxy = new GameServerProxy(server, 3);

        User user = new User("tom",10);
        User user1 = new User("lily", 20);
        User user2 = new User("alice", 30);
        User user3 = new User("jason", 40);
        User user4 = new User("Park", 30);
        proxy.enter(user);
        proxy.enter(user1);
        proxy.enter(user2);
        proxy.enter(user3);
        proxy.enter(user4);
    }
}
