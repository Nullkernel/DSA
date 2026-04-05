import java.util.Arrays;
import java.util.Scanner;

public class Fibonaccisearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("Enter the key element to be found: ");
        int key = sc.nextInt();

        int result = fibonacciSearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " found at index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT found in the array.");
        }

        sc.close();
    }

    public static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;

        int fibMm2 = 0;
        int fibMm1 = 1;
        int fibM = fibMm1 + fibMm2;

        while (fibM < n) {
            fibMm2 = fibMm1;
            fibMm1 = fibM;
            fibM = fibMm1 + fibMm2;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibMm2, n - 1);

            if (arr[i] < key) {
                fibM = fibMm1;
                fibMm1 = fibMm2;
                fibMm2 = fibM - fibMm1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibMm2;
                fibMm1 = fibMm1 - fibMm2;
                fibMm2 = fibM - fibMm1;
            } else {
                return i;
            }
        }

        if (fibMm1 == 1 && offset + 1 < n && arr[offset + 1] == key) {
            return offset + 1;
        }

        return -1;
    }
}
