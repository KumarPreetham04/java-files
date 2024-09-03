import java.util.Arrays;

class matrixseq{

    static void MatrixChain(int []p) {
        int n = p.length;
        int [][]m = new int[n][n];
        int [][]s = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        for(int i = 0; i < m.length; i++) {
            for (int j =0; j<m.length;j++){
                System.out.print(m[i][j] + " ");

            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println("sequence matrix is : ");
        for(int i = 0; i < s.length; i++) {
            for (int j =0; j<s.length;j++){
                System.out.print(s[i][j] + " ");

            }
            System.out.println(" ");
           
        }
        paranthesis(1,n-1,s);
    }
        public static void paranthesis(int i  , int j,int [][] paranthesizedmatrix){
        
        if (i == j){
            System.out.print("A"+i);
        }
        else
        {
            System.out.print("(");
            paranthesis(i,paranthesizedmatrix[i][j],paranthesizedmatrix);
            paranthesis(paranthesizedmatrix[i][j]+1,j,paranthesizedmatrix);
            System.out.print(")");

        }
    
    

    }


    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 6, 7, 8, 9};
        MatrixChain(arr);
    }
}
