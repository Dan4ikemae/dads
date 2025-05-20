public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        graph.addEdge(a, b, 4);
        graph.addEdge(a, c, 2);
        graph.addEdge(b, c, 1);
        graph.addEdge(b, d, 5);
        graph.addEdge(c, d, 8);
        graph.addEdge(d, e, 6);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, a);
        System.out.println("BFS path from A to E: " + bfs.pathTo(e));

        DijkstraSearch dijkstra = new DijkstraSearch(graph, a);
        System.out.println("Dijkstra path from A to E: " + dijkstra.pathTo(e));
        System.out.println("Distance from A to E: " + dijkstra.getDistanceTo(e));
    }
}
