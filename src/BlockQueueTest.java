import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);

        Thread Putter = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i ++) {
                    try {
                        blockingQueue.put("item:" + i);
                        System.out.println("item put, no " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Putter.start();

        Thread Taker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                        String cargo = blockingQueue.take();
                        System.out.println("get cargo :" + cargo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        Taker.start();
    }
}
