// Quick Sort:
import java.util.Scanner;
import java.util.Arrays;
public class Quicksort_Hoare{
    /*
     * Edge-case behavior:
     * - Negative size is rejected.
     * - Size 0 exits early with "Nothing to sort/search".
     * - Null/empty arrays and one-element ranges stop recursion.
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
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
        for(int i = 0; i < n; i ++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Entered array : "+ Arrays.toString(arr));
        quicksortrecursion(arr,0,n-1);
        System.out.println("Sorted Array : "+Arrays.toString(arr));
        sc.close();
    }
    public static int partition(int[] arr, int low,int high){
        int pivot = arr[(low + high)/2];
        while(low <= high){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high] > pivot){
                high--;
            }
            if(low <= high){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
    public static void quicksortrecursion(int[] arr, int low, int high){
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int pi = partition(arr,low,high);
        if(low < pi-1){
            quicksortrecursion(arr,low,pi-1);
        }
        if(high > pi){
            quicksortrecursion(arr,pi,high);
        }
    }
}
