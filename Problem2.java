import java.util.*;

public class Problem2 { 

    private static List<String> readMatrixRows(Scanner sc) {
        List<String> matrixRows = new ArrayList<>();
        System.out.println("Enter the adjacency matrix of the graph "
        		+ "(separate elements by space, rows separated by newline):");
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            matrixRows.add(line);
        }
        return matrixRows;
    }

    private static int[][] buildAdjacencyMatrix(List<String> matrixRows) {
        int vertices = matrixRows.size();
        int adjacencyMatrix[][] = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            String elements[] = matrixRows.get(i).split("\\s+");
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = Integer.parseInt(elements[j]);
            }
        }
        return adjacencyMatrix;
    }

    private static boolean checkSymmetry(int[][] adjacencyMatrix, int vertices) {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) return false;
            }
        }
        return true;
    }

    private static void getUndirectedEdges(int[][] adjacencyMatrix, int vertices, List<String> edges, 
    										Map<String, Integer> edgeCount) {
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    String edge = i + " - " + j;
                    edges.add(edge);
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + 1);
                }
            }
        }
    }

    private static void getDirectedEdges(int[][] adjacencyMatrix, int vertices, List<String> edges, Map<String, Integer> edgeCount) {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    for (int k = 0; k < adjacencyMatrix[i][j]; k++) {
                        String edge = i + " -> " + j;
                        edges.add(edge);
                        edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + 1);
                    }
                }
            }
        }
    }

    private static void printEdgeOccurrences(Map<String, Integer> edgeCount) {
        System.out.println("\nEdges and their occurrences:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> matrixRows = readMatrixRows(sc);
        List<String> edges = new ArrayList<>();
        Map<String, Integer> edgeCount = new HashMap<>();
        int adjacencyMatrix[][] = buildAdjacencyMatrix(matrixRows);
        int vertices = matrixRows.size();
        boolean isSymmetrical = checkSymmetry(adjacencyMatrix, vertices);     
        
        if (isSymmetrical) getUndirectedEdges(adjacencyMatrix, vertices, edges, edgeCount);
        else getDirectedEdges(adjacencyMatrix, vertices, edges, edgeCount);
        
        printEdgeOccurrences(edgeCount);
        sc.close();
    }
}
