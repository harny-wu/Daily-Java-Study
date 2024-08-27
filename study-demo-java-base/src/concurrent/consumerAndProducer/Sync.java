package concurrent.consumerAndProducer;

import java.util.ArrayList;
import java.util.List;

public class Sync {

    public interface IBuffer<T> {
        void produce(T val);

        T consume();
    }

    public class Buffer implements IBuffer<Integer> {
        public List<Integer> list;
        public int cap;

        public Buffer(int cap) {
            list = new ArrayList<>(cap);
            this.cap = cap;
        }

        @Override
        public void produce(Integer val) {

        }

        @Override
        public Integer consume() {
            return null;
        }
    }

    public class Consumer implements Runnable {
        private IBuffer buffer;

        public Consumer(IBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {

        }
    }

    public class Producer implements Runnable {
        private IBuffer buffer;

        public Producer(IBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            buffer.produce();
        }
    }

    public static void main(String[] args) {

    }
}
