import java.util.Scanner;
import java.util.Arrays;
public class Quicksort_Lomuto {
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int i = low - 1; 
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    private static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0 || low >= high) {
            return;
        }
        int pi = partition(array, low, high);
        quickSort(array, low, pi - 1);
        quickSort(array, pi + 1, high);
    }
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays stop recursion immediately.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            scanner.close();
            return;
        }
        if (n == 0) {
            System.out.println("Nothing to sort/search");
            scanner.close();
            return;
        }
        int[] array = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        quickSort(array, 0, n - 1);
        System.out.println("Sorted array in ascending order:"+ Arrays.toString(array));
        scanner.close();
    }
}
