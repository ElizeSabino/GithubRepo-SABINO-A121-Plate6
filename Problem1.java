import java.util.*;

class Graph {
	private int vertices;
	private LinkedList<Integer> adj[];
	
	Graph(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	public void addEdge(int v, int w) { 
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public void depthFirstSearch(int v, boolean visited[]) {
		visited[v] = true;
		for (Integer n : adj[v]) {
			if (!visited[n]) depthFirstSearch(n, visited);
		}
	}
	
	public boolean isConnected() {
		boolean visited[] = new boolean[vertices];
		depthFirstSearch(0, visited);
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) return false;
		}
		return true;
	}
	
	public int countConnectedComponents() {
		boolean visited[] = new boolean[vertices];
		int count = 0;
		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				depthFirstSearch(i, visited);
				count++;
			}
		}
		return count;
	}
	
}

public class Problem1 { 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxVertex = -1, V;
		
		try {
			System.out.print("Enter list of edges (vertex pairs separated by spaces): ");
			String edges[] = sc.nextLine().split(" ");
			
			Set<String> edgeSet = new HashSet<>(Arrays.asList(edges));
			List<int[]> edgeList = new ArrayList<>();
			
			for (String edge : edgeSet) {
				String pair[] = edge.split(",");
				int v = Integer.parseInt(pair[0]);
				int w = Integer.parseInt(pair[1]);
				edgeList.add(new int[]{v, w});
			}
			
			for (int edge[] : edgeList) {
				maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
			}
			V = maxVertex + 1;
			
			Graph g = new Graph(V);
			for (int edge[] : edgeList) {
				g.addEdge(edge[0], edge[1]);
			}
			if (g.isConnected()) System.out.println("The graph is connected.");
			else {
				int components = g.countConnectedComponents();
				System.out.println("The graph is not connected.");
				System.out.println("Number of connected components: " + components);
			}
			sc.close();
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}
		
	}

}
