import java.util.*;

public class WeightedGraph {
    private final Map<Vertex, Map<Vertex, Integer>> adjVertices = new HashMap<>();

    public void addVertex(Vertex vertex) {
        adjVertices.putIfAbsent(vertex, new HashMap<>());
    }
    public void addEdge(Vertex source, Vertex destination, int weight) {
        adjVertices.get(source).put(destination, weight);
        adjVertices.get(destination).put(source, weight); // For undirected graph
    }
    public Set<Vertex> getVertices() {
        return adjVertices.keySet();
    }
    public Map<Vertex, Integer> getAdjVertices(Vertex vertex) {
        return adjVertices.getOrDefault(vertex, new HashMap<>());
    }
}
