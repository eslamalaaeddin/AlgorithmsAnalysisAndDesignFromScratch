package Session27;

public class Session27 {
    public static void main(String[] args) {
        primMST();
    }
    static void primMST() {
        char[] labels = "123456".toCharArray();
        double[][] cost = {
                {0, 6.7, 5.2, 2.8, 5.6, 3.6},
                {6.7, 0, 5.7, 7.3, 5.1, 3.2},
                {5.2, 5.7, 0, 3.4, 8.5, 4.0},
                {2.8, 7.3, 3.4, 0, 8.0, 4.0},
                {5.6, 5.1, 5.5, 8.0, 0, 4.6},
                {3.6, 3.2, 4.0, 4.4, 4.6, 0}
        };
        double totalCost = 0.0;
        int noVertices = 6;

        int selectedEdgesCount = 0;
        boolean[] selected = new boolean[noVertices];
        selected[0] = true; // arbitray select a vertics

        while (selectedEdgesCount < noVertices - 1) {
            double min = Double.MAX_VALUE;
            int tempTo = -1;
            int tempFrom = -1;

            for (int row = 0; row < noVertices; row++) {
                if (selected[row]) {
                    for (int col = 0; col < noVertices; col++) {
                        if (!selected[col] && cost[row][col] > 0 && cost[row][col] < min) {
                            min = cost[row][col];
                            tempFrom = row;
                            tempTo = col;
                        }
                    }
                }
            }
            selected[tempTo] = true;
            selectedEdgesCount++;
            totalCost += cost[tempFrom][tempTo];
            System.out.println("From: " + labels[tempFrom] + " To: " + labels[tempTo] + " Cost: " + cost[tempFrom][tempTo]);
        }
        System.out.println("Total Cost: " + totalCost);
    }

}
