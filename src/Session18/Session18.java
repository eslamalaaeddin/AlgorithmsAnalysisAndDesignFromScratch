package Session18;

import java.util.Arrays;


public class Session18 {
    public static void main(String[] args) {
        int[] start = {9, 10, 11, 12, 13, 15};
        int[] end = {11, 11, 12, 14, 15, 16};

        activitySelectionProblem(start, end);

    }
    static void activitySelectionProblem(int start[], int end[]) {
        int i;
        int j = 0;
        int k = 0;
        int[] solution = new int[start.length];
        solution[k++] = 0;
        for (i = 1; i < start.length; i++) {
            if (start[i] >= end[j]) {
                solution[k++] = i;
                j = i;
            }
        }
        System.out.println(Arrays.toString(solution));
    }


}
