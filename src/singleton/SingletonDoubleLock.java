package singleton;

/**
 * 双加锁实现
 * getInstance（）的性能很重要
 * 在线程安全的模式下保持了高效率
 */
public class SingletonDoubleLock {
    private static SingletonDoubleLock singleton;

    private SingletonDoubleLock(){

    }

    public static SingletonDoubleLock getInstance(){
        if(singleton == null){
            synchronized(SingletonDoubleLock.class){
                if (singleton == null){
                    singleton = new SingletonDoubleLock();
                }
            }
        }
        return singleton;
    }
}
