package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ParseFile {
	protected static Process[] parseFileArray(String fileName) throws IOException{
		
		InputStream in = Main.class.getResourceAsStream(fileName); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String nodes = null;
		
		Process[] jobs = new Process[5];
		int lineCount = 0;
		int burstTime;
		int priority;
		int processCount = 0;
		while((nodes=reader.readLine()) != null){
			
			if(lineCount == 0){
				for(int i = 0; i<nodes.length(); i++){
					if(nodes.charAt(i) == ' '){
						
					}else{
						Process p = new Process((i/2)+1, Character.getNumericValue(nodes.charAt(i)));
						jobs[i/2] = p;
					}
				}	
				lineCount++;
				continue;
			}
			if(lineCount == 1){
				burstTime = Character.getNumericValue(nodes.charAt(0));
				priority = Character.getNumericValue(nodes.charAt(2));
				jobs[processCount].setBurstTime(burstTime);
				jobs[processCount].setPriority(priority);
				processCount++;
				continue;
			}
		}
		reader.close();
		return jobs;
	}
	
	protected static ArrayList<Process> parseFileList(String fileName) throws IOException{
		/*
		FileInputStream fis = new FileInputStream(fileName);
		//FileReader input = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		//BufferedReader reader = new BufferedReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(fileName)));
		*/
		InputStream in = Main.class.getResourceAsStream(fileName); 
		//FileReader input = new FileReader(fileName);

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String nodes = null;
		
		Process[] jobs = new Process[5];
		int lineCount = 0;
		int burstTime;
		int priority;
		int processCount = 0;
		while((nodes=reader.readLine()) != null){
			
			if(lineCount == 0){
				for(int i = 0; i<nodes.length(); i++){
					if(nodes.charAt(i) == ' '){
						
					}else{
						Process p = new Process((i/2)+1, Character.getNumericValue(nodes.charAt(i)));
						jobs[i/2] = p;
					}
				}	
				lineCount++;
				continue;
			}
			if(lineCount == 1){
				burstTime = Character.getNumericValue(nodes.charAt(0));
				priority = Character.getNumericValue(nodes.charAt(2));
				jobs[processCount].setBurstTime(burstTime);
				jobs[processCount].setPriority(priority);
				jobs[processCount].setRemainingBurstTime(burstTime);
				processCount++;
				continue;
			}
		}
		reader.close();
		
		ArrayList<Process> jobList = new ArrayList<Process>();
		for(int i = 0; i < jobs.length; i++){
			jobList.add(jobs[i]);
		}
		
		return jobList;
	}

	protected static ArrayList<Process> parseFileRRList(String fileName) throws IOException{

		Process[] jobs = null;
		int processCount = 0;
		int lineCount = 0;
		int priority = 0;
		int burst = 0;
		int arrival = 0;
		int numOfProcess = 0;
		/*
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		FileInputStream fis = new FileInputStream(fileName);
		//FileReader input = new FileReader(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		//BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(fileName)));
		*/
		
		InputStream in = Main.class.getResourceAsStream(fileName); 
		//FileReader input = new FileReader(fileName);

		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String currLine;

		while ((currLine = br.readLine()) != null) {

			String[] strArr = currLine.split(" ");

			if(lineCount == 0){
				numOfProcess = Integer.parseInt(strArr[0]);
				lineCount++;
				jobs = new Process[numOfProcess];
				continue;
			}

			if(lineCount == 1){
				Process p = new Process();
				for(int j = 0; j < strArr.length; j++){
					if(j == 0){
						priority = Integer.parseInt(strArr[j]);
						p.setPriority(priority);
					}
					if(j == 1){
						burst = Integer.parseInt(strArr[j]);
						p.setBurstTime(burst);
						p.setRemainingBurstTime(burst);
					}
					if(j == 2){
						arrival = Integer.parseInt(strArr[j]);
						p.setArrivalTime(arrival);
					}
				}
				p.setProcessID(processCount+1);
				jobs[processCount] = p;
				processCount++;
			}
		}

		br.close();
		
		ArrayList<Process> jobList = new ArrayList<Process>();
		for(int i = 0; i < jobs.length; i++){
			jobList.add(jobs[i]);
		}
		return jobList;
	}
	
	protected static ArrayList<BankerProcess> parseFileBankers(String fileName) throws IOException{

		ArrayList<BankerProcess> list = new ArrayList<BankerProcess>();
		int processCount = 0;
		int lineCount = 0;
		int requestingProcess = 0;
		/*
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		FileInputStream fis = new FileInputStream(fileName);
		//FileReader input = new FileReader(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		//BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream(fileName)));
		*/
		InputStream in = Main.class.getResourceAsStream(fileName); 
		//FileReader input = new FileReader(fileName);

		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		
		String currLine;

		while ((currLine = br.readLine()) != null) {

			String[] strArr = currLine.split(" ");

			if(lineCount == 0){
				Resources available = new Resources();
				for(int j = 0; j < strArr.length; j++){
					if(j == 0){ available.setA(Integer.parseInt(strArr[j])); }
					if(j == 1){ available.setB(Integer.parseInt(strArr[j])); }
					if(j == 2){ available.setC(Integer.parseInt(strArr[j])); }
					if(j == 3){ available.setD(Integer.parseInt(strArr[j])); }
				}
				BankerProcess availableTemp = new BankerProcess(0, available, new Resources());
				list.add(availableTemp);
				lineCount++;
				continue;
			}
			if(lineCount == 1){
				if(processCount == 5){
					lineCount++;
					continue;
				}
				Resources allocated = new Resources();
				Resources max = new Resources();
				for(int j = 0; j < strArr.length; j++){
					if(j == 0){ allocated.setA(Integer.parseInt(strArr[j])); }
					if(j == 1){ allocated.setB(Integer.parseInt(strArr[j])); }
					if(j == 2){ allocated.setC(Integer.parseInt(strArr[j])); }
					if(j == 3){ allocated.setD(Integer.parseInt(strArr[j])); }
					if(j == 4){ max.setA(Integer.parseInt(strArr[j])); }
					if(j == 5){ max.setB(Integer.parseInt(strArr[j])); }
					if(j == 6){ max.setC(Integer.parseInt(strArr[j])); }
					if(j == 7){ max.setD(Integer.parseInt(strArr[j])); }
				}
				processCount++;
				BankerProcess p = new BankerProcess(processCount, allocated, max);
				list.add(p);
			}else{
				Resources requested = new Resources();
				for(int j = 0; j < strArr.length; j++){
					if(j == 0){ requestingProcess = Integer.parseInt(strArr[j]); }
					if(j == 1){ requested.setA(Integer.parseInt(strArr[j])); }
					if(j == 2){ requested.setB(Integer.parseInt(strArr[j])); }
					if(j == 3){ requested.setC(Integer.parseInt(strArr[j])); }
					if(j == 4){ requested.setD(Integer.parseInt(strArr[j])); }
				}
				BankerProcess p = new BankerProcess(requestingProcess, requested, new Resources());
				
				list.add(p);
			}
		}
		br.close();
		return list;
	}

}
