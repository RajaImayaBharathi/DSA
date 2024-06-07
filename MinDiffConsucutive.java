import java.util.*;
public class Main{
    public static int minimumDiff(int a, int b) {
        int result = a - b;
        result=result*-1;
        return result;
        
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int testcase = sc.nextInt();
        int size;
        int mindiff=1,result=0;
        for(int i=0;i<testcase;i++){
            size=sc.nextInt();
            int arr[]=new int[size];
            for(int j=0;j<size;j++){
                arr[j]=sc.nextInt();
            }
            for(int j=0;j<size-1;j++){
                result=minimumDiff(arr[j],arr[j+1]);
                if(result<mindiff){
                    mindiff=result;
                }  
            }
            System.out.println(mindiff);
        }
    }
}
