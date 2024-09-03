import java.util.Arrays;

public class knapsackdp {

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int capacity = 50;
        int n = profit.length;

        int[][] dp = new int[n + 1][capacity + 1];


        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(profit[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Profit: " + dp[n][capacity]);

        System.out.print("Selected Items: ");
        int i = n, w = capacity;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w -= weight[i - 1];
            }
            i--;
        }
    }
}