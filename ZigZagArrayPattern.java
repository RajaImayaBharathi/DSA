import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int[] array = new int[size];
        for(int i=0;i<size;i++){
            array[i]=sc.nextInt();
        }
        int[] zigzagArray = convertToZigzag(array);
        System.out.println(Arrays.toString(zigzagArray));
    }

    public static int[] convertToZigzag(int[] array) {
        Arrays.sort(array);
        int n = array.length;
        for (int i = 1; i < n - 1; i += 2) {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
        return array;
    }
}
