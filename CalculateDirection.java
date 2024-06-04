import java.util.*;
  public class Main {
    public static int[] Location(String input) {
      String[] pairs = input.split(",");
      int x = 0;
      int y = 0;
      for (String pair : pairs) {
        char direction = pair.charAt(0);
        int distance = Integer.parseInt(pair.substring(1));
        if (direction == 'N') {
          y += distance;
        } else if (direction == 'S') {
          y -= distance;
        } else if (direction == 'W') {
          x -= distance;
        } else if (direction == 'E') {
          x += distance;
        }
      }
    return new int[]{x, y};
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    int[] finalLocation = Location(input);
    System.out.println("(" + finalLocation[0] + ", " + finalLocation[1] + ")");
  }
}
