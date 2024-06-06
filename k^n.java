import java.util.*;
public class Main{
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int K= sc.nextInt();
        int result=1;
        for(int i=0;i<N;i++){
            result=result*K;
        }
        result%=10;
        System.out.println("result :" + result);
	}
}
