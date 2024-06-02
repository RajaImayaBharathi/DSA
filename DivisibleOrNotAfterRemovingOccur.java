import java.util.*;
public class Main {
public static void main(String[] args) {
Scanner sc= new Scanner(System.in);
int number =sc.nextInt();
int digitToRemove = sc.nextInt();
String numberStr = String.valueOf(number);
String digitStr = String.valueOf(digitToRemove);
String resultStr = numberStr.replaceAll(digitStr, "");
int resultNumber;
if (resultStr.isEmpty()) {
resultNumber = 0;
} else {
resultNumber = Integer.parseInt(resultStr);
}
if(resultNumber % digitToRemove == 0){
System.out.println("Divisible");
}else{
System.out.println("Not Divisible");
}
}
