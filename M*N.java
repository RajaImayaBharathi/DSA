import java.util.*;
public class Main{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
String input= sc.nextLine();
String[] rows = input.substring(2, input.length() - 2).split("\\},\\{");
for(String item: rows){
String Char[]=item.split(",");
for(String n:Char){
System.out.print(n+" ");
}
System.out.println();
}
}
}
