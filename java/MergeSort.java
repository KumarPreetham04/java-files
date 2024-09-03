import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        for (int size : numbers) {
            long startTime = System.currentTimeMillis();
            int[] arr = Array(size);
            mergeSort(arr);
            long endTime = System.currentTimeMillis();

            long elapsedTime = (endTime - startTime); 
            System.out.println(size + ", Time: " + elapsedTime + " milliseconds");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static int[] Array(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); 
        }

        return arr;
    }
}
