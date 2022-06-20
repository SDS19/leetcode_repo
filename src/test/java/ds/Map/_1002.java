package ds.Map;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _1002 {

    public List<String> commonChars_1(String[] words){
        List<String> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words[0].length(); i++)
            map.put(words[0].charAt(i), map.getOrDefault(words[0].charAt(i),0)+1);

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> tmp = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) {
                char cur = words[i].charAt(j);
                if (map.containsKey(cur))
                    tmp.put(cur,Math.min(map.get(cur),tmp.getOrDefault(cur,0)+1));
            }
            map = tmp;
        }

        for (char c : map.keySet())
            for (int i = 0; i < map.get(c); i++) list.add(String.valueOf(c));

        return list;
    }

    /** runtime: 17 ms 32.06%
     *  memory usage: 44.5 MB 29.76% */
    public List<String> commonChars_11(String[] words) {
        List<String> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            Integer freq = map.get(c);
            map.put(c, freq == null ? 1 : freq+1);
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> tmp = new HashMap<>();//intersection
            for (char c : words[i].toCharArray())
                if (map.containsKey(c)) {
                    Integer freq = tmp.get(c);
                    tmp.put(c, Math.min(map.get(c), (freq == null ? 1 : freq+1)));
                }
            map = tmp;
        }

        for (char c : map.keySet())
            for (int i = 0; i < map.get(c); i++)
                list.add(String.valueOf(c));
        return list;
    }

    /** runtime: 1 ms 100.00%
     *  memory usage: 42.2 MB 93.74% */
    public List<String> commonChars_2(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++)
            last = intersection(last, count(words[i]));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                while (last[i]-- > 0)
                    list.add(String.valueOf(a));
            }
        }
        return list;
    }

    private int[] intersection(int[] a, int[] b) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++)
            arr[i] = Math.min(a[i], b[i]);
        return arr;
    }

    private int[] count(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        return arr;
    }

    @Test
    void test(){
        String[] words = {"bella", "label", "roller"};
        List<String> list = commonChars_11(words);
        for (String s : list) System.out.println(s);
    }

    @Test
    void hello(){
        for (int i = 2; i <= 1000; i++) {
            int sum = 1;
            for (int j = 2; j <= i/2; j++)
                if (i%j == 0) sum += j;
            if (sum == i) System.out.println(i);
        }
    }
}
