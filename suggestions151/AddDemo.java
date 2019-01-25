package suggestions151;

import java.io.Serializable;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/25 17:22
 */
public class AddDemo implements Serializable {

    private static final long serialVersionUID = -9072156967470028314L;

    public static void main(String[] args) {

        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count++;
        }
        System.out.println(count);
    }
}
