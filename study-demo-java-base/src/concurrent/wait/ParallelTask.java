package concurrent.wait;

import java.util.concurrent.CountDownLatch;

public class ParallelTask {
    public static void main(String[] args) {
        int count = 3;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                // 线程执行任务
                System.out.println(Thread.currentThread().getName() + " 执行任务...");
                // 任务执行完毕，计数器减1
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("所有任务执行完毕...");

    }
}
