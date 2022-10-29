package Session22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //NOTE  fractions less than one are neglected
        System.out.println("Profit Weight Ratio...");
        // Creating Items and Sort Them
        List<Knapsack.Item> items = new ArrayList<>();
        items.add(new Knapsack.Item(1, 4));
        items.add(new Knapsack.Item(2, 9));
        items.add(new Knapsack.Item(10, 12));
        items.add(new Knapsack.Item(4, 11));
        items.add(new Knapsack.Item(3, 6));
        items.add(new Knapsack.Item(5, 5));

        System.out.println(items);

        items.sort(Comparator.comparingInt(o -> o.ratioPerKilo));
        Collections.reverse(items);

        System.out.println(items);

        // Knapsack Work
        Knapsack knapsack = new Knapsack();
        knapsack.knapsack(items, 12);
    }
}
