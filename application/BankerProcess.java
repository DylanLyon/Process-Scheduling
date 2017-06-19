package application;

public class BankerProcess {
	
	private int processID;
	private Resources allocated;
	private Resources max;
	
	BankerProcess(){}
	
	BankerProcess(int processID, Resources allocated, Resources max){
		this.processID = processID;
		this.allocated = allocated;
		this.max = max;
	}
	
	public void setID(int ID){
		this.processID = ID;
	}
	public int getID(){
		return processID;
	}
	
	public void setAllocated(Resources allocated){
		this.allocated = allocated;
	}
	public Resources getAllocated(){
		return allocated;
	}

	public void setMax(Resources max){
		this.max = max;
	}
	public Resources getMax(){
		return max;
	}
	
	public Resources releaseResources(Resources available){
		
		int A = this.allocated.getA() + available.getA();
		int B = this.allocated.getB() + available.getB();
		int C = this.allocated.getC() + available.getC();
		int D = this.allocated.getD() + available.getD();
		
		Resources newAvailable = new Resources(A, B, C, D);
		
		return newAvailable;
	}
	
	public Resources getNeeded() {
		
		int A = this.max.getA()-this.allocated.getA();
		int B = this.max.getB()-this.allocated.getB();
		int C = this.max.getC()-this.allocated.getC();
		int D = this.max.getD()-this.allocated.getD();
		
		Resources needed = new Resources(A, B, C, D);
		
		return needed;
	}
	
	public String print(){
		return "ID: " + getID() + "| Allocated: " + allocated.print() + "| Max: " + max.print();
	}
}
