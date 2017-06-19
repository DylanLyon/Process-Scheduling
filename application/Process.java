package application;


public class Process implements Comparable<Process>{

	private int arrivalTime;
	private int waitingTime;
	private int processID;
	private int averageWaitingTime;
	private int burstTime;
	private int priority;
	private int startTime;
	private int arrivalOrder;
	private int timesRan;
	private int remainingBurstTime;
	private int completedTime;
	
	Process(){
		
	}
	Process(int processID, int arrivalOrder){
		this.processID = processID;
		this.arrivalOrder = arrivalOrder;
	}
	
	Process(int processID, int burstTime, int priority, int arrivalTime){
		this.processID = processID;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
		this.priority = priority;
	}

	public int getTurnAroundTime(){
		return this.waitingTime + this.burstTime;
	}
	
	public int getStartTime(){
		return startTime;
	}
	public void setStartTime(int startTime){
		this.startTime = startTime;
	}
	
	public int getBurstTime(){
		return burstTime;
	}
	public void setBurstTime(int burstTime){
		this.burstTime = burstTime;
	}
	
	public int getPriority(){
		return priority;
	}
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	
	public int getProcessID(){
		return processID;
	}
	public void setProcessID(int id){
		processID = id;
	}
	public int getArrivalTime(){
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	public int getWaitingTime(){
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime){
		this.waitingTime = waitingTime;
	}
	
	
	public int getAverageWaitingTime(){
		return averageWaitingTime;
	}
	public String print(){
		return "ID: " + getProcessID() + "| Burst Time: " + getBurstTime() + "| Arrival Time: " + getArrivalTime() + "| Priority: " + getPriority();
	}
	@Override
	public int compareTo(Process o) {

		int comparePriority=((Process)o).getPriority();
		
		return comparePriority-this.priority;
	}
	
	public int getArrivalOrder() {
		return arrivalOrder;
	}
	public int getTimesRan() {
		return timesRan;
	}
	public void setTimesRan(int timesRan) {
		this.timesRan = timesRan;
	}
	public int getRemainingBurstTime() {
		return remainingBurstTime;
	}
	public void setRemainingBurstTime(int remainingBurstTime) {
		this.remainingBurstTime = remainingBurstTime;
	}
	public int getCompletedTime() {
		return completedTime;
	}
	public void setCompletedTime(int completedTime) {
		this.completedTime = completedTime;
	}
	
	
	
	
	
	
}

