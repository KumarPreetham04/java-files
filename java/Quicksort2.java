class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[]arr,int left,int right){

        if(left<right){
            int pivot = partition(arr,left,right);
            quickSort(arr,left,pivot-1);
            quickSort(arr,pivot+1,right);
        }
    }

    public static int partition(int[]arr,int left,int right){
        int pivot = arr[right];
        int i = left-1;

        for (int j = left; j <right; j++) {
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i++;
    }
}