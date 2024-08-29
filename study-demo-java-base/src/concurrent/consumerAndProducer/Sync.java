package concurrent.consumerAndProducer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * synchronized + wait + notify
 */
public class Sync {

    public static class Buffer implements IBuffer<Integer> {
        public LinkedList<Integer> list;
        public int cap;

        public Buffer(int cap) {
            list = new LinkedList<>();
            this.cap = cap;
        }

        @Override
        public void produce(Integer val) {
            synchronized (this) {
                while (this.list.size() == cap) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                list.add(val);
                System.out.println("Produced " + val);
                this.notify();
            }

        }

        @Override
        public Integer consume() {
            synchronized (this) {
                while (this.list.isEmpty()) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int val = this.list.poll();
                System.out.println("consume " + val);
                this.notify();
                return val;
            }
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
