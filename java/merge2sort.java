import java.util.Arrays;
import java.util.Random;

public class merge2sort {

    public static void main(String[] args) {
        int[] n = {1000,540,620,240,180,350,420,782,820,960
        };

        int[] fullArray = completeArray(1000);

        for (int val : n) {
            long startTime = System.currentTimeMillis();
            int[] subArray = Arrays.copyOfRange(fullArray, 0, val);
            mergeSort(subArray);
            long endTime = System.currentTimeMillis();
            long elapsedTime = (endTime - startTime);
            System.out.println(val + ", Time: " + elapsedTime + " milliseconds");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static int[] completeArray(int val) {
        int[] arr = new int[val];
        Random random = new Random();

        for (int i = 0; i < val; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
}

