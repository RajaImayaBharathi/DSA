import java.util.*;
public class Main{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    List<Integer> l1= new ArrayList<>();
	    List<Integer> l2= new ArrayList<>();
	    int l1Size=sc.nextInt();
	    int l2Size=sc.nextInt();
	    for(int i=0;i<l1Size;i++){
	        l1.add(sc.nextInt());
	    }    
	    for(int i=0;i<l2Size;i++){
	        l2.add(sc.nextInt());
	    }    
	    List<Integer> intersection= new ArrayList<>(l1);
	    intersection.retainAll(l2);
		for(int item: intersection)
		    System.out.print(item+" ");
	}
}
