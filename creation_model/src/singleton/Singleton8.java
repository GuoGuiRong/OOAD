package singleton;

import java.io.*;

/**
 * 使用枚举实现单例
 */
public enum  Singleton8 implements Serializable {
	INSTANCE;
	public static Singleton8 getInstance(){
		return INSTANCE;
	}

	//测试方式,把单例对象序列化后再反序列化从而获得一个新的对象 就相当于复制了一个单例对象
	public static Singleton8 copy() throws Exception{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(Singleton8.getInstance());

		InputStream is = new ByteArrayInputStream(os.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(is);
		Singleton8 obj = (Singleton8) ois.readObject();
		return obj;
	}

	public static void main(String[] args){
		Singleton8 p = Singleton8.getInstance();
		Singleton8 p1=null;
		try {
			p1=copy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(p==p1);
	}
}