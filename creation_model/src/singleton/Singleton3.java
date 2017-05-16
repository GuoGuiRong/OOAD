package singleton;

/**
 * 简单的单例类 懒汉模式
 * 解决线程安全问题,但是每次访问都要加锁,效率地,况且其实只要在第一次加载时加锁便可
 */
public class Singleton3 {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton3 instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton3() {
    }

    /* 静态工程方法，创建实例 */
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
