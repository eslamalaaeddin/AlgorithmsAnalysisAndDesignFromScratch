package Session9;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Session9 {
    public static void main(String[] args) {
        int[] array = {9, 5, 1, 4};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void insertionSort(int[] array) {
        int key, j = 0;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0) {
                if (array[j] > key) array[j + 1] = array[j];
                else break;
                j--;
            }

            array[j + 1] = key;
        }
    }
}
