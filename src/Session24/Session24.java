package Session24;

import java.util.Arrays;

public class Session24 {

    public static void main(String[] args) {
        String string1 = "HELLOWORLD";
        String string2 = "OHELOD";
        System.out.println("String 1: " + string1);
        System.out.println("String 2: " + string2);
        lcs(string1.toCharArray(), string2.toCharArray());
    }

    private static void lcs(char[] horizontal, char[] vertical) {
        int lengthV = vertical.length + 1;
        int lengthH = horizontal.length + 1;

        int[][] table = new int[lengthV][lengthH]; // 7 X 11

        int topCell = 0;
        int leftCell = 0;
        int topLeftCell = 0;

        horizontal = " HELLOWORLD".toCharArray();
        vertical = " OHELOD".toCharArray();

        int row = 0;
        int col = 0;

        for (row = 1; row < lengthV; row++) {

            for (col = 1; col < lengthH; col++) {

                topCell = table[row - 1][col];
                leftCell = table[row][col - 1];
                topLeftCell = table[row - 1][col - 1];

                if (vertical[row] != horizontal[col]) {
                    table[row][col] = Math.max(topCell, leftCell);
                } else {
                    table[row][col] = topLeftCell + 1;
                }

            }
        }
        for (int[] arr : table) {
            System.out.println(Arrays.toString(arr));
        }


        row--;
        col--;
        StringBuilder solution = new StringBuilder();
        while (row > 0 && col > 0) {
            if (table[row][col] > table[row][col - 1]) { // if current > left
                if (table[row][col] == table[row - 1][col]) { // if current == top
                    row--;
                } else {
                    solution.append(vertical[row]);
                    row--;
                    col--;
                }
            } else {
                col--;
            }
        }

        System.out.println("\nSolution: " + solution.reverse().toString());

    }
}
