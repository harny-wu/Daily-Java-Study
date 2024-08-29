package concurrent.consumerAndProducer;

public interface IBuffer<T> {
    void produce(T val);

    T consume();
}