package builder;

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