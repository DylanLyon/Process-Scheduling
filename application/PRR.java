package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class PRR {

	private static int time = 0;
	private static int idleTime = 0;
	
	private static ArrayList<Process> add(ArrayList<Process> array) {
	
		ArrayList<Process> ready = new ArrayList<Process>();
		
		for(int i = 0; i < array.size(); i++){
			
			if(array.get(i).getArrivalTime() <= time){
				ready.add(array.get(i));
			}
		}
		Collections.sort(ready);
		
		return ready;
	}
	
	protected static void sort(ArrayList<Process> array){

		int quantum = 10;
		ArrayList<Process> waiting = array;

		ArrayList<Process> ready = PRR.add(waiting);

		ArrayList<Process> finished = new ArrayList<Process>();

		boolean processing = true;

		while(processing){

			while(!ready.isEmpty()){

				if(ready.get(0).getRemainingBurstTime() <= quantum){

					time += ready.get(0).getRemainingBurstTime();

					System.out.println("Process #" + ready.get(0).getProcessID() + " has received " + ready.get(0).getRemainingBurstTime() + " seconds of computation and is now completed. Current time: " + time);

					for(int i = 0; i < ready.size(); i++){
						ready.get(i).setWaitingTime(ready.get(i).getWaitingTime()+ready.get(0).getRemainingBurstTime());
					}

					ready.get(0).setTimesRan(ready.get(0).getTimesRan()+1);
					ready.get(0).setCompletedTime(time);
					finished.add(ready.get(0));
					waiting.remove(0);
					ready.remove(0);
				}
				else{
					ready.get(0).setRemainingBurstTime(ready.get(0).getRemainingBurstTime()-quantum);
					time+=quantum;
					ready.get(0).setTimesRan(ready.get(0).getTimesRan()+1);
					System.out.println("Process #" + ready.get(0).getProcessID() + " has received " + quantum + " seconds of computation. Current time: " + time);

					//for(int i = 0; i < ready.size(); i++){
					//	ready.get(i).setWaitingTime(ready.get(i).getWaitingTime()+quantum);
					//}
					ready = PRR.add(waiting);
				}
			}

			while(ready.isEmpty() && !waiting.isEmpty()){
				System.out.println("System Idle at time: " + time);
				idleTime++;
				time++;
				ready = PRR.add(waiting);
			}

			if(waiting.isEmpty()){
				processing = false;
			}
		}
		System.out.println("----------------------");
		double util = (double)(time - idleTime)/time;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		System.out.println("CPU utilization rate: " + numberFormat.format(util*100) + "%");
		System.out.println("----------------------");
		for(int i = 0; i < finished.size(); i++){
			System.out.println(finished.get(i).print() + 
					"| Arrival Order: " + finished.get(i).getArrivalOrder() + 
					"| Waiting Time: " + ( finished.get(i).getCompletedTime()-(quantum*finished.get(i).getTimesRan())) +
					"| Turnaround Time: " + finished.get(i).getTurnAroundTime() +
					"| Completed Time: " + finished.get(i).getCompletedTime());
		}
	}
}


