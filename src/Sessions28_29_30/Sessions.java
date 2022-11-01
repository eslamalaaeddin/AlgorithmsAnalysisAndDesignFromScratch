package Sessions28_29_30;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sessions {
    public static void main(String[] args) {
        BFSV1();
        BFSAndDFS();
        dijkstra();
    }


    //First Version Of BFS
    static void BFSV1() {
        System.out.println("First Version Of BFS...");
        int noVertices = 9;

        Map<Character, Character[]> graph = new HashMap<>(noVertices);
        graph.put('A', new Character[]{'B', 'C'});
        graph.put('B', new Character[]{'E', 'D', 'A'});
        graph.put('C', new Character[]{'D', 'F', 'A'});
        graph.put('D', new Character[]{'E', 'F', 'B'});
        graph.put('E', new Character[]{'F', 'B'});
        graph.put('F', new Character[]{'D', 'E', 'C', 'H'});
        graph.put('G', new Character[]{'H', 'I'});
        graph.put('H', new Character[]{'G', 'I', 'F'});
        graph.put('I', new Character[]{'G', 'H'});

        Queue<Character> queue = new PriorityQueue<>(noVertices); // Priority Queue is sufficient for a FIFO operation
        Map<Character, Boolean> visitedVerticesMap = new HashMap<>(noVertices);

        queue.add('A');
        visitedVerticesMap.put('A', true);


        char currentVertics;
        Character[] destinationVertices;

        while (!queue.isEmpty()) {
            currentVertics = queue.poll();
            destinationVertices = graph.get(currentVertics);
            for (Character dest : destinationVertices) {
                if (!visitedVerticesMap.containsKey(dest)) {
                    queue.add(dest);
                    visitedVerticesMap.put(dest, true);
                    System.out.println(currentVertics + " -> " + dest);
                }
            }
        }
    }

    static void BFSAndDFS() {
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        Graph graphForBFSAndDFS = new Graph(names);
        graphForBFSAndDFS.addEdges(0, new int[]{1, 2});
        graphForBFSAndDFS.addEdges(1, new int[]{0, 3, 4});// 3 <-> 4
        graphForBFSAndDFS.addEdges(2, new int[]{0, 3, 5});
        graphForBFSAndDFS.addEdges(3, new int[]{1, 2, 4});
        graphForBFSAndDFS.addEdges(4, new int[]{1, 5});
        graphForBFSAndDFS.addEdges(5, new int[]{2, 3, 4, 7});
        graphForBFSAndDFS.addEdges(6, new int[]{7, 8});
        graphForBFSAndDFS.addEdges(7, new int[]{5, 6, 8});
        graphForBFSAndDFS.addEdges(8, new int[]{6, 7});

        graphForBFSAndDFS.BFS();
        graphForBFSAndDFS.DFS();
    }

    static void dijkstra() {
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Graph graphForDijkstra = new Graph(names);
        graphForDijkstra.addEdges(0, new int[]{1, 2, 3}, new int[]{2, 4, 3});

        graphForDijkstra.addEdges(1, new int[]{4, 5, 6}, new int[]{7, 4, 6});
        graphForDijkstra.addEdges(2, new int[]{4, 5, 6}, new int[]{3, 2, 4});
        graphForDijkstra.addEdges(3, new int[]{4, 5, 6}, new int[]{4, 1, 5});

        graphForDijkstra.addEdges(4, new int[]{7, 8}, new int[]{1, 4});
        graphForDijkstra.addEdges(5, new int[]{7, 8}, new int[]{6, 3});
        graphForDijkstra.addEdges(6, new int[]{7, 8}, new int[]{3, 3});

        graphForDijkstra.addEdges(7, new int[]{9}, new int[]{3});
        graphForDijkstra.addEdges(8, new int[]{9}, new int[]{4});

        graphForDijkstra.dijkstra();
    }
}
