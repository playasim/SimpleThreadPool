import java.util.concurrent.BlockingQueue;

public class Solver extends Thread {
    private BlockingQueue<Runnable> blockingQueue = null;

    private String name;

    public Solver(BlockingQueue<Runnable> tasks, int name) {
        this.blockingQueue = tasks;
        this.name = String.valueOf(name);
    }

    public void run() {
        while (true) {
            try {
                Runnable task = blockingQueue.take();
                System.out.println("Solver recieved one task :" + name);
                task.run();
                System.out.println("Solver finished task :" + name);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
