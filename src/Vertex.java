import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V> ,Double> map = new HashMap<>();
    public V getData() {
        return data;
    }
    public Vertex(V data) {
        this.data =data;
    }


    public void setData(V data) {
        this.data =data;
    }

    public void addAdjacentVertex(Vertex<V> destination, Double weight) {
        map.put(destination,weight);
    }

    public Map<Vertex<V>, Double>getAdjacentVertices() {
        return map;
    }

    public Iterable<V> getAdjacentVerticesData() {
        return map.keySet().stream().map(Vertex::getData)::iterator;
    }



    @Override
    public boolean equals(Object object) {
        if (this==object) return true;

        if (object==null||getClass()!= object.getClass())
            return false;

        Vertex<?>otherVertex = (Vertex<?>)object;

        return data.equals(otherVertex.data);
    }
}