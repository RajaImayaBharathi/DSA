import java.util.*;
public class Main{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String input= sc.nextLine();
int length= input.length();
String firstPart = input.substring(0,length/2);
String secondPart = input.substring(length/2);
String result= secondPart+firstPart;
for(int i=0;i<length;i++){
for(int j=0;j<=i;j++)
System.out.print(result.charAt(j));
System.out.println();
}
}
}
