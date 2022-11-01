package Session25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session25 {
    static class Item {
        String name;
        int weight;
        int profit;


        public Item(String name, int weight, int profit) {
            this.name = name;
            this.weight = weight;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return name + ", " + weight + ", " + profit;
        }
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("#0", 0, 0),
                new Item("#1", 1, 4),
                new Item("#2", 3, 9),
                new Item("#3", 5, 12),
                new Item("#4", 4, 11),
        };


        int maxWeight = 8;
        int noRows = items.length;
        int noCols = maxWeight + 1;

        int[][] table = new int[noRows][noCols];

        int row = 0;
        int col = 0;


        for (row = 1; row < noRows; row++) {
            for (col = 1; col < noCols; col++) {
                // [col] represents current stage weight AND the index used to represent columns in table
                if (items[row].weight <= col) {
                    table[row][col] = Math.max(items[row].profit + table[row - 1][col - items[row].weight], table[row - 1][col]);
                } else {
                    table[row][col] = table[row - 1][col];
                }
            }
        }

        for (int[] t : table)
            System.out.println(Arrays.toString(t));

        System.out.println("\nMax Profit: " + table[row - 1][col - 1]);

        row--;
        col--;

        //To print the solution
        int remain = maxWeight;
        List<Item> solutionItems = new ArrayList<>();

        while (remain >= 0 && col > 0) {
            if (table[row][col] > table[row - 1][col]) {
                solutionItems.add(items[row]);
                remain -= items[row].weight;
                col = remain;
            }
            row--;

        }
        System.out.println(solutionItems);

    }
}
