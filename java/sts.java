import java.util.*;
public class sts {

    public static int boothMultiplication(int multiplier, int multiplicand) {
        int product = 0;
        while (multiplier > 0) {
            if (multiplier % 2 == 1) {
                product += multiplicand;
            }
            multiplier >>= 1;
            multiplicand <<= 1;
        }
        return product;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int multiplier = sc.nextInt();
        int multiplicand = sc.nextInt();
        int result = boothMultiplication(multiplier, multiplicand);
        System.out.println(result);
}
}
