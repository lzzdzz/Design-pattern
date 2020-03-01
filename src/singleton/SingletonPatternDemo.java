package singleton;

/**
 * 单例测试
 * singleObject和singleObject1的对象是同一个
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        //懒汉式1,没用synchronized修饰Instance
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        System.out.println(singletonLazy);
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy1);

        //懒汉式2，线程安全
        SingletonLazy1 singletonLazy11 = SingletonLazy1.getInstance();
        System.out.println(singletonLazy11);
        SingletonLazy1 singletonLazy12 = SingletonLazy1.getInstance();
        System.out.println(singletonLazy12);

        //饿汉式
        SingletonHungry singletonHungry = SingletonHungry.getInstance();
        System.out.println(singletonHungry);
        SingletonHungry singletonHungry1 = SingletonHungry.getInstance();
        System.out.println(singletonHungry1);

        //双锁式
        SingletonDoubleLock singletonDoubleLock = SingletonDoubleLock.getInstance();
        System.out.println(singletonDoubleLock);
        SingletonDoubleLock singletonDoubleLock1 = SingletonDoubleLock.getInstance();
        System.out.println(singletonDoubleLock1);

        //静态内部类
        SingletonRegister singletonRegister = SingletonRegister.getInstance();
        System.out.println(singletonRegister);
        SingletonRegister singletonRegister1 = SingletonRegister.getInstance();
        System.out.println(singletonRegister1);

        //枚举式
        System.out.println(SingletonEnum.INSTANCE);

    }
}
