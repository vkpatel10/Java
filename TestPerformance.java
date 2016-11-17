import java.util.*;
public class TestPerformance{
	public static void main(String args[]){
		List <String>aList = new ArrayList<String>();	
		List <String>lList = new LinkedList<String>();
		int sec;
		sec = list(aList);
		System.out.println("Total seconds required in arrayList: " + sec);
		sec = list(lList);
		System.out.println("Total seconds required in linkedList: " + sec);
	}
	
	public static void print(List <String> list){
		for(int i=0 ; i<list.size() ; i++){
			System.out.println(list.get(i));
		}
	}
	
	public static int list(List <String>aList){
		long start,end;
		start = System.currentTimeMillis();
		
		for(int i=0 ; i<50000 ; i++){
			aList.add("RCC " + i);
		}
		print(aList);
		end = System.currentTimeMillis();
		
		return((int)(end-start)/1000);
	}
}