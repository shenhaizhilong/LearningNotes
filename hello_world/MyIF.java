package hello_world;


public interface MyIF
{
    public int getUserID();
    default int getAdminID()
    {
        return 0;
    }
    static int getUniversalID()
    {
        return 100;
    }

    static void main(String[] args) {
        System.out.println(getUniversalID());
    }
}

interface MyIF2 extends  MyIF
{

}
