package singleton;

/**
 * 简单的单例类  饿汉模式
 *
 * 这个类是可以实现单例模式的，但是存在不少问题,比如在类中不管用户是否要使用该类的对象,就先创建好了一个实例放在内存中。
 */
public class Singleton {
    /* 持有私有静态实例，防止被引用*/
    private static Singleton instance = new Singleton();

    /* 私有构造方法，防止被实例化 */
    private Singleton() {
    }

    /* 静态工程方法，返回Singleton实例 */
    public static Singleton getInstance() {
        return instance;
    }

}
