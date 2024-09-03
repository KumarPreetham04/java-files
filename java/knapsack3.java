
public class knapsack3 {
    public static void main(String[] args){
        int[] profit_val = {3 , 2 , 3 , 4, 5};
        int [] weight_val = {1, 2, 3 , 4, 5};
        int bagcapacity = 10;

        int n = profit_val.length;

        int[][] fin = new int[n+1] [bagcapacity+1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= bagcapacity; w++) {
                if (weight_val[i - 1] <= w) {
                    fin[i][w] = Math.max(profit_val[i - 1] + fin[i - 1][w - weight_val[i - 1]], fin[i - 1][w]);
                } else {
                    fin[i][w] = fin[i - 1][w];
                }
            }
        }

        System.out.println("Max profit: " + fin[n][bagcapacity]);
        System.out.println("selected items in 0 1 format: ");

        int i = n , w=bagcapacity;
        while(i>0 && w>0){
            if(fin[i][w] != fin[i-1][w] ){
                System.out.print(i + " ");
                w -= weight_val[i-1];
                
            }
            i--;

        }



        





    }
    
}
