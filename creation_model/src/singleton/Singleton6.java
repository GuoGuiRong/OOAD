package singleton;

/**
 * 类加载阶段线程安全
 */
public class Singleton6 {

	private boolean flag=false;

    /* 私有构造方法，防止被实例化 */
	private Singleton6() {
		if(!flag){
			flag=true;
		}else{
			throw new RuntimeException("单例对象不能重复构建");
		}
	}

	/* 此处使用一个内部类来维护单例 */
	private static class SingletonFactory {
		private static Singleton6 instance = new Singleton6();
	}

	/* 获取实例 */
	public static Singleton6 getInstance() {
		    return SingletonFactory.instance;  
	}

	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
	private Object readResolve() {
		    return getInstance();  
	}
}