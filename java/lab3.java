import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {
        String[] namesArray = {"abc preetham", "akhil qwe", "aravindan aaa", "surya bnm", "aaa rahul"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name or surname: ");
        String find = scanner.next();

        int additionalSearches = linearSearch(namesArray,find);

        if (additionalSearches == -1) {
            System.out.println("Person not found");
        } else {
            System.out.println(namesArray[additionalSearches] + " searches found");
        }

        System.out.println(additionalSearches);
        scanner.close();
    }

    public static int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            String[] splitName = array[i].split(" ");

            if (splitName[0].startsWith(key) || splitName[1].startsWith(key)) {
                return i; 
            }
        }

        return -1;  
    }
}
