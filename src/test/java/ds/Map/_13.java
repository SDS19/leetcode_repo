package ds.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class _13 {

    /** runtime: 11 ms 36.07%
     *  memory usage: 47 MB 22.48% */
    public int romanToInt(String s) {
        Map<Character, Integer> map = romanIntMap();
        if (s.length() == 1) return map.get(s.charAt(0));
        char[] chs = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < chs.length-1; i++) {
            if (map.get(chs[i]) >= map.get(chs[i+1])) sum += map.get(chs[i]);
            else sum -= map.get(chs[i]);
            if (i == chs.length-2) sum += map.get(chs[i+1]);
        }

        return sum;
    }

    private Map<Character, Integer> romanIntMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }

    /** runtime: 7 ms 61.97%
     *  memory usage: 45.6 MB 48.63% */
    private int[] romanToArray() {
        int[] a = new int[26];
        a['I'-'A'] = 1;
        a['V'-'A'] = 5;
        a['X'-'A'] = 10;
        a['L'-'A'] = 50;
        a['C'-'A'] = 100;
        a['D'-'A'] = 500;
        a['M'-'A'] = 1000;
        return a;
    }

    public int romanToInt_1(String s) {
        int[] a = romanToArray();

        if (s.length() == 1) return a[s.charAt(0)-'A'];

        int sum = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length-1; i++) {
            if (a[chs[i]-'A'] >= a[chs[i+1]-'A']) sum += a[chs[i]-'A'];
            else sum -= a[chs[i]-'A'];
            if (i == chs.length-2) sum += a[chs[i+1]-'A'];
        }

        return sum;
    }

    /** runtime: 4 ms 95.64%
     *  memory usage: 42.6 MB 88.47% */
    public int romanToInt_11(String s) {
        int[] a = romanToArray();

        char prev = 'A';
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (a[c-'A'] > a[prev-'A'])
                sum -= 2*a[prev-'A'];
            sum += a[c-'A'];
            prev = c;
        }

        return sum;
    }

    /** runtime: 4 ms 95.69%
     *  memory usage: 42.3 MB 95.81% */
    public int romanToInt_2(String s) {
        int sum = 0, prev = 1000;//skip the first if(v > prev)
        for (char c : s.toCharArray()) {
            int i = getInt_2(c);
            if (i > prev) sum -= prev*2;
            sum += i;
            prev = i;
        }
        return sum;
    }

    private int getInt_2(char c){
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /** runtime: 4 ms 95.64%
     *  memory usage: 42 MB 98.80% */
    public int romanToInt_3(String s) {
        int sum = 0, prev = 0;
        for (char c : s.toCharArray()) {
            int i = getInt_3(c, prev);
            sum += i;
            prev = i;
        }
        return sum;
    }

    private int getInt_3(char c, int prev){
        switch (c) {
            case 'I': return 1;
            case 'V': return prev == 1 ? 3 : 5;
            case 'X': return prev == 1 ? 8 : 10;
            case 'L': return prev == 10 ? 30 : 50;
            case 'C': return prev == 10 ? 80 : 100;
            case 'D': return prev == 100 ? 300 : 500;
            case 'M': return prev == 100 ? 800 : 1000;
            default: return 0;
        }
    }

    @Test
    void test(){
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        Assertions.assertEquals(3,romanToInt_3(s1));
        Assertions.assertEquals(58,romanToInt_3(s2));
        Assertions.assertEquals(1994,romanToInt_3(s3));
    }



}
