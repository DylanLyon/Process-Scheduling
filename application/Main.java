package application;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main (String args[]) throws IOException{
		
		//id, burst, priority, arrival
		//FCFS
		Process[] firstJobs = ParseFile.parseFileArray("/input/input1.txt");
		Process[] FCFSjobs = FCFS.sort(firstJobs);

		System.out.println("----------------------");
		System.out.println("First Come First Serve");
		System.out.println("----------------------");
		Stats.display(FCFSjobs);
		System.out.println("----------------------");
		System.out.println();
		
		
		//SJF
		Process[] shorestJobs = ParseFile.parseFileArray("/input/input1.txt");
		Process[] SJFjobs = SJF.sort(shorestJobs);
		System.out.println("------------------");
		System.out.println("Shortest Job First");
		System.out.println("------------------");
		Stats.display(SJFjobs);
		System.out.println("------------------");
		System.out.println();
		
		
		//NPRR
		Process[] nonPreemptivePriorityJobs = ParseFile.parseFileArray("/input/input1.txt");
		Process[] NPPjobs = NPP.sort(nonPreemptivePriorityJobs);
		
		System.out.println("----------------------");
		System.out.println("Nonpreemptive Priority");
		System.out.println("----------------------");
		Stats.display(NPPjobs);
		System.out.println("----------------------");
		System.out.println();
		
		
		
		//RR
		System.out.println("-----------");
		System.out.println("Round Robin");
		System.out.println("-----------");	
		ArrayList<Process> RRJobs = ParseFile.parseFileList("/input/input1.txt");
		NPRR.sort(RRJobs);
		System.out.println("-----------");
		System.out.println();
		
		
		
		//PRR
		
		System.out.println("----------------------");
		System.out.println("Preemptive Round Robin");
		System.out.println("----------------------");
		ArrayList<Process> PRRJobs = ParseFile.parseFileRRList("/input/input2.txt");
		PRR.sort(PRRJobs);
		System.out.println("----------------------");
		System.out.println();
		
		
		//Bankers

		System.out.println("Banker's Algorithm");
		System.out.println("-------------------");
		ArrayList<BankerProcess> bankerJobs1 = ParseFile.parseFileBankers("/input/input3.txt");
		Bankers.sort(bankerJobs1);
		
		System.out.println();
		System.out.println();
		
		ArrayList<BankerProcess> bankerJobs2 = ParseFile.parseFileBankers("/input/input4.txt");
		Bankers.sort(bankerJobs2);
		
		
	}
	//static class ParseFile{
		
	//}
		
		
}
