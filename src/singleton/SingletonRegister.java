package singleton;

/**
 * 登记式/静态内部类
 * 优点：和双锁一样既没浪费空间又高效，在调用getInstance方法时才会初始化
 * 缺点：比较复杂
 */
public class SingletonRegister {
    private static class SingletonHolder{
        private static final SingletonRegister singleton = new SingletonRegister();
    }

    private SingletonRegister(){

    }
    public static final SingletonRegister getInstance(){
        return SingletonHolder.singleton;
    }
}
