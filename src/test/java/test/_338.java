package test;

public class _338 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i>>1] + (i & 1);//ans[i] = ans[i/2] + i%2
        }

        return ans;
    }
}
