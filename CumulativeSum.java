import java.util.*;
public class Main {
    public static int sumof(int value){
        int sum=0;
        int SumResult=0;
        while(value>0){
            sum+=value%10;
            value/=10;
        }
        if(sum>9){
            while(sum>0){
                SumResult+=sum%10;
                sum/=10;
            }
            if(SumResult==10){
                SumResult=1;
            }
        }
        else{
            SumResult=sum;
        }
        System.out.print(SumResult+" ");
        return SumResult;
    }
    public static StringBuilder joining(int arr[], int size){
        StringBuilder sb= new StringBuilder();
        for(int item: arr){
            if(item%2==0){
                sb.append(item);
            }else if(item%2!=0){
                char character[]= {'a','a','b','c','d','e','f','g','h','i'};
                //0=a 1=a 2=b...till 9=i
                sb.append(character[item]);
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int arr[]= new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int arr1[]= new int[size];
        for(int i=0;i<size;i++){
            arr1[i]=sumof(arr[i]);
        }
        System.out.println(joining(arr1, size));
    }
}
