public class sts4 {

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    static void findPaths(int[][] matrix, int row, int col, String path) {
        if (row == 0 && col == 0) {
            System.out.println(path);
            return;
        }

        if (isValidMove(row, col - 1)) {
            findPaths(matrix, row, col - 1, path + " left");
        }

        if (isValidMove(row - 1, col)) {
            findPaths(matrix, row - 1, col, path + " up");
        }

        if (isValidMove(row - 1, col - 1)) {
            findPaths(matrix, row - 1, col - 1, path + " diagonal");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sourceRow = 2, sourceCol = 2;
        int destRow = 0, destCol = 0;

        System.out.println("Finding paths from (" + sourceRow + ", " + sourceCol + ") to (" + destRow + ", " + destCol + "):");
        findPaths(matrix, sourceRow, sourceCol, "");
    }
}
