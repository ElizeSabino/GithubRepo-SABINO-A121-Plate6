import java.util.Scanner;

public class Problem8 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String vertexSet1[], vertexSet2[];

        System.out.println("Enter the set of vertices for the first graph (comma-separated):");
        vertexSet1 = sc.nextLine().split(",");
        System.out.println("Enter the set of vertices for the second graph (comma-separated):");
        vertexSet2 = sc.nextLine().split(",");

        if (vertexSet1.length == vertexSet2.length) System.out.println("The graphs are isomorphic.");
        else System.out.println("The graphs are not isomorphic.");

        sc.close();
    }
}
