package concurrent.consumerAndProducer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockQueen {

    public static class Buffer implements IBuffer<Integer> {
        private BlockingDeque<Integer> blockingDeque;
        public Buffer(int cap) {
            this.blockingDeque = new LinkedBlockingDeque(cap);
        }

        @Override
        public void produce(Integer val) {
            this.blockingDeque.offer(val);
        }

        @Override
        public Integer consume() {
            return this.blockingDeque.poll();
        }
    }

    public static class Consumer implements Runnable {
        private IBuffer buffer;

        public Consumer(IBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Producer implements Runnable {
        private IBuffer buffer;

        public Producer(IBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        IBuffer buffer = new Buffer(10);
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}
