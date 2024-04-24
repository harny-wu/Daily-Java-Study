package single;

/**
 * 同步代码块，线程安全占用多
 */
public class LazySyncSingleton {
    private LazySyncSingleton(){}
    private static LazySyncSingleton instance;

    public static synchronized LazySyncSingleton getInstance(){
        if (instance == null){
            instance = new LazySyncSingleton();
        }
        return instance;
    }

}
