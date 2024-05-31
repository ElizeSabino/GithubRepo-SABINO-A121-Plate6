import java.util.*;

public class Problem5 {

	private static void addToAdjacencyList(List<List<Integer>> adjList, int u, int v) {
        int max = Math.max(u, v);
        while (adjList.size() <= max) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
	
    private static boolean isBipartite(List<List<Integer>> adjList, int V) {
        int colors[] = new int[V];
        Arrays.fill(colors, 0);
        Queue<Integer> queue = new LinkedList<>(); // BFS Traversal

        for (int i = 0; i < V; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int u = queue.poll();

                    for (int v : adjList.get(u)) {
                        if (colors[v] == 0) {
                            colors[v] = -colors[u];
                            queue.add(v);
                        } 
                        else if (colors[v] == colors[u]) return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adjList = new ArrayList<>();
        
        System.out.println("Enter edges as vertex pairs (0-indexed): ");
        System.out.println("Enter -1 to stop.");
        while (true) {
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            if (v == -1) break;

            addToAdjacencyList(adjList, u, v);
        }

        int vertices = adjList.size();

        if (isBipartite(adjList, vertices)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        sc.close();
    }

}
