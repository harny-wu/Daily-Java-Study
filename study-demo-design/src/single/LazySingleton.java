package single;

/**
 * 懒汉式，不安全
 */
public class LazySingleton {
    private LazySingleton(){}
    private static LazySingleton instance;

    public static LazySingleton getinstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
