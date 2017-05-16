
设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。
使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性。

毫无疑问，设计模式于己于他人于系统都是多赢的，设计模式使代码编制真正工程化，设计模式是软件工程的基石，如同大厦的一块块砖石一样。
项目中合理的运用设计模式可以完美的解决很多问题，每种模式在现在中都有相应的原理来与之对应，每一个模式描述了一个在我们周围不断重复发生的问题，
以及该问题的核心解决方案，这也是它能被广泛应用的原因。


一、设计模式的分类

	创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

	结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

	行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代器模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

二、Java的23中设计模式

  1、工厂方法模式（Factory Method）
	 工厂方法模式分为三种：
	 1.普通工厂模式
	 2.多个工厂方法模式
	 3.静态工厂方法模式

	普通工厂模式，就是建立一个工厂类，对实现了同一接口的产品类进行实例的创建

	例子:
	//发送短信和邮件的接口
	public interface Sender {  
	    public void Send();  
	} 

	//发送邮件的实现类
	public class MailSender implements Sender {  
	    public void Send() {  
	        System.out.println("发送邮件!");  
	    }  
	}  
	//发送短信的实现类
	public class SmsSender implements Sender {  
	    public void Send() {  
	        System.out.println("发送短信!");  
	    }  
	}  

	//创建工厂类
	public class SendFactory {  
	    //工厂方法
	    public Sender produce(String type) {  
	        if ("mail".equals(type)) {  
	            return new MailSender();  
	        } else if ("sms".equals(type)) {  
	            return new SmsSender();  
	        } else {  
	            System.out.println("请输入正确的类型!");  
	            return null;  
	        }  
	    }  
	} 	

	//测试类
	public class FactoryTest {  
  
	    public static void main(String[] args) {  
	        SendFactory factory = new SendFactory();  
	        Sender sender = factory.produce("sms");
	        sender.Send();  
	    }  
	} 


	1.2、多个工厂方法模式 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。

	//将上面的代码做下修改，改动下SendFactory类就行
	//这个就不用根据用户传的字符串类创建对象了
	public class SendFactory {  
      
	    public Sender produceMail(){  
	        return new MailSender();  
	    }  
	      
	    public Sender produceSms(){  
	        return new SmsSender();  
	    }  
	}

	//测试类
	public class FactoryTest {  
	  
	    public static void main(String[] args) {  
	        SendFactory factory = new SendFactory();  
	        Sender sender = factory.produceMail();  
	        sender.Send();  
	    }  
	}  

    1.3、静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。

	public class SendFactory {  
	  
	    public static Sender produceMail(){  
	        return new MailSender();  
	    }  
	      
	    public static Sender produceSms(){  
	        return new SmsSender();  
	    }  
	}  

	//测试类
	public class FactoryTest {  
	  
	    public static void main(String[] args) {      
	        Sender sender = SendFactory.produceMail();  
	        sender.Send();  
	    }  
	}  	


   2、抽象工厂模式（Abstract Factory）
       	工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，所以，从设计角度考虑，有一定的问题，如何解决？就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。

       	例子:

       	//发送短信和邮件的接口
	public interface Sender {  
	    public void Send();  
	} 

	//发送邮件的实现类
	public class MailSender implements Sender {  
	    public void Send() {  
	        System.out.println("发送邮件!");  
	    }  
	}  
	//发送短信的实现类
	public class SmsSender implements Sender {  
	    public void Send() {  
	        System.out.println("发送短信!");  
	    }  
	}
	public class WX imp Sender{
 	    public void send(){
		syso(“微信发送”);
		}
	}
    public class SendWXFactory implements Provider {
	    public Sender produce(){  
	        return new WX();  
	    }  
	}  

	//给工厂类一个接口
	public interface Provider {  
	    public Sender produce();  
	}  
	//两个工厂的实现类
	public class SendMailFactory implements Provider {  
	    public Sender produce(){  
	        return new MailSender();  
	    }  
	}  
	

	//测试类
	public class Test {  
	  
	    public static void main(String[] args) {  
	        Provider provider = new SendMailFactory();  
	        Sender sender = provider.produce();  
	        sender.Send();  
	    }  
	}  

	注:这个模式的好处就是，如果你现在想增加一个功能：发送及时信息，则只需做一个实现类实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好


   3、单例模式（Singleton）
  	单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：

	1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
	2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
	3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。

	例子：
	//简单的单例类  饿汉模式
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

	这个类是可以实现单例模式的，但是存在不少问题,比如在类中不管用户是否要使用该类的对象,就先创建好了一个实例放在内存中。

	//简单的单例类 懒汉模式
	public class Singleton {  

		/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */  
		private static Singleton instance = null;  

		/* 私有构造方法，防止被实例化 */  
		private Singleton() {  
		}  

		/* 静态工程方法，创建实例 */  
		public static Singleton getInstance() {  
		    if (instance == null) { 
		        instance = new Singleton();  
		    }  
		    return instance;  
		}  

		
	}  

	这个类可以满足基本要求，但是，像这样毫无线程安全保护的类，如果我们把它放入多线程的环境下，肯定就会出现问题了，如何解决？我们首先会想到对getInstance方法加synchronized关键字，如下：

	public static synchronized Singleton getInstance() {  
		if (instance == null) {  
		    instance = new Singleton();  
		}  
		return instance;  
	}  	

	但是，synchronized作为修饰符在方法上使用,在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，所以，这个地方需要改进。我们改成下面这个：
	public static Singleton getInstance() {  
		if (instance == null) {  
		    synchronized (instance) {  
		        if (instance == null) {  
		            instance = new Singleton();  
		        }  
		    }  
		}  
		return instance;  
	}  

	似乎解决了之前提到的问题，将synchronized关键字加在了方法内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，并创建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的。
	看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句并非是一个原子操作,在 JVM 中这句代码大概做了下面 3 件事情:
		1给 new的对象 分配内存
		2调用 Singleton 的构造函数来初始化成员变量
		3将引用instance指向分配的内存空间（执行完这步 instance 就为非 null 了）
	但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，另外一个线程B抢夺到了CPU的执行权,这时instance已经是非null了（但却没有初始化），所以线程B会直接返回 instance，然后使用，结果就会出现问题了(因为对象还没有初始化)。

	还有另外一种解决方案:使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的(就是加载完毕后别的线程才能使用)。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。例如：
	
	public class Singleton {  
	  
		/* 私有构造方法，防止被实例化 */  
		private Singleton() {  
		}  

		/* 此处使用一个内部类来维护单例 */  
		private static class SingletonFactory {  
		    private static Singleton instance = new Singleton();  
		}  

		/* 获取实例 */  
		public static Singleton getInstance() {  
		    return SingletonFactory.instance;  
		}  

		/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
		private Object readResolve() {  
		    return getInstance();  
		}  
	}

	但是如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。

	同时，我们还可以使用反射去创建这个类的对象，即使它的构造器是私有的，我们也是可以调用到的。那么这个时候我们就需要再次修改代码去访问别人反射调用构造器。
	例子:
	//在构造器中控制一下，构造器只允许调用一次,之后在调用就抛出异常
	public class Singleton {  
		private static boolean flag;
		/* 私有构造方法，防止被实例化 */  
		private Singleton() {  
			if(!flag){
				flag = false;
			}else{
				throw new RuntimeException("不能多次创建单例对象");
			}
		}  

		/* 此处使用一个内部类来维护单例 */  
		private static class SingletonFactory {  
		    private static Singleton instance = new Singleton();
		}  

		/* 获取实例 */  
		public static Singleton getInstance() {  
		    return SingletonFactory.instance;  
		}  

		/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
		private Object readResolve() {  
		    return getInstance();  
		}  
	}  	

	反射的问题处理完了之后，这里还有一个问题，就是如果把单例对象进行序列化然后再反序列化,那么内存中就会出现俩个一样的单例对象，只是内存地址不同。这种情况我们可以使用readResolve方法来防止。
	private Object readResolve(){.....}
	ObjectInputStream 会检查对象的class是否定义了readResolve方法。如果定义了，将由readResolve方法指定返回的对象。返回对象的类型一定要是兼容的，否则会抛出ClassCastException 。 
	例子:
	public abstract class Singleton8 implements Serializable{  

		private static final long serialVersionUID = 7863921642928237696L;

		/* 此处使用一个内部类来维护单例 */  
		private static class SingletonFactory {  
		    @SuppressWarnings("serial")
			private static Singleton8 instance = new Singleton8(){};
		}  
		
		//测试方式,把单例对象序列化后再反序列化从而获得一个新的对象 就相当于复制了一个单例对象
		public Singleton8 copy() throws Exception{  
		        ByteArrayOutputStream os = new ByteArrayOutputStream();  
		        ObjectOutputStream oos = new ObjectOutputStream(os);  
		        oos.writeObject(Singleton8.getInstance());  
		          
		        InputStream is = new ByteArrayInputStream(os.toByteArray());  
		        ObjectInputStream ois = new ObjectInputStream(is);  
		        Singleton8 obj = (Singleton8) ois.readObject();  
		        return obj;  
		} 
		
		/* 获取实例 */  
		public static Singleton8 getInstance() {  
		    return SingletonFactory.instance;  
		}  

		/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
		/* 把这个方法注释前和注释后来运行测试代码观察结果 */  
		private Object readResolve() {  
		    return getInstance();  
		}  
	}

	最后再思考一个问题  :  是否可以使用枚举来实现单例模式?
	可以，枚举本来就是为了保证单例，枚举可以说是一种线程安全，不会因为序列化产生多个实例，防止反射攻击。


  4、建造者模式（Builder）
       	工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对
象就是指某个类具有不同的属性。建造者模式主要用于“分步骤构建一个复杂的对象”，在这其中“分步骤”是一个稳定的算法，
而复杂对象的各个部分则经常变化。因此， 建造者模式主要用来解决“对象部分”的需求变化。 这样可以对对象构造的过程进
行更加精细的控制。

    例子:
	//CPU接口
	public interface CPU {

	}
	//Inter的cup
	class IntelCPU implements CPU{
		
	}
	//AMD的cpu
	class AMDCPU implements CPU{
		
	}

	//内存接口
	public interface Memory {

	}
	//金士顿内存
	class KingstonMemory implements Memory{
		
	}
	//三星内存
	class SamsungMemory implements Memory{
		
	}

	//主板内存
	public interface Mainboard {

	}
	//华硕主板
	class AsusMainboard implements Mainboard{
		
	}
	//技嘉主板
	class GaMainboard implements Mainboard{
		
	}

	//计算机
	public class Computer {
	    private CPU cpu;  
	    private Memory memory;  
	    private Mainboard mainboard;
	    get/set
	}

	//计算机的builder的接口
	public interface ComputerBuilder {  
	    public void buildCPU();    
	    public void buildMemory();    
	    public void buildMainboard();    
	    public Computer getComputer();   
	}  


	//联想电脑的builder
	public class LenoveComputerBuilder implements ComputerBuilder {  
	   private Computer lenoveComputer;    
	   public LenoveComputerBuilder(){    
	       lenoveComputer = new Computer();    
	   }    
	   public void buildCPU() {  
	       lenoveComputer.setCpu(new IntelCPU());  
	   }  
	   public void buildMemory() {  
	       lenoveComputer.setMemory(new KingstonMemory());  
	   }  
	   public void buildMainboard() {  
	       lenoveComputer.setMainboard(new AsusMainboard());  
	   }  
	   public Computer getComputer() {  
	       return lenoveComputer;  
	   }  
	}  

	//惠普电脑的builder
	public class HPComputerBuilder implements ComputerBuilder {  
	   private Computer HPComputer;    
	   
	   public HPComputerBuilder(){  
	       HPComputer = new Computer();  
	   }  
	   public void buildCPU() {  
	       HPComputer.setCpu(new AMDCPU());  
	   }  
	   public void buildMemory() {  
	       HPComputer.setMemory(new SamsungMemory());  
	   }  
	   public void buildMainboard() {  
	       HPComputer.setMainboard(new GaMainboard());  
	   }  
	   public Computer getComputer() {  
	       return HPComputer;  
	   }  
	} 

	//Director类(导演)
	//指导如何具体的创造电脑
	public class Director {
	    private ComputerBuilder builder;     
	    public Director(ComputerBuilder builder) {     
	        this.builder = builder;     
	    }    
	    //用户自定义的自造顺序 具体指导各种builder如何创建电脑
	    public void construct() {
	    	
	    	builder.buildCPU();
	    	builder.buildMemory();
	    	builder.buildMainboard();
	    }
	}

	//测试类
	public class Test {  
	    public static void main(String[] args) {
		Computer lenoveComputer = null;    
        		ComputerBuilder lenoveComputerBuilder = new LenoveComputerBuilder();    
		Director director = new Director(lenoveComputerBuilder);
		director.construct();
		lenoveComputer = lenoveComputerBuilder.getComputer();
		System.out.println(lenoveComputer);
	    }
	}  

	从这点看出，建造者模式将很多功能集成到一个类里，这个类可以创造出比较复杂的东西。所以与工程模式的区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建适合对象的多个部分。因此，是选择工厂模式还是建造者模式，依实际情况而定。
	例如一个Person类是由头、身体、脚三个对象组成，那么我们在建造者模式中就要先分别创造出这三个部分然后再把他们组装成一个Person对象。




  5、原型模式（Prototype）
       	原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，
       	产生一个和原对象类似的新对象。在Java中，复制对象是通过clone()实现的，先创建一个原型类：

	public class Prototype implements Cloneable {

		public Object clone() throws CloneNotSupportedException {  
			Prototype proto = (Prototype) super.clone();  
			return proto;  
		}  
	}  

	很简单，一个原型类，只需要实现Cloneable接口，覆写clone方法，此处clone方法可以改成任意的名称，因为Cloneable接口是个空接口，
	你可以任意定义实现类的方法名，如cloneA或者cloneB，因为此处的重点是super.clone()这句话，
	super.clone()调用的是Object的clone()方法，而在Object类中，clone()是native的，说明这个方法实现并不是使用java语言。

	在这里先认识俩个概念 : 浅复制   深复制
	浅复制：将一个对象复制后，基本数据类型的变量都会不会创建，指向的还是原来的值，而引用类型，指向的还是原对象所指向的。
	深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。


	public class Prototype implements Cloneable, Serializable {  
  
		private static final long serialVersionUID = 1L;  
		private String string;  
		//这个是在下面声明的一个类
		private SerializableObject obj;  

		/* 浅复制 */  
		public Object clone() throws CloneNotSupportedException {  
		    Prototype proto = (Prototype) super.clone();  
		    return proto;  
		}  

		/* 深复制 */  
		public Object deepClone() throws IOException, ClassNotFoundException {  

		    /* 写入当前对象的二进制流 */  
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();  
		    ObjectOutputStream oos = new ObjectOutputStream(bos);  
		    oos.writeObject(this);  

		    /* 读出二进制流产生的新对象 */  
		    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
		    ObjectInputStream ois = new ObjectInputStream(bis);  
		    return ois.readObject();  
		}  

		public String getString() {  
		    return string;  
		}  

		public void setString(String string) {  
		    this.string = string;  
		}  

		public SerializableObject getObj() {  
		    return obj;  
		}  

		public void setObj(SerializableObject obj) {  
		    this.obj = obj;  
		}  

	}

	class SerializableObject implements Serializable {  
	    private static final long serialVersionUID = 1L;  
	}  
