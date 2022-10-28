package Session13;

public class Session13 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(array, 6, 0, array.length - 1));
        System.out.println(binarySearchIterative(array, 6));

    }

    static int binarySearchIterative(int[] array, int element) {
        int midPoint = 0;
        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            midPoint = (low + high) / 2;
            if (element == array[midPoint]) return midPoint;
            else if (element < array[midPoint]) high = midPoint - 1;
            else low = midPoint + 1;
        }


        return -1;
    }

    static int binarySearch(int[] array, int element, int startIndex, int endIndex) {
        if (endIndex < startIndex)
            return -1;

        int midPoint = (endIndex + startIndex) / 2;
        if (element == array[midPoint])
            return midPoint;
        if (element < array[midPoint])
            return binarySearch(array, element, startIndex, midPoint - 1);
        if (element > array[midPoint])
            return binarySearch(array, element, midPoint + 1, endIndex);

        return -1;
    }

}
