import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V> {

    public BFS(MyGraph<V> graph, V source) {
        super(source);
        Breadthfirstsearch(graph, source);
    }

    private void Breadthfirstsearch(MyGraph<V> graph, V source) {
        Queue<V>queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            V value = queue.poll();
            for (Vertex<V> vertex : graph.getVertex(value).getAdjacentVertices().keySet()) {
                V neighbor =vertex.getData();
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, value);
                    queue.add(neighbor);
                }
            }
        }
    }
}
