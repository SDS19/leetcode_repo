package sort.quicksort;

import org.junit.jupiter.api.Test;

public class BubbleSort {
    public int[] sort(int[] a){
        for (int i = a.length-1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return a;
    }

    @Test
    void test(){
        int[] a = {1,2,3,4,5};
        int[] b = {5,4,3,2,1};
        for (int i:sort(b)) {
            System.out.print(i+" ");
        }
    }
}
