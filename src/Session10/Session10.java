package Session10;

import java.util.Arrays;

public class Session10 {
    public static void main(String[] args) {
        int[] array = {9, 5, 1, 4};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int[] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex)
            return;

        int midPoint = (startIndex + endIndex) / 2;
        mergeSort(array, startIndex, midPoint);
        mergeSort(array, midPoint + 1, endIndex);
        merge(array, startIndex, midPoint, endIndex);

    }

    static void merge(int[] array, int startIndex, int midPoint, int endIndex) {
        int[] leftArray = new int[midPoint - startIndex + 1];
        int[] rightArray = new int[endIndex - midPoint];

        int i = 0;
        int j = 0;
        // It has to start from start index not 0 why ? because
        int k = startIndex;


        for (i = 0; i < leftArray.length; i++)
            leftArray[i] = array[startIndex + i]; // if start index = 0 then array[i]

        for (j = 0; j < rightArray.length; j++)
            rightArray[j] = array[midPoint + 1 + j];

        i = 0;
        j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        while (i < leftArray.length)
            array[k++] = leftArray[i++];

        while (j < rightArray.length)
            array[k++] = rightArray[j++];


    }
}
