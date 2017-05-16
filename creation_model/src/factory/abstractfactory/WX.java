package factory.abstractfactory;

public class WX implements Sender{
	@Override
	public void Send() {
		System.out.println("微信发送");
	}
}