public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(false);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Atyrau");


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(false);
        fillWithoutWeights(graph);

        System.out.println("BFS:");
        Search<String> bfs = new BFS<>(graph, "Almaty");
        outputPath(bfs, "Atyrau");

        System.out.println("--------------------------------");

        System.out.println("DFS:");
        Search<String> dfs = new DFS<>(graph, "Almaty");
        outputPath(dfs, "Atyrau");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");


    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.Path_To(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }


}