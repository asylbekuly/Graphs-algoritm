import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distance = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);

        for (V v:graph.getVertices()) {
            distance.put(v, Double.POSITIVE_INFINITY);
        }

        distance.put(source, 0.0);

        dijkstra_func(graph);
    }

    private void dijkstra_func(WeightedGraph<V> graph) {
        while (true) {
            V vertex = null;
            double minDestin = Double.POSITIVE_INFINITY;

            for (V v : distance.keySet()) {
                if (!marked.contains(v) && distance.get(v) < minDestin) {
                    vertex = v;
                    minDestin = distance.get(v);
                }
            }

            if (vertex == null) {
                break;
            }

            marked.add(vertex);

            for (V adjVertex : graph.getAdjacentVertices(vertex)) {
                if (!marked.contains(adjVertex)) {
                    double newDist = distance.get(vertex) + graph.getWeight(vertex, adjVertex);
                    if (newDist < distance.get(adjVertex)) {
                        distance.put(adjVertex, newDist);
                        edgeTo.put(adjVertex, vertex);
                    }
                }
            }
        }
    }
}
