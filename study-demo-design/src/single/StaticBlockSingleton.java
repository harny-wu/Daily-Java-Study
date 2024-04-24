package single;

/**
 * 饿汉式。线程安全
 */
public class StaticBlockSingleton {
    private StaticBlockSingleton(){}
    private static final StaticBlockSingleton STATIC_BLOCK_SINGLETON;

    static {
        STATIC_BLOCK_SINGLETON = new StaticBlockSingleton();
    }

    public StaticBlockSingleton getStaticBlockSingleton(){
        return STATIC_BLOCK_SINGLETON;
    }
}
