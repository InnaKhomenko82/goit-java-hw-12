import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int n){
        super(n, n, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable process){
        int countAnnotation = process.getClass().getAnnotation(Repeat.class).count();
        while (countAnnotation--> 0) {
            super.execute(process);
        }
    }
}
