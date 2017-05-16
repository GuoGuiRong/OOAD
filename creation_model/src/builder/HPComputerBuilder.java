package builder;

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