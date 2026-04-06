import java.util.Arrays;
import java.util.Scanner;

public class Fibonaccisearch {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays return not found (-1).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array: ");
        int size = sc.nextInt();
        if (size < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            sc.close();
            return;
        }
        if (size == 0) {
            System.out.println("Nothing to sort/search");
            sc.close();
            return;
        }

        int[] arr = new int[size];
        System.out.println("Enter array elements in non-decreasing (sorted) order: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Entered Array: " + Arrays.toString(arr));

        if (!isSorted(arr)) {
            System.out.println("Invalid input: Fibonacci Search requires a sorted array in non-decreasing order.");
            sc.close();
            return;
        }

        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();

        int result = fibonaccisearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }

        sc.close();
    }

    public static int fibonaccisearch(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int fnminus2 = 0;
        int fnminus1 = 1;
        int fn = fnminus1 + fnminus2;

        while (fn < n) {
            fnminus2 = fnminus1;
            fnminus1 = fn;
            fn = fnminus1 + fnminus2;
        }

        int offset = -1;

        while (fn > 1) {
            int i = Math.min(offset + fnminus2, n - 1);

            if (arr[i] < key) {
                fn = fnminus1;
                fnminus1 = fnminus2;
                fnminus2 = fn - fnminus1;
                offset = i;
            } else if (arr[i] > key) {
                fn = fnminus2;
                fnminus1 = fnminus1 - fnminus2;
                fnminus2 = fn - fnminus1;
            } else {
                return i;
            }
        }

        if (fnminus1 == 1 && offset + 1 < n && arr[offset + 1] == key) {
            return offset + 1;
        }

        return -1;
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
