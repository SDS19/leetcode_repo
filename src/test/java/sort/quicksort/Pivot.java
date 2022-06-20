package sort.quicksort;

public class Pivot {
    /**
     * Permutation a,b,c => 3*2*1 = 6
     * b<a<c, c<a<b return a
     * a<b<c, c<b<a return b
     * a<c<b, b<c<a return c
     */
    public static int pivot_1(int[] arr){
        int a = arr[0], b = arr[arr.length>>1], c = arr[arr.length-1];
        return ((a>b)^(a>c)) ? a : ((b<a)^(b<c)) ? b : c;
    }

    public static int pivot_2(int[] arr){
        int a = arr[0], b = arr[arr.length>>1], c = arr[arr.length-1];
        return ((a-b)*(b-c)>0 ? b : ((a-b)*(a-c)<0 ? a : c));
    }
}
