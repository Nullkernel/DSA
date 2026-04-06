import java.util.Scanner;
import java.util.Arrays;

public class Linearsearch {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays return not found (-1).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the Array: ");
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
        System.out.println("Enter Array elements: ");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered Array: " + Arrays.toString(arr));
        System.out.println("Enter the key element to be Found: ");
        int key = sc.nextInt();
        int result = linearsearch(arr, key);
        if (result != -1) {
            System.out.println("Element " + key + " Found at Index: " + result);
        } else {
            System.out.println("Element " + key + " was NOT Found in the entered Array.");
        }
        sc.close();
    }
    public static int linearsearch(int[] arr, int key){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
