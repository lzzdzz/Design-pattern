package singleton;

/**
 * 饿汉式实现
 * 不需要加锁，synchronized
 * 优点：没有加锁，效率高
 * 缺点：容易产生垃圾对象，类加载时就初始化，浪费内存
 */
public class SingletonHungry {
    //静态实例
    private static SingletonHungry instance = new SingletonHungry();

    //让构造方法私有化，就不会实例化
    private SingletonHungry(){

    }
    //获取唯一可用对象
    public static SingletonHungry getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("hello,world");
    }
}
