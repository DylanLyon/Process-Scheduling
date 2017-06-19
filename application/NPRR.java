package application;

import java.util.ArrayList;

public class NPRR {

	protected static ArrayList<Process> sort(ArrayList<Process> array){
		int size = array.size();
		int quantum = 2;
		int waitingTime = 0;
		ArrayList<Process> finishedJobs = new ArrayList<Process>();
		
		while(!array.isEmpty()){
			
			for(int i = 0; i <array.size(); i++){
				
				if(array.get(i).getRemainingBurstTime()-quantum <= 0){
					System.out.println("Process: " + array.get(i).getProcessID() + " received " + array.get(i).getRemainingBurstTime() + " seconds of processing time and has completed.");

					array.get(i).setWaitingTime(waitingTime);
					waitingTime+=array.get(i).getRemainingBurstTime();
					finishedJobs.add(array.get(i));
					array.remove(i);
				}
				else{
					array.get(i).setRemainingBurstTime(array.get(i).getRemainingBurstTime()-quantum);
					System.out.println("Process: " + array.get(i).getProcessID() + 
							" received " + quantum + 
							" seconds of processing time and has " + array.get(i).getRemainingBurstTime() + 
							" second(s) remaining.");
					waitingTime+=quantum;
					array.get(i).setTimesRan(array.get(i).getTimesRan()+1);
				}
			}
			
		}
		
		System.out.println("-----------");
		int totalWaiting = 0;
		int waitTime = 0;
		for(int j = 0; j < finishedJobs.size(); j++){
			waitTime = finishedJobs.get(j).getWaitingTime()-(finishedJobs.get(j).getTimesRan()*quantum);
			totalWaiting += waitTime;
			finishedJobs.get(j).setWaitingTime(waitTime);
			System.out.println(finishedJobs.get(j).print() + 
					"| Arrival Order: " + finishedJobs.get(j).getArrivalOrder() + 
					"| Waiting Time: " + finishedJobs.get(j).getWaitingTime() +
					"| Turnaround Time: " + finishedJobs.get(j).getTurnAroundTime());
		}
		System.out.println("-----------");
		System.out.println("Average waiting time: " + (double)totalWaiting/size);
		
		return array;
	}
}
