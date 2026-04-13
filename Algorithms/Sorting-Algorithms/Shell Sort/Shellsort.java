//Shell sort:
import java.util.Scanner;
import java.util.Arrays;
public class Shellsort {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays are ignored by the algorithm.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size : ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input: size cannot be negative.");
            sc.close();
            return;
        }
        if (n == 0) {
            System.out.println("Nothing to sort/search");
            sc.close();
            return;
        }
        System.out.println("Enter array elements : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("Sorted array : " + Arrays.toString(arr));
        sc.close();
    }
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
