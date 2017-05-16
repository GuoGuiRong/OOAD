package factory.abstractfactory;

//两个工厂的实现类
public class SendMailFactory implements Provider {
	    public Sender produce(){  
	        return new MailSender();  
	    }  
}