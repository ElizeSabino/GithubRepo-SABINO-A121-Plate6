import java.util.*;

public class Problem7 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();
        Map<List<Integer>, Integer> edgeCount = new HashMap<>();
        int maxVertex = -1;

        System.out.println("Enter edges as vertex pairs (0-indexed): ");
        System.out.println("Enter -1 to stop.");
        while (true) {
            int u = sc.nextInt();
            if (u == -1) break;
            int v = sc.nextInt();
            if (v == -1) break;
            edges.add(new int[]{u, v});
            maxVertex = Math.max(maxVertex, Math.max(u, v));
        }

        int vertices = maxVertex + 1;

        for (int edge[] : edges) {
            List<Integer> edgeList = Arrays.asList(edge[0], edge[1]);
            edgeCount.put(edgeList, edgeCount.getOrDefault(edgeList, 0) + 1);
        }

        System.out.println("\nEdge occurrences:");
        for (Map.Entry<List<Integer>, Integer> entry : edgeCount.entrySet()) {
            List<Integer> edge = entry.getKey();
            int count = entry.getValue();
            System.out.println("Edge " + edge.get(0) + "-" + edge.get(1) + ": " + count + " times");
        }

        int incidenceMatrix[][] = new int[edges.size()][vertices];
        for (int i = 0; i < edges.size(); i++) {
            int edge[] = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            incidenceMatrix[i][u] = 1;
            incidenceMatrix[i][v] = 1;
        }

        System.out.println("\nIncidence Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(incidenceMatrix[j][i] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
