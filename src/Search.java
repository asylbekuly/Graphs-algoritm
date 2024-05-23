import java.util.*;

public class Search<V>{
    protected V source;
    protected Map<V, V> edgeTo;
    protected Set<V> marked;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V value) {
        return marked.contains(value);
    }

    public Iterable<V> Path_To(V value) {
        if (hasPathTo(value)==false) {
            return null;
        }

        Stack<V> path = new Stack<>();
        for (V i=value; i !=null; i =edgeTo.get(i)) {
            path.push(i);
        }

        return path;
    }

}