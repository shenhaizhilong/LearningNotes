package hello_world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenhaizhilong on 5/8/2017.
 */
public class ConstrMethodRef
{
    interface UserFactory<U extends User>
    {
        U create(int i, String name);
    }
    static UserFactory<User> uf = User::new;

    public static void main(String[] args)
    {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(uf.create(i,"Billy" + i));
        }
        userList.stream().map(User::toString).forEach(System.out::println);
    }
}
