package sort.quicksort;

import org.junit.jupiter.api.Test;

/**
 * average case: O(nlogn) <= median of three
 *   worst case: O(n^2) <= random pick / fixed pick
 */
public class QuickSort_1 {

    public static void sort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int pivotIdx = partition(a, l, r);//pivot index
            quickSort(a, l, pivotIdx-1);
            quickSort(a, pivotIdx+1, r);
        }
    }

    private static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;//smaller element index

        //swap smaller element to the left
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        //swap pivot and arr[i+1]
        int temp = a[i+1];
        a[i+1] = pivot;
        a[r] = temp;

        return i+1;
    }

    @Test
    public void test(){
        int[] arr = {2,6,5,3,8,7,1,0};
        sort(arr);
        //Arrays.sort(arr);
        for (int a:arr) {
            System.out.print(a+",");
        }
    }

}
