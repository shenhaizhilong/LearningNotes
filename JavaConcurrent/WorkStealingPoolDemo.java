package JavaConcurrent;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/29 21:48
 */
public class WorkStealingPoolDemo {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService service = Executors.newWorkStealingPool(2);
        List<Callable<String>> callableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int number = i +1;
            Callable<String> call = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Date date = new Date();
                    Thread.sleep(2000); // this task will cost 2s
                    return "Thread " + Thread.currentThread().getName() + ", Id " + Thread.currentThread().getId() + ", finish task:" + number + ", time  " + date.toString();

                }
            };
            callableList.add(call);
        }

        service.invokeAll(callableList).stream()
                .map(stringFuture -> {
                    try {
                        return stringFuture.get();
                    }catch (Exception ex)
                    {
                        throw new IllegalStateException(ex);
                    }
                }).forEach(System.out::println);

    }
}
