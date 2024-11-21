import java.util.*;

public class fibonacci {
    
    public static int[] computeFibonacci(int n) {
        int[] a = new int[n];
        if(n <= 0) {
            System.out.println("not a valid number");
        }
        if (n == 1) {
            a[0] = 0;
        }
        if (n == 2) {
            a[0] = 0;
            a[1] = 1;
        }
        if (n > 2) {
            a[0] = 0;
            a[1] = 1;
            for(int i = 2; i < n; i++) {
                a[i] = a[i-1] + a[i-2];
            }
        }
        return a;
    
    }
    
    public static void main(String[] args) throws Exception {
        Scanner daScanner = new Scanner(System.in);
        System.out.println("how many fibonacci numbers do you want?");
        int n = daScanner.nextInt();
        int[] array = computeFibonacci(n);

        // System.out.println("Would you like to print the array?");

        for(int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        daScanner.close();
    }
}
