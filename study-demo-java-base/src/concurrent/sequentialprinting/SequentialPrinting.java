package concurrent.sequentialprinting;

public class SequentialPrinting {
    public static void main(String[] args) throws InterruptedException {
        Runnable runFirst = new Runnable() {
            @Override
            public void run() {
                System.out.println("first print");
            }
        };
        Runnable runSecond = new Runnable() {
            @Override
            public void run() {
                System.out.println("runSecond print");
            }
        };

        Thread thread1 = new Thread(runFirst);
        Thread thread2 = new Thread(runSecond);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}
