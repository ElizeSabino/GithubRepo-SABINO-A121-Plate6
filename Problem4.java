import java.util.*;

public class Problem4 {
	
    private static void addToAdjacencyList(List<List<Integer>> adjList, int u, int v) {
        int max = Math.max(u, v);
        while (adjList.size() <= max) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> adjList = new ArrayList<>();
        int vertices; 

        System.out.println("Enter edges as vertex pairs (0-indexed): ");
        System.out.println("Enter -1 to stop.");
        while (true) {
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            if (v == -1) break;

            addToAdjacencyList(adjList, u, v);
        }

        vertices = adjList.size();

        int degrees[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            degrees[i] = adjList.get(i).size();
        }
            
        System.out.println("\nDegrees of vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + degrees[i]);
        }
            
        sc.close();
    }

}
