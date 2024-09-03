public class Array{

    public static void main(String[] args) {
        int[] myArray = new int[10];


        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i * 2; 
        }

        // Print each element of the array
        System.out.println("Array elements:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Element at index " + i + ": " + myArray[i]);
        }
    }
}
