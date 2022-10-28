package Session15;

import java.util.Arrays;

public class Session15 {
    public static void main(String[] args) {
        int[] array = {-2, 5, 1, -6, 2, 10, -8, 9};
        System.out.println(Arrays.toString(array));
        segregateSimple(array);

    }

    static void segregateSimple(int[] array) {
        int[] result = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                result[j++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                result[j++] = array[i];
            }
        }

        System.out.println(Arrays.toString(result));
    }

    static void segregate(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex)
            return;

        int midPoint = (startIndex + endIndex) / 2;
        segregate(array, startIndex, midPoint);
        segregate(array, midPoint + 1, endIndex);
        mergeSegregate(array, startIndex, midPoint, endIndex);

    }

    static void mergeSegregate(int[] array, int startIndex, int midPoint, int endIndex) {
        int[] leftArray = new int[midPoint - startIndex + 1];
        int[] rightArray = new int[endIndex - midPoint];

        int i;
        int j;
        // It has to start from start index not 0 why ? because
        int k = startIndex;


        for (i = 0; i < leftArray.length; i++)
            leftArray[i] = array[startIndex + i]; // if start index = 0 then array[i]

        for (j = 0; j < rightArray.length; j++)
            rightArray[j] = array[midPoint + 1 + j];

        System.out.println(Arrays.toString(leftArray));
        System.out.println(Arrays.toString(rightArray));

        i = 0;
        j = 0;


        while (i < leftArray.length && leftArray[i] <= 0) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length && rightArray[j] <= 0) {
            array[k++] = rightArray[j++];
        }


        while (i < leftArray.length)
            array[k++] = leftArray[i++];

        while (j < rightArray.length)
            array[k++] = rightArray[j++];


    }

}
