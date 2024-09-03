import java.util.Scanner;

public class search {

    public static void main(String[] args) {
        String[] array = {"abc preetham" , "akhil qwe", "aravindan aaa", "surya bnm"};

  
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the element: ");
        String target = inp.nextLine();

        int result = linearSearch(array, target);

        if (result == -1) {
            System.out.println("String not found in the array.");
        } else {
            System.out.println("element found and count is" + result);
        }
    }

    public static int linearSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
 
 
    }
}
