package single;

/**
 * 饿汉式，线程安全
 */
public class SimpleSingleton {
    private static final SimpleSingleton instance = new SimpleSingleton();
    private SimpleSingleton(){}

    public static SimpleSingleton getInstance(){
        return instance;
    }
}
