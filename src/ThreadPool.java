import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(3);

    private int consumer = 3;

    public void insertConsumer(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    ThreadPool() {
        for (int i = 0; i < consumer; i ++) {
            Solver solver = new Solver(taskQueue, i);
            solver.start();
        }
    }
}
