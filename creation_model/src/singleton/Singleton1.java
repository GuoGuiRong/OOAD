package singleton;

/**
 * 简单的单例类 懒汉模式
 * 实现了懒加载,但是有出现了线程安全问题
 */
public class Singleton1 {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton1 instance = null;

    /* 私有构造方法，防止被实例化 */
    private Singleton1() {
    }

    /* 静态工程方法，创建实例 */
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
