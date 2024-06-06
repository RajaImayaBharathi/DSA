import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int rotationCount = sc.nextInt();
        rotationCount %=size;
        for(int i=0;i<rotationCount;i++){
            int last=arr[size-1];
            for(int j=size-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=last;
        }
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
