import java.util.Random;

public class TaskCreator extends Thread {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();

        for (int i = 0; i < 10; i ++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();

                    int randoTime = Math.abs(random.nextInt()) % 20;

                    try {
                        Thread.sleep(randoTime * 1000);

                        System.out.println("task is running...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.insertConsumer(task);
            System.out.println("insert a new task.... :" + i);

        }


    }
}
