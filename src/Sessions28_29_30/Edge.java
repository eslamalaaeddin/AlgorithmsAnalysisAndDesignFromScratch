package Sessions28_29_30;

public class Edge {
    double weight;
    Vertex source;
    Vertex target;

    public Edge(Vertex source, Vertex target, double weight) {
        this.weight = weight;
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString() {
        return source.name + " -> " + target.name;
    }
}
