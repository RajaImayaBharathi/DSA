import java.util.*;
public class Main{
public static String leftRotate(String input, int size, int rotateCount){
String arr[] = input.split("");
//System.arraycopy(array, 0, arr, 0, arr.length);
for(int i=0;i<rotateCount;i++){
String first= arr[0];
for(int j=0;j<size-1;j++){
arr[j]=arr[j+1];
}
arr[size-1]=first;
}
StringBuilder sb = new StringBuilder();
for (int i = 0; i < size; i++) {
sb.append(arr[i]);
}
String leftString = sb.toString();
return leftString;
}
public static String rightRotate(String input, int size, int rotateCount){
String arr[] = input.split("");
//System.arraycopy(array, 0, arr, 0, arr.length);
for(int i=0;i<rotateCount;i++){
String last= arr[size-1];
for(int j=size-1;j>0;j--){
arr[j]=arr[j-1];
}
arr[0]=last;
}
StringBuilder sb = new StringBuilder();
for (int i = 0; i < size; i++) {
sb.append(arr[i]);
}
String rigthString = sb.toString();
return rigthString;
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String input=sc.nextLine();
int rotateCount=sc.nextInt();
int size= input.length();
rotateCount%=size;
System.out.println("Left Rotation:\""+leftRotate(input,size,rotateCount)+"\"");
System.out.println("Right Rotation:\"" +rightRotate(input,size,rotateCount)+"\"");
}
}
