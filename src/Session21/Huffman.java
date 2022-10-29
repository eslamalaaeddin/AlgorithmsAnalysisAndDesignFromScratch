package Session21;

import java.util.*;

public class Huffman {
    private static class Node {
        char data;
        int freq;
        Node left = null;
        Node right = null;

        public Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            if (data == 0)
                data = '*';
            return "{" +
                    data +
                    ", " + freq +
                    '}';
        }
    }

    private Map<Character, Integer> map;
    private final Map<Character, String> codesMap = new HashMap<>();
    private final Comparator<Node> nodeComparator = Comparator.comparingInt(node -> node.freq);
    private final PriorityQueue<Node> minHeap = new PriorityQueue<>(nodeComparator);

    public Huffman(String message) {
        map = getCharWithFreq(message);

        //Converting HashTable Into Priority Queue
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();

        for (Map.Entry<Character, Integer> entry : entries)
            minHeap.add(new Node(entry.getKey(), entry.getValue()));

        System.out.println(minHeap);
    }

    private void constructMap() {
        while (this.minHeap.size() >= 2) {
            Node firstItem = this.minHeap.poll();
            Node secondItem = this.minHeap.poll();
            Node result = new Node(firstItem.freq + secondItem.freq, firstItem, secondItem);
            this.minHeap.add(result);
            System.out.println(this.minHeap);
        }
    }

    private Map<Character, Integer> getCharWithFreq(String message) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }

    private void generateCode(Node node, String generatedCode){
        if (node == null) return;

        if (node.data != '*')
            codesMap.put(node.data, generatedCode);

        generateCode(node.left, generatedCode + "0");
        generateCode(node.right, generatedCode + "1");

    }

    public void generateCodeMap(){
        constructMap();
        System.out.println("------------Generated Code------------");
        Node root = minHeap.peek();
        generateCode(root, "");
        System.out.println(codesMap);
    }


}
