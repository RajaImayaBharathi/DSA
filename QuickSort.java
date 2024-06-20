import java.util.*;
public class Main {
  private static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
  private static int partition(int[] arr, int low, int high) {
      int pivot = arr[high];
      int i = low - 1;
      for (int j = low; j < high; j++) {
          if (arr[j] < pivot) {
              i++;
              swap(arr, i, j);
          }
      }
      swap(arr, i + 1, high);
      return i + 1;
  }
  public static void quickSort(int[] arr, int low, int high) {
      if (low < high) {
          int pi = partition(arr, low, high);
          quickSort(arr, low, pi - 1);
          quickSort(arr, pi + 1, high);
      }
  }
  public static void printArray(int[] arr) {
      for (int num : arr) {
          System.out.print(num + " ");
      }
      System.out.println();
  }
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
      }
      System.out.println("Unsorted array:");
      printArray(arr);
      quickSort(arr, 0, n - 1);
      System.out.println("Sorted array:");
      printArray(arr);
  }
}
