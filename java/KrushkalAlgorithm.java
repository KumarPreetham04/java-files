import java.util.*;

public class KrushkalAlgorithm {

    static List<int[]> minimumSpanningTree(int[][] adjacencymatrix) {
        List<int[]> result = new ArrayList<>();

        int v = adjacencymatrix.length;

        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                if (adjacencymatrix[i][j] != 0) {
                    result.add(new int[]{i, j, adjacencymatrix[i][j]});
                }
            }
        }

        Collections.sort(result, Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[v];
        Arrays.fill(parent, -1);

        List<int[]> mstEdges = new ArrayList<>();

        for (int[] edge : result) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);
            if (x != y) {
                mstEdges.add(edge);
                union(parent, x, y);
            }
        }

        return mstEdges;
    }

    static int find(int[] arr, int x) {
        if (arr[x] == -1) {
            return x;
        }
        return find(arr, arr[x]);
    }

    static void union(int[] arr, int x, int y) {
        int xset = find(arr, x);
        int yset = find(arr, y);
        arr[xset] = yset;
    }


    public static int[][] converter(char[][]arr){
        int[][] result  = new int[arr.length][arr[0].length];
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='0'){
                    result[i][j]=0;
                }
                else{
                    result[i][j]=(int)arr[i][j];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        char[][] chargraph = {
                {'0','q','c', 'x'},
                {'a', '0', 'z', 'm'},
                {'q', 'b', 'b', '0'},
                {'0', '0', 'v', 'x'}
        };

        int[][] graph = converter(chargraph);
        System.out.println(Arrays.deepToString(graph));

        KrushkalAlgorithm ka = new KrushkalAlgorithm();
        List<int[]> result = ka.minimumSpanningTree(graph);

        System.out.println("Edges in MST:");
        for (int[] edge : result) {
            System.out.println(edge[0] + " - " + edge[1] + " : " + edge[2]);
        }

    }
}