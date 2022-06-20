package sort.quicksort;

public class QuickSort_2 {

    public static void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int pivotIdx = partition(a, l, r);//pivot index
            quickSort(a, l, pivotIdx-1);
            quickSort(a, pivotIdx+1, r);
        }
    }

    private static int partition(int[] a, int l, int r){
        int pivot = a[l];
        while (l<r) {
            while (l<r && a[r]>=pivot) r--;
            a[l] = a[r];//move the smaller element to the left
            while (l<r && a[l]<=pivot) l++;
            a[r] = a[l];//move the bigger element to the left
        }
        a[l] = pivot;//insert pivot
        return l;
    }
}
