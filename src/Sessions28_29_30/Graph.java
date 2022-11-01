package Sessions28_29_30;


import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int lastIndex = 0;
    Vertex[] vertices;

    public Graph(String[] names) {
        vertices = new Vertex[names.length];
        for (String name : names) {
            vertices[lastIndex] = new Vertex();
            vertices[lastIndex].name = name;
            lastIndex++;
        }
    }


    public void addEdges(int vertexIndex, int[] targetsIndexes) {
        vertices[vertexIndex].edges = new Edge[targetsIndexes.length];
        for (int i = 0; i < targetsIndexes.length; i++) {
            vertices[vertexIndex].edges[i] = new Edge(vertices[vertexIndex], vertices[targetsIndexes[i]], 0);
        }
    }
    // 7 {9} {3}
    public void addEdges(int vertexIndex, int[] targetsIndexes, int[] weightsIndexes) {
        vertices[vertexIndex].edges = new Edge[targetsIndexes.length];
        for (int i = 0; i < targetsIndexes.length; i++) {
            vertices[vertexIndex].edges[i] = new Edge(  vertices[vertexIndex],
                                                        vertices[targetsIndexes[i]],
                                                        weightsIndexes[i]);
        }
    }

    public void resetVertices() {
        for (Vertex vertex : vertices) {
            vertex.visited = false;

            vertex.totalLength = 0;
            vertex.sourceOfTotalLength = null;
        }

    }

    public void BFS() {
        System.out.println("Using BFS...");
        Queue<Vertex> queue = new LinkedList<>();// LinkedList is sufficient for a FIFO operation

        queue.add(vertices[0]);
        vertices[0].visited = true;


        Vertex currentVertix;
        Edge[] destinationVertices;

        while (!queue.isEmpty()) {
            currentVertix = queue.poll();
            destinationVertices = currentVertix.edges;
            for (Edge destinationVertex : destinationVertices) {
                if (!destinationVertex.target.visited) {
                    queue.add(destinationVertex.target);
                    destinationVertex.target.visited = true;
                    System.out.println(currentVertix.name + " -> " + destinationVertex.target.name);
                }
            }

        }

        resetVertices();
    }

    public void DFS() {
        System.out.println("DFS Recursion...");
        dfsRecursion(vertices[0]);
        resetVertices();
    }

    private void dfsRecursion(Vertex vertex) {
        vertex.visited = true;
        Edge[] destinationVertices = vertex.edges;
        for (Edge destinationVertex : destinationVertices) {
            if (!destinationVertex.target.visited) {
                System.out.println(vertex.name + " -> " + destinationVertex.target.name);
                dfsRecursion(destinationVertex.target);
            }
        }
    }

    public void dijkstra() {
        System.out.println("Dijkstra...");
        for (int i = 1; i < vertices.length; i++) {
            vertices[i].totalLength = Integer.MAX_VALUE;

        }

        Vertex currentVertex;
        for (Vertex vertex : vertices) {
            currentVertex = vertex;
            Edge[] destinations = currentVertex.edges;

            if (destinations == null) continue;

            Edge currentEdge;
            for (Edge destination : destinations) {
                currentEdge = destination;
                double newLength = currentVertex.totalLength + currentEdge.weight;
                if (newLength < currentEdge.target.totalLength) {
                    currentEdge.target.totalLength = newLength;
                    currentEdge.target.sourceOfTotalLength = currentVertex;

                }

            }
        }

        //Printing Solution
        StringBuilder path = new StringBuilder();
        path.append(vertices[vertices.length - 1].name).append(" ");
        Vertex vertexIterator = vertices[vertices.length - 1];

        while (vertexIterator.sourceOfTotalLength != null){
            path.append(vertexIterator.sourceOfTotalLength.name).append(" ");
            vertexIterator = vertexIterator.sourceOfTotalLength;
        }

        System.out.println(path.reverse().toString());
        System.out.println(vertices[vertices.length - 1].totalLength);

        resetVertices();
    }
}
