package application;

public class Stats {

	protected static void display(Process[] array){

		stats(array);
		
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i].print() + 
					"| Arrival Order: " + array[i].getArrivalOrder() + 
					"| Waiting Time: " + array[i].getWaitingTime() +
					"| Turnaround Time: " + array[i].getTurnAroundTime());
		}
	}

	protected static void stats(Process[] jobs) {
		
		int waitingTime = 0;
		int totalWaitingTime = 0;
		
		for(int i = 0; i < jobs.length; i++){
			waitingTime = totalTime(jobs,i);
			jobs[i].setWaitingTime(waitingTime);
			totalWaitingTime+=waitingTime;
		}
		
		System.out.println("Average waiting time: " + totalWaitingTime/(double)jobs.length);
		
	}
	
	protected static int totalTime(Process[] array, int index){
		int time = 0;
		for(int i = 0; i < index; i++){
			time+=array[i].getBurstTime();
		}
		return time;
	}
	
	
}
