package Session23;

import java.util.ArrayList;
import java.util.List;

public class Session23 {
    static class State {
        char from;
        char to;
        int cost;

        public State(char from, char to, int cost) {
            this.from = from;
            this.to =to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "from " + from + " to " + to + " cost = " + cost;
        }
    }

    static char[] labels = "ABCDEFGHIJ".toCharArray();
    static int[][] costs = {
            {0, 2, 4, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 7, 4, 6, 0, 0, 0},
            {0, 0, 0, 0, 3, 2, 4, 0, 0, 0},
            {0, 0, 0, 0, 4, 1, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 3, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    static int dataLength = costs.length;
    static State[] states = new State[dataLength]; // States == Nodes

    public static void main(String[] args) {
        states[dataLength - 1] = new State('*', '*', 0);
        int rowIndex;
        int colIndex;
        int newCost;

        //Loop over all rows starting from the second row from the end
        for (rowIndex = dataLength - 2; rowIndex >= 0; rowIndex--) {
            //at index 8 i will calculate for node I
            states[rowIndex] = new State(labels[rowIndex], ' ', Integer.MAX_VALUE);

            /*loop over the current column
             *if cost from current rowNode to colNode is 0, Skip it
             *else calculate tempCost = cost from rowNode to colNode +
             * smallest cost to reach the goal .. this -> {states[colIndex].cost}
             */

            for (colIndex = rowIndex + 1; colIndex < dataLength; colIndex++) {
                if (costs[rowIndex][colIndex] == 0) continue;
                newCost = costs[rowIndex][colIndex] + states[colIndex].cost; // 4, 8
                //TODO Look at the TODO picture
                if (newCost < states[rowIndex].cost) {
                    states[rowIndex].to = labels[colIndex];
                    states[rowIndex].cost = newCost;
                }
            }
        }

        for (State state : states)
            System.out.println(state);

        //Constructing the shortest path
        List<Character> path = new ArrayList<>();
        path.add('A');
        rowIndex = 0;
        colIndex = 0;
        while (rowIndex < states.length) {
            if (states[rowIndex].from == path.get(colIndex)) {
                path.add(colIndex + 1, states[rowIndex].to);
                colIndex++;
            }
            rowIndex++;
        }
        System.out.println("Min Path: " + path + "\nCost: " + states[0].cost);
    }

}
