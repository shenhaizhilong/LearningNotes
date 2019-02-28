package FastJson;

import com.alibaba.fastjson.JSON;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/13 12:11
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        Group group = new Group();
        group.setId(0L);
        group.setName("Admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest 1");
        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonStr = JSON.toJSONString(group);
        System.out.println(jsonStr);
    }
}
