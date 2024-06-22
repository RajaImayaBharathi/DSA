import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
public class Main{
    private static double getMaxValue(int W, Item[] items, int n) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });
        double totalValue = 0.0;
        for (Item item : items) {
            if (W == 0) {
                break;
            }
            if (item.weight <= W) {
                W -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) W / item.weight);
                W = 0;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int W = 50;
        int n = items.length;
        System.out.println("Maximum value that can be obtained: " + getMaxValue(W, items, n));
    }
}
