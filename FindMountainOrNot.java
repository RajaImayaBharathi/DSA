import java.util.*;
public class Main {
public static void main(String[] args) {
int[] arr1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
int[] arr2 = {1, 2, 3, 4, 5};
System.out.println("Is arr1 a mountain? " + isMountainArray(arr1));
System.out.println("Is arr2 a mountain? " + isMountainArray(arr2));
}
public static boolean isMountainArray(int[] arr) {
int n = arr.length;
int i = 0;
// Step 1: Find the peak
while (i + 1 < n && arr[i] < arr[i + 1]) {
i++;
}
// Step 2: Check if peak is not at the beginning or end
if (i == 0 || i == n - 1) {
return false;
}
// Step 3: Check increasing sequence
while (i + 1 < n && arr[i] > arr[i + 1]) {
i++;
}
// Step 4: If we reached the end, it's a mountain
return i == n - 1;
}
}
