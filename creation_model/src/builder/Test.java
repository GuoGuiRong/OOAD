package builder;

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