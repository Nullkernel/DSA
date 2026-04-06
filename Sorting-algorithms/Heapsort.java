import java.util.Scanner;
import java.util.Arrays;
public class Heapsort {
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays are ignored by sort/heapify.
     */
    public void sort(int arr[]) {
      if (arr == null || arr.length == 0) {
        return;
      }
      int n = arr.length;
      for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
      }
      for (int i = n - 1; i >= 0; i--) {
        int tmp = arr[0];
        arr[0] = arr[i];
        arr[i] = tmp;
        heapify(arr, i, 0);
      }
    }
    void heapify(int arr[], int n, int i) {
      if (arr == null || n <= 0) {
        return;
      }
      int max = i; 
      int leftChild = 2 * i + 1;
      int rightChild = 2 * i + 2;
      if (leftChild < n && arr[leftChild] > arr[max])
        max = leftChild;
      if (rightChild < n && arr[rightChild] > arr[max])
        max = rightChild;
      if (max != i) {
        int swap = arr[i];
        arr[i] = arr[max];
        arr[max] = swap;
        heapify(arr, n, max);
      }
    }
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number of elements in the array : ");
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
      for(int i = 0; i <n; i++){
        arr[i] = sc.nextInt();
      }
      System.out.println("Original array : "+ Arrays.toString(arr));
      Heapsort hs = new Heapsort();
      hs.sort(arr);
      System.out.println("Sorted array:"+ Arrays.toString(arr));
      sc.close();
      }
}
