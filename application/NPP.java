package application;

public class NPP {

	protected static Process[] sort(Process[] array){
		
		Process temp;
		
		boolean sorting = true;
		
		while(sorting){
			
			sorting = false;
			
			for(int i = 0; i <array.length-1; i++){
				if(array[i].getPriority() < array[i+1].getPriority()){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1]=temp;
					sorting=true;
				}
				if(array[i].getPriority() == array[i+1].getPriority()){
					if(array[i].getArrivalTime() > array[i+1].getArrivalTime()){
						temp = array[i];
						array[i] = array[i+1];
						array[i+1]=temp;
						sorting=true;
					}
				}
			}
		}
		return array;
	}
}
