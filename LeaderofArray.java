import java.util.*;
public class Main{
    public static int finding(int arr[],int key,int index){
        int size=arr.length;
        for(int i=index;i<size;i++){
            if(key>=arr[i]){
                continue;
            }
            else{
                return -1;
            }
        }
        return key;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int arr[]= new int[size];
		for(int i=0;i<size;i++){
		    arr[i]=sc.nextInt();
		}
		
		List<Integer> arrayList=new ArrayList<>();
		for(int i=0;i<size;i++){
		    int result=finding(arr,arr[i],i);
		    if(result>0){
		        arrayList.add(result);
		    }
		}
		for(int item: arrayList){
		    System.out.print(item+" ");
		}
	}
}
