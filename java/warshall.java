public class warshall {

    final static int max = 11111, V = 4; 

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                        System.out.print(dist[i][k] + dist[k][j] +"  ");
                }
                System.out.println();
            }
        }

        sol(dist);
    }

    void sol(int dist[][]) {
        System.out.println("warshall algorithm output:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
            System.out.print(dist[i][j] + "  ");
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {
        int graph[][] = { {0,  max,  max, 1},
                          {max, 0,  2, max},
                          {4, max, 0, 8},
                          {max, max, 6, 0}
                        };
        warshall a = new warshall();

        a.floydWarshall(graph);
    }
}

