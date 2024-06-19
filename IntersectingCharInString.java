import java.util.*;
public class Main{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String J = sc.nextLine();
String S = sc.nextLine();
Set<Character> jewelSet = new HashSet<>();
for (char c : J.toCharArray()) {
jewelSet.add(c);
}
int count = 0;
for (char c : S.toCharArray()) {
if (jewelSet.contains(c)) 
count++;
}
System.out.println(count);
}
}
