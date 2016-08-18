package PrinterJob;

public class Job{
	String name;
	int priority;
	
	Job(String name , int priority){
		this.name = name;
		this.priority = priority;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPriority(){
		return this.priority;
	}
}