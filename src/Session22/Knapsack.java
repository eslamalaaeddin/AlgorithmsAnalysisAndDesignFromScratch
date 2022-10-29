package Session22;

import java.util.*;

public class Knapsack {
    static class Item {
        int weight;
        int profit;
        int ratioPerKilo;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
            ratioPerKilo = profit / weight;
        }

        @Override
        public String toString() {
            return "(" + profit + ", " + weight + ", " + ratioPerKilo + ")";
        }


    }

    private final List<Item> knapsack = new ArrayList<>();

    public void knapsack(List<Item> items, int knapsackCapacity) {
        int knapsackSize = 0;
        int maxProfit = 0;
        int noItems = 0;
        int noSubItems = 0;

        for (Item item : items) {
            if (knapsackSize < knapsackCapacity) {
                // Take whole item if it fits
                if (knapsackCapacity - knapsackSize > item.weight) {
                    knapsack.add(item);
                    knapsackSize += item.weight;
                    maxProfit += item.profit;
                    noItems++;
                }
                // Take sub item
                else {
                    int subItemWeight = 0;
                    noSubItems++;
                    for (int j = 0; j < item.weight; j++) {
                        subItemWeight += 1;
                        if (knapsackCapacity - knapsackSize == subItemWeight) {
                            knapsack.add(new Item(subItemWeight, subItemWeight * item.ratioPerKilo));
                            knapsackSize += subItemWeight;
                            maxProfit += subItemWeight * item.ratioPerKilo;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(knapsack);
        System.out.println("-----Summary-----");
        System.out.println("Max Profit: " + maxProfit + " From " + noItems + " Items and " + noSubItems + " Sub items");

    }

}
