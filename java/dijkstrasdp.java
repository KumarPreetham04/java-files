import java.util.Arrays;

public class dijkstrasdp {

    public static void dijkstraAlgorithm(int[][] graph, int src, int nodes) {

        int[] dist_src_i = new int[nodes];
        boolean[] trav_i = new boolean[nodes];

        Arrays.fill(dist_src_i, Integer.MAX_VALUE);
        Arrays.fill(trav_i, false);

        dist_src_i[src] = 0;

        for (int count = 0; count < nodes - 1; count++) {
            int minind = minDistance(dist_src_i, trav_i);
            trav_i[minind] = true;
 
            for (int adj = 0; adj < nodes; adj++) {
                if (!trav_i[adj] && graph[minind][adj] != 0 && dist_src_i[minind] != Integer.MAX_VALUE &&
                        dist_src_i[minind] + graph[minind][adj] < dist_src_i[adj]) {
                    dist_src_i[adj] = dist_src_i[minind] + graph[minind][adj];
                }
            }
        }
        System.out.println("The vertex distance from source " + src + " is:");
        for (int i = 0; i < nodes; i++) {
            System.out.println(i + " -> " + dist_src_i[i]);
        }
    }

    public static int minDistance(int[] dist_src_i, boolean[] trav_i) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < dist_src_i.length; i++) {
            if (!trav_i[i] && dist_src_i[i] <= min) {
                min = dist_src_i[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0,3,4,0,0,0},
        {3,0,1,0,0,6},
        {4,1,0,3,0,6},
        {0,0,3,0,2,4},
        {0,0,0,2,0,3},
        {0,6,6,4,3,0}};
        dijkstraAlgorithm(graph, 0, graph.length);
    }
}