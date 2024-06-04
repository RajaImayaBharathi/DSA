import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int nums[]={1,3,-1,-3,5,3,6,7};
		int k = sc.nextInt();
		int size=nums.length;
		int answer[]=new int[size-k+1];
		for(int i=0; i<=size-k; i++){
		    int max=0;
		    for(int j=i;j<=i+(k-1);j++){
		       if(max<nums[j]){
		           max=nums[j];
		       }
		    }
		    answer[i]=max;
		}
		for(int n:answer){
		    System.out.print(n+" ");
		}
	}
}
