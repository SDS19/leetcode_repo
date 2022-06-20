package test;

public class _148 {
    public static int[] sortList(int[] a){
        quickSort(a,0,a.length-1);
        return a;
    }
    private static void quickSort(int[] a, int l, int r){
        if (l<r){
            int pivotIdx = partition(a, l, r);
            quickSort(a,l,pivotIdx-1);
            quickSort(a,pivotIdx+1,r);
        }
    }
    private static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;

        for (int j = l; j < r; j++) {
            if (a[j]<=pivot) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        int tmp = a[i+1];
        a[i+1] = pivot;
        a[r] = tmp;

        return i+1;
    }
}
