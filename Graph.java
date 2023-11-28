import java.util.*;

/**
 * Graph
 */
public class Graph {
    protected Map<String, List<String>> edges;

    Graph(){
        edges = new HashMap<String,List<String>>();
    }

    public void addEdge(String source, String dest){
        edges.putIfAbsent(source, new ArrayList<>());
        edges.get(source).add(dest);
    }

    public List<String> getNeighbors(String source){
        return edges.getOrDefault(source, new ArrayList<String>());
    }


    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "A");
        g.addEdge("D", "C");
        g.addEdge("E", "B");
        g.addEdge("F", "B");

        BreadthFirstIterator bfi = new BreadthFirstIterator(g, "A");
        System.out.println("Graph Traversal:");
        while (bfi.hasNext()) {
            System.out.println(bfi.next());
        }
    }
}