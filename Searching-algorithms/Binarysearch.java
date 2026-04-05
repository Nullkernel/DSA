import java.util.Scanner;
import java.util.Arrays;

public class Binarysearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array: ");
        int size = sc.nextInt();
        System.out.println("Enter Array elements in non-decreasing (sorted) order: ");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));

        if (!isSorted(arr)) {
            System.out.println("Invalid input: Binary Search requires a sorted array in non-decreasing order.");
            sc.close();
            return;
        }

        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();
        int result = binarysearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }
        sc.close();
    }
    public static int binarysearch(int[] arr, int key) {
        int low = 0; 
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
