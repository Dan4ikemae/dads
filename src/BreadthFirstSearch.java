import java.util.*;

public class BreadthFirstSearch extends Search {
    private final Map<Vertex, Vertex> edgeTo = new HashMap<>();
    private final Set<Vertex> marked = new HashSet<>();

    public BreadthFirstSearch(WeightedGraph graph, Vertex start) {
        super(start);
        bfs(graph, start);
    }

    private void bfs(WeightedGraph graph, Vertex start) {
        Queue<Vertex> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex neighbor : graph.getAdjVertices(current).keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex destination) {
        return marked.contains(destination);
    }

    @Override
    public List<Vertex> pathTo(Vertex destination) {
        if (!hasPathTo(destination)) return null;

        LinkedList<Vertex> path = new LinkedList<>();
        for (Vertex x = destination; !x.equals(start); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(start);
        return path;
    }
}
