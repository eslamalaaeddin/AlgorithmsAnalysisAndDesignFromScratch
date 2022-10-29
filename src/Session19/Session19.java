package Session19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Session19 {
    public static void main(String[] args) {
        String word = "aaaabbbccd";
        char[] wordArray = word.toCharArray();
        //getFreq(word);

//		ascii(wordArray);
        Map<Character, Integer> map = getFreqWithMap(word);
        System.out.println(map);

        int[][] arrayFromMap = convertMapToArray(map);

        for (int[] arr : arrayFromMap)
            System.out.println(Arrays.toString(arr));

        System.out.println("-----Sorted Map-----");
        mergeSortHash(arrayFromMap, 0, arrayFromMap.length - 1);

        for (int[] arr : arrayFromMap)
            System.out.println(Arrays.toString(arr));
    }

    static Map getFreqWithMap(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map;
    }

    static int[][] convertMapToArray(Map<Character, Integer> map) {
        int[][] array = new int[map.size()][2];
        int i = 0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            array[i][0] = entry.getKey();
            array[i][1] = entry.getValue();
            i++;
        }
        return array;
    }


    static void getFreqAscii(char[] word) {
        int[] freq = new int[127];
        for (int i = 0; i < word.length; i++) {
            freq[word[i]]++;
        }
        print(word, freq);
    }

    static void mergeSortHash(int[][] array, int startIndex, int endIndex) {
        if (endIndex <= startIndex)
            return;

        int midPoint = (startIndex + endIndex) / 2;
        mergeSortHash(array, startIndex, midPoint);
        mergeSortHash(array, midPoint + 1, endIndex);
        mergeHash(array, startIndex, midPoint, endIndex);

    }

    static void mergeHash(int[][] array, int startIndex, int midPoint, int endIndex) {
        int[][] leftArray = new int[midPoint - startIndex + 1][2];
        int[][] rightArray = new int[endIndex - midPoint][2];

        int i = 0;
        int j = 0;
        // It has to start from start index not 0 why ? because
        int k = startIndex;


        for (i = 0; i < leftArray.length; i++) {
            leftArray[i][0] = array[startIndex + i][0]; // if start index = 0 then array[i]
            leftArray[i][1] = array[startIndex + i][1]; // if start index = 0 then array[i]

        }


        for (j = 0; j < rightArray.length; j++) {
            rightArray[j][0] = array[midPoint + 1 + j][0];
            rightArray[j][1] = array[midPoint + 1 + j][1];
        }


        i = 0;
        j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i][1] <= rightArray[j][1])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        while (i < leftArray.length)
            array[k++] = leftArray[i++];

        while (j < rightArray.length)
            array[k++] = rightArray[j++];


    }


    private static void print(char[] word, int[] freq) {
        for (int i = 0; i < word.length; i++) {
            System.out.println(word[i] + " : " + freq[word[i]]);
        }

    }

    static void getFreq(char[] word) {
        int[] freq = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            freq[i] = countTimes(word[i], word);
        }
        System.out.println(Arrays.toString(word));
        System.out.println(Arrays.toString(freq));
    }

    private static int countTimes(char c, char[] word) {
        int count = 0;
        for (char ch : word) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

}
