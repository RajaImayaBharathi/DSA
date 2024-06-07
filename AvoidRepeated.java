import java.util.*;
public class Main{
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    LinkedHashSet<String> lh= new LinkedHashSet<>(); 
	    String input=sc.nextLine();
	    String arr[]=input.split("");
	    for(String item:arr ){
	        lh.add(item);
	    }

	    //Linked hashList doesNot Allow duplicate values

	    for(String n: lh){
	        System.out.print(n);
	    }
	}
}
