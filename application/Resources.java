package application;

public class Resources {
	
	private int A;
	private int B;
	private int C;
	private int D;
	private int resourceID;
	
	Resources(){
		this.A = 0;
		this.B = 0;
		this.C = 0;
		this.D = 0;
	}
	
	Resources(int A, int B, int C, int D){
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	Resources(int ID, int A, int B, int C, int D){
		this.setResourceID(ID);
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	public int getA(){
		return A;
	}
	public int getB(){
		return B;
	}
	public int getC(){
		return C;
	}
	public int getD(){
		return D;
	}
	
	public void setA(int A){
		this.A = A;
	}
	public void setB(int B){
		this.B = B;
	}
	public void setC(int C){
		this.C = C;
	}
	public void setD(int D){
		this.D = D;
	}

	public boolean isComparedTo(Resources allocated) {
		
		if(this.A <= allocated.getA() && this.B <= allocated.getB() && this.C <= allocated.getC() && this.D <= allocated.getD()){
			return true;
		}
		return false;
	}

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}
	
	public String print(){
		return getA() + " " + getB() + " " + getC() + " " + getD();
	}
}
