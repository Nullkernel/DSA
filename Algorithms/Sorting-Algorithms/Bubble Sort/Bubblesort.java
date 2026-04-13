import java.util.Scanner;
import java.util.Arrays;

public class Bubblesort {
/*
* Edge-case behavior:
* - Negative size is rejected.
* - Size 0 exits early with "Nothing to Sort.".
* - Null/Empty Arrays are ignored by the algorithm.
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array size: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            sc.close();
            return;
        }
        if (n == 0) {
            System.out.println("Nothing to Sort.");
            sc.close();
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));
        bubblesort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
    public static void bubblesort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
