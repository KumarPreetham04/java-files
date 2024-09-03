
public class Nqueens {
    final int N = 4; 

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[j][i] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int row) {
        if (row >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;

                if (solveNQUtil(board, row + 1))
                    return true;

                board[row][i] = 0;
            }
        }

        return false;
    }


    boolean solveNQ() {
        int board[][] = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}

        };

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String args[]) {
        Nqueens Queen = new Nqueens();
        Queen.solveNQ();
    }
}

