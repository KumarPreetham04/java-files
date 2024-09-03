import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GraphPathsFinder {
    private static final int V = 5; // Assuming a 5x5 
    private static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGraph();

        // Read the edge matrix from user input
        System.out.println("Enter the 5x5 edge matrix (0 or 1):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                int edge = scanner.nextInt();
                if (edge == 1) {
                    addEdge(i, j);
                }
            }
        }

        // Read source and destination
        System.out.println("Enter source vertex (0 to 4):");
        int source = scanner.nextInt();
        System.out.println("Enter destination vertex (0 to 4):");
        int destination = scanner.nextInt();

        // Find and print all paths
        System.out.println("All paths from " + source + " to " + destination + ":");
        printAllPaths(source, destination);
        scanner.close();
    }

    private static void initializeGraph() {
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private static void addEdge(int s, int d) {
        adjList.get(s).add(d);
    }

    private static void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        explorePaths(s, d, isVisited, pathList);
    }

    private static void explorePaths(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
        isVisited[u] = true;
        if (u.equals(d)) {
            System.out.println(localPathList);
            isVisited[u] = false;
            return;
        }
        for (Integer i : adjList.get(u)) {
            if (!isVisited[i]) {
                localPathList.add(i);
                explorePaths(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[u] = false;
    }
}
