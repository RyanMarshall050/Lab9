import java.util.*;

public class BreadthFirstIterator implements Iterator {
    private Queue<String> toVisit;
    private Set<String> visited;
    private Graph edges;


    BreadthFirstIterator(Graph edges, String starting){
        this.toVisit = new LinkedList<String>();
        this.visited = new HashSet<String>();
        this.edges = edges;

        toVisit.add(starting);
    }

    @Override
    public boolean hasNext() {
        return !toVisit.isEmpty();
    }

    @Override
    public String next() {
        String outputObject = null;
        if (!toVisit.isEmpty()){
            outputObject = toVisit.poll();
            visited.add(outputObject);

            for (String neighbor : this.edges.getNeighbors(outputObject)){
                if (!visited.contains(neighbor)){
                    toVisit.add(neighbor);
                }
            }
        }
        return outputObject;
    }
    
}
