import java.util.*;

public class DijkstraSearch extends Search {
    private final Map<Vertex, Integer> distance = new HashMap<>();
    private final Map<Vertex, Vertex> edgeTo = new HashMap<>();
    private final Set<Vertex> visited = new HashSet<>();

    public DijkstraSearch(WeightedGraph graph, Vertex start) {
        super(start);
        dijkstra(graph, start);
    }

    private void dijkstra(WeightedGraph graph, Vertex start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        for (Vertex v : graph.getVertices()) {
            distance.put(v, Integer.MAX_VALUE);
        }
        distance.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            if (!visited.add(current)) continue;

            for (Map.Entry<Vertex, Integer> entry : graph.getAdjVertices(current).entrySet()) {
                Vertex neighbor = entry.getKey();
                int weight = entry.getValue();
                int newDist = distance.get(current) + weight;
                if (newDist < distance.get(neighbor)) {
                    distance.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex destination) {
        return distance.get(destination) < Integer.MAX_VALUE;
    }

    @Override
    public List<Vertex> pathTo(Vertex destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex at = destination; at != null; at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        return path;
    }

    public int getDistanceTo(Vertex destination) {
        return distance.getOrDefault(destination, Integer.MAX_VALUE);
    }
}
