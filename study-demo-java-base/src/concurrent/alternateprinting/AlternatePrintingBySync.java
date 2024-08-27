package concurrent.alternateprinting;


/**
 * 会出现额外抢占锁
 */
public class AlternatePrintingBySync {
    private static final Object lock = new Object();
    private static final int MAX_COUNT = 100;
    private static int curr = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            while (curr < MAX_COUNT) {
                synchronized (lock) {
                    if (curr % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " :" + curr++);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (curr < MAX_COUNT) {
                synchronized (lock) {
                    if (curr % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " :" + curr++);
                    }
                }
            }
        }).start();
    }
}
