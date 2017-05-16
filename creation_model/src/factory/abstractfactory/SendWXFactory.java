package factory.abstractfactory;

public class SendWXFactory implements Provider {
    public Sender produce(){
	        return new WX();  
	    }  
	} 