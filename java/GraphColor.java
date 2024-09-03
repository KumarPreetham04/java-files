import java.util.Arrays;

public class GraphColor {

    public static void main(String[] args) {
        
        int[] coloring = { 0, 0, 0, 0, 0 };
        int[][] graph = { { 0, 1, 1, 0, 1 }, { 1, 0, 1, 0, 0 }, { 1, 1, 0, 1, 0 }, { 0, 0, 1, 0, 1 },
                { 1, 0, 0, 1, 0 } };

        mColour(graph, coloring, 0);

    }

    public static void mColour(int[][]graph,int[]colour,int n){
        do{
            
            nextColor(graph,colour,n);

            if (colour[n]==0) {
                return;
            }

            if(n==colour.length-1){
                System.out.println(Arrays.toString(colour));
            }
            else{
                mColour(graph, colour, n+1);
            }

        }while(true);
 
    }

    public static void nextColor(int[][]graph,int[]colour,int n){

        do{

            colour[n] = (colour[n]+1)%colour.length;

            if(colour[n]==0) return;

            int i;

            for(i=0;i<colour.length;i++){
                if(graph[n][i]!=0&&colour[n]==colour[i]){
                    break;
                }
            }

            if(i==colour.length) return;

        }while(true);

    }
}