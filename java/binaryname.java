import java.util.Arrays;
import java.util.Scanner;

public class binaryname {
    public static void main(String[] args) {

        String[] namesArray = {"abc preetham", "akhil qwe", "aravindan aaa", "surya bnm","aaa anirudh", "qwe rajkanwar"};
        Arrays.sort(namesArray);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name or surname : ");
        String searchKey = scanner.next();  

        BinarySearch(namesArray, searchKey);

        scanner.close();
    }

    public static void BinarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String[] splitName = array[mid].split(" ");

            if (splitName[0].startsWith(key) || splitName[1].startsWith(key)) {
                System.out.println("Person found: " + array[mid]);
                return;
            } else if (array[mid].compareTo(key) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("-1");
    }
}
