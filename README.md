# Design-pattern
有关数据模式的各种代码测试，反射，动态代理，拦截器等

1.反射：反射的优点时只要配置就可以生成对象，可以接触程序的耦合度，比较灵活。
反射的缺点是运行比较慢。但大部分情况下为了灵活度，降低程序耦合度，我们还是会使用反射的，比如springIOC容器。

关键代码：<br>
构造方法中无参数时,**反射对象**：object = (ReflectServiceImpl) Class.forName("com.lz.reflect.ReflectServiceImpl").newInstance();<br>
构造方法中有参数时，**反射对象**：object = (ReflectServiceImpl2) Class.forName("com.lz.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");

反射方法：<br>
Method method = target.getClass().getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");
<br>或者：<br>
Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");

2.动态代理：动态代理的意义在于生成一个占位（又称代理对象），来代理真实对象，从而控制真实对象的访问。
<br>
分为两个步骤：
