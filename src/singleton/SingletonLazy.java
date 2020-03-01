package singleton;

/**
 * 懒汉式，线程不安全，是最基本的实现方式
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){
    }

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
