import lombok.SneakyThrows;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water {
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    private final Semaphore hydrogen = new Semaphore(2, true);
    private final Semaphore oxygen = new Semaphore(1, true);

    @SneakyThrows
    public void hydrogen (Runnable releaseHydrogen){
        hydrogen.acquire();
        releaseHydrogen.run();
        cyclicBarrier.await();
        hydrogen.release();
    }

    @SneakyThrows
    public void oxygen (Runnable releaseOxygen){
        oxygen.acquire();
        releaseOxygen.run();
        cyclicBarrier.await();
        oxygen.release();
    }
}