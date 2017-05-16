package factory;

//测试类
public class FactoryTest1 {
	  
	    public static void main(String[] args) {  
	        SendFactory1 factory1 = new SendFactory1();
	        Sender sender = factory1.produceMail();
	        sender.Send();  
	    }  
	} 