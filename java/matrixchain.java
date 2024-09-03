public class matrixchain{

    // Function to find optimal parenthesization and print it
    static void printParenthesis(int i, int j, int[][] bracket, char name) {
        if (i == j) {
            System.out.print(name);
            return;
        }

        System.out.print("(");
        printParenthesis(i, bracket[i][j], bracket, name);
        printParenthesis(bracket[i][j] + 1, j, bracket, name);
        System.out.print(")");
    }

    // Function to compute optimal matrix chain multiplication
    static void matrixChainOrder(int[] p) {
        int n = p.length; // Number of matrices
        int[][] m = new int[n][n]; // Minimum number of multiplications
        int[][] bracket = new int[n][n]; // Optimal break points

        // Initialize base cases (single matrix)
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // Chain length
        for (int chainLen = 2; chainLen < n; chainLen++) {
            for (int i = 1; i < n - chainLen + 1; i++) {
                int j = i + chainLen - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        // Print optimal parenthesization
        System.out.print("Optimal parenthesization is ");
        printParenthesis(1, n - 1, bracket, 'A');
        System.out.println();
        System.out.println("Optimal cost of parenthesization is " + m[1][n - 1]);
    }

    public static void main(String[] args) {
        int[] dimensions = {5, 4, 6, 2, 7, 4}; // Example input
        matrixChainOrder(dimensions);
    }
}


























