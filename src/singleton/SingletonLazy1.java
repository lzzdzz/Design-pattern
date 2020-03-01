package singleton;

/**
 * 懒汉式，加了synchronized,保证了线程安全
 * 优点：第一次调用才初始化，避免内存浪费
 * 缺点：加锁影响效率
 */
public class SingletonLazy1 {
    private static SingletonLazy1 instance;

    private SingletonLazy1(){

    }

    public static synchronized SingletonLazy1 getInstance(){
        if (instance == null){
            instance = new SingletonLazy1();
        }
        return instance;
    }
}
