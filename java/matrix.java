public class matrix {
    public static void main(String[] args) {

        int[][] originalMatrix = generateSequentialMatrix(5, 5);

        System.out.println("Original Matrix:");
        printMatrix(originalMatrix);

        int[][] circularMatrix = arrangeInCircularOrder(originalMatrix);

        System.out.println("\nArranged in Circular Order:");
        printMatrix(circularMatrix);
    }
    private static int[][] generateSequentialMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }

    private static int[][] arrangeInCircularOrder(int[][] originalMatrix) {
        int rows = originalMatrix.length;
        int cols = originalMatrix[0].length;
        int[][] circularMatrix = new int[rows][cols];

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int direction = 0; 

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    circularMatrix[top][i] = originalMatrix[top][i];
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    circularMatrix[i][right] = originalMatrix[i][right];
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    circularMatrix[bottom][i] = originalMatrix[bottom][i];
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    circularMatrix[i][left] = originalMatrix[i][left];
                }
                left++;
            }

            direction = (direction + 1) % 4;
        }

        return circularMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }
    }
}
