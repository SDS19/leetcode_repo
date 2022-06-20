package sort.quicksort;

import org.junit.jupiter.api.Test;

public class QuickSort_3 {

    public static void sort(int[] a){
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l<r) {
            int pivotIdx = partition(a,l,r);
            quickSort(a,l,pivotIdx);
            quickSort(a,pivotIdx+1,r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int pivot = a[(l+r)>>1];
        int i = l-1;
        int j = r+1;

        do {//find bigger element
            i++;
        }while (a[i]<pivot);
        do {
            j--;
        }while (a[j]>pivot);

        if (i<j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        } else return j;

        return -1;
    }

    @Test
    public void test(){
        int[] arr = {2,6,5,3,8,7,1,0};
        sort(arr);
        for (int a:arr) {
            System.out.print(a+",");
        }
    }
}
