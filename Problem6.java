import java.util.*;

public class Problem6 {
	
	private static int findMaxVertex(List<int[]> edges) {
        int max = -1;
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        return max;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();
        
        System.out.println("Enter edges as vertex pairs (0-indexed): ");
        System.out.println("Enter -1 to stop.");
        while (true) {
            int source = sc.nextInt();
            if (source == -1) break;
            int destination = sc.nextInt();
            edges.add(new int[]{source, destination});
        }

        int vertices = findMaxVertex(edges) + 1;
        int adjacencyMatrix[][] = new int[vertices][vertices];

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];

            System.out.print("Is the edge directed? (Y/N): ");
            char isDirected = sc.next().charAt(0);

            if (adjacencyMatrix[source][destination] != 0) {
                if (isDirected == 'N' || isDirected == 'n') adjacencyMatrix[source][destination]++;
            } 
            else {
                System.out.print("Enter weight of the edge: ");
                int weight = sc.nextInt();

                if (isDirected == 'Y' || isDirected == 'y') adjacencyMatrix[source][destination] = weight;
                else {
                    adjacencyMatrix[source][destination] = weight;
                    adjacencyMatrix[destination][source] = weight;
                }
            }
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
    
}
