package sort.quicksort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSort_1 {

    public static void sort(int[] a){
        mergeSort(a,a.length);
    }
    private static void mergeSort(int[] a, int n){
        if (n<2) return;
        int m = n>>1;
        int[] l = new int[m];
        int[] r = new int[n-m];

        for (int i = 0; i < m; i++) l[i] = a[i];
        for (int i = m; i < n; i++) r[i-m] = a[i];

        sort(l);
        sort(r);

        merge(a,l,r,m,n-m);
    }
    private static void merge(int[] a, int[] l, int[] r, int n1, int n2){
        int i = 0, j = 0, k = 0;

        //sort over the smaller array
        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }else a[k++] = r[j++];
        }

        //set the rest element in the bigger array
        while (i < n1) {
            a[k++] = l[i++];
        }
        while (j < n2) {
            a[k++] = r[j++];
        }
    }

    @Test
    public void test(){
        int[] actual = {5,1,6,2,3,4};
        int[] expected = {1,2,3,4,5,6};
        sort(actual);
        Assertions.assertEquals(true,Arrays.equals(actual,expected));

    }

}
