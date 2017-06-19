package application;

import java.util.ArrayList;

public class Bankers {
	
	public static void sort(ArrayList<BankerProcess> array){
		
		Resources available = array.get(0).getAllocated();
		array.remove(0);
		
		ArrayList<Resources> requests = new ArrayList<Resources>();
		while(array.size() > 5){
			Resources request = array.get(5).getAllocated();
			request.setResourceID(array.get(5).getID());
			requests.add(request);
			array.remove(5);
		}
		
		for(int i = 0; i < array.size(); i++){
			System.out.println(array.get(i).print() + "| Need: " + array.get(i).getNeeded().print());
		}
		System.out.println("--Potential Order--");
		
		if(determineSystem(array, available)){
			System.out.println("The system is in a safe state.");
		}else{
			System.out.println("The system can not be resolved.");
		}
		
		System.out.println("-------------------");
		
		determineRequest(requests, available);

		System.out.println("-------------------");
	}

	private static void determineRequest(ArrayList<Resources> requests, Resources available){
		
		while(!requests.isEmpty()){
		
			for(int i = 0; i < requests.size(); i++){
				
				//if allocated is larger or equal to needed
				Resources needed = requests.get(i);
				int requestingID = needed.getResourceID();
				
				if(needed.isComparedTo(available)){
					System.out.println("Process #" + requestingID + "'s request can be granted.");
					requests.remove(i);
				}else{
					System.out.println("Process #" + requestingID + "'s request can not be granted.");
					requests.remove(i);
				}
			}
		}
	}
	
	private static boolean determineSystem(ArrayList<BankerProcess> array, Resources available) {
		
		while(!array.isEmpty()){
			for(int i = 0; i < array.size(); i++){
				
				//if allocated is larger or equal to needed
				Resources needed = array.get(i).getNeeded();
				
				if(needed.isComparedTo(available)){
					System.out.println(array.get(i).getID() + " can be processed.");
					available = array.get(i).releaseResources(available);
					array.remove(i);
				}else{
					return false;
				}
			}
		}
		System.out.println("-------------------");
		return true;
	}
}
