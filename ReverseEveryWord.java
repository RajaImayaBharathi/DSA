import java.util.*;
public class Main{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String input=sc.nextLine();
String arr[]=input.split(" ");
for(String item: arr){
String reverse= new StringBuilder(item).reverse().toString();
System.out.print(reverse+" ");
}
}
}
