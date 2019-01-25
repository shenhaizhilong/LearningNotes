package DesignPattern.FlyWeight;

import java.util.HashMap;

public class ChessmanFactory {
    private static ChessmanFactory factory = new ChessmanFactory();
    private static HashMap<String, Chessman>  ht;
    private ChessmanFactory()
    {
        ht = new HashMap<>();
        Chessman black, white;
        black = new BlackChessman();
        white = new WhiteChessman();
        ht.put("b", black);
        ht.put("w", white);
    }

    public static ChessmanFactory getFactory() {
        return factory;
    }

    public  Chessman getChessman(String color)
    {
        return ht.getOrDefault(color, null);
    }
}
