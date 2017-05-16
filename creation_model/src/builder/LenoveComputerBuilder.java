package builder;

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