package singleton;

/**
 简单的单例类 懒汉模式

 实现线程第一次加载时加锁便可,但是由于java指令的重排,很可能导致这个方法失效

  看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句并非是一个原子操作,在 JVM 中这句代码大概做了下面 3 件事情:
 1给 new的对象 分配内存
 2调用 Singleton 的构造函数来初始化成员变量
 3将引用instance指向分配的内存空间（执行完这步 instance 就为非 null 了）
 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，
 则在 3 执行完毕、2 未执行之前，另外一个线程B抢夺到了CPU的执行权,这时instance已经是非null了（但却没有初始化），
 所以线程B会直接返回 instance，然后使用，结果就会出现问题了(因为对象还没有初始化)。

 */
public class Singleton4 {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton4 instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton4() {
    }

    /* 静态工程方法，创建实例 */
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (instance){
                if(instance==null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
