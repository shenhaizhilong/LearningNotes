package hello_world;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */
public class Point
{
    private int x;
    private int y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public Point moveRightBy(int x)
    {
        return new Point(this.x + x, y);
    }


/*    @Test
    public void testMoveRithBy() throws Exception
    {
        Point p1 = new Point(5,5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15, p2.getX());
        assertEquals(5,p2.getY());
    }*/

}
