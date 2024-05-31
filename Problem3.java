import java.util.*;

class Graph2 {
    private int vertices; 
    private LinkedList<Integer> adj[]; 

    Graph2(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
        	adj[i] = new LinkedList();
        }           
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean depthFirstSearchDirected(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v]) return true;
        if (visited[v]) return false;

        visited[v] = true;
        recStack[v] = true;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (depthFirstSearchDirected(i, visited, recStack)) return true;
        }
        recStack[v] = false;
        return false;
    }

    boolean depthFirstSearchUndirected(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (depthFirstSearchUndirected(i, visited, v)) return true;
            } 
            else if (i != parent) return true;
        }
        return false;
    }

    boolean isCyclicDirected() {
        boolean visited[] = new boolean[vertices];
        boolean recStack[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
        	if (depthFirstSearchDirected(i, visited, recStack)) return true;
        }
      
        return false;
    }
 
    boolean isCyclicUndirected() {
        boolean visited[] = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++) {
        	if (!visited[i] && depthFirstSearchUndirected(i, visited, -1)) return true;
        }
            
        return false;
    }

}

public class Problem3 {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int V;
        
        System.out.print("Enter the number of vertices: ");
        V = sc.nextInt();
        
        Graph2 graph = new Graph2(V);
        
        System.out.println("Enter edges in format 'source destination' (0-indexed): ");
        System.out.println("Enter -1 to stop.");
        while(true) {
            int source = sc.nextInt();
            if (source == -1) break;
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        if (graph.isCyclicDirected()) System.out.println("\nThe graph contains a cycle (Directed)");
        else System.out.println("The graph doesn't contain a cycle (Directed)");

        if (graph.isCyclicUndirected()) System.out.println("\nThe graph contains a cycle (Undirected)");
        else System.out.println("The graph doesn't contain a cycle (Undirected)");
        
        sc.close();
    }
    
}
