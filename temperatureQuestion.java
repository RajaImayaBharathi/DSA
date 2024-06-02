import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        int temp[]= new int[size];
        for(int i=0;i<size;i++){
            temp[i]=sc.nextInt();
        }
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            int daysToWait = 0;
            boolean foundWarmerTemp = false;
            
            for (int j = i + 1; j < size; j++) {
                if (temp[j] > temp[i]) {
                    daysToWait = j - i;
                    foundWarmerTemp = true;
                    break;
                }
            }
            
            if (foundWarmerTemp) {
                answer[i] = daysToWait;
            } else {
                answer[i] = 0;
            }
        }

        for (int index : answer) {
            System.out.print(index + " ");
        }
    }
}
