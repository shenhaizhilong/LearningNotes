package JavaConcurrent;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/5 19:06
 *
 * don't use Thread.Stop. it was deprecated.
 */
public class StopThreadUnSafe {
    private static User user = new User();
    private static class User
    {

        private int id;
        private String name;

        public User()
        {
            this.id = 0;
            this.name = "0";
        }
        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "[ id=" + id + ", name=" + name +"]";
        }
    }

    private static class ChangeUser implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                synchronized (user)
                {
                    int id = (int) System.currentTimeMillis()/1000;
                    user.setId(id);

                    // do something else
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    user.setName(Integer.toString(id));
                }
                Thread.yield();
            }
        }
    }

    private static class ReadUser implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                synchronized (user)
                {
                    if (user.getId() != Integer.parseInt(user.getName()))
                    {
                        System.out.println(user);
                    }
                }
                Thread.yield();
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new ReadUser()).start();
        while (true)
        {
            Thread t = new Thread(new ChangeUser());
            t.start();
            try
            {
                Thread.sleep(150);
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }

            t.stop();
        }
    }
}
