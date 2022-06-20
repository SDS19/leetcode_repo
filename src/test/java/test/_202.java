package test;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class _202 {
    /** runtime: 1 ms 97.76%
     *  memory usage: 40.7 MB 72.11% */
    public boolean isHappy_1(int n) {
        while (n >= 10) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10)*(n%10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1 || n == 7;
    }

    /** runtime: 4 ms 19.71%
     *  memory usage: 40.7 MB 70.16% */
    public boolean isHappy_2(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10)*(n%10);
                n /= 10;
            }
            if (!set.add(sum)) return false;
            n = sum;
        }

        return true;
    }

    @Test
    void test() {
        int n = 109;
        System.out.println(isHappy_1(n));
    }
}
