package application;

public class FCFS {
	
	protected static Process[] sort(Process[] array){
		
		Process temp;
		
		boolean sorting = true;
		
		while(sorting){
			
			sorting = false;
			
			for(int i = 0; i <array.length-1; i++){
				if(array[i].getArrivalOrder() > array[i+1].getArrivalOrder()){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1]=temp;
					sorting=true;
				}
			}
		}
		return array;
	}
}
