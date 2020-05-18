import java.util.*;

public class Day17 {
    public static void main(String[] args) {
        System.out.println(optimalFindAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        // HashMap<String, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        int j = p.length() - 1;
        int n = s.length();
        int m = p.length();
        char pc[] = p.toCharArray();
        Arrays.sort(pc);
        String pst = new String(pc);
        for (int i = 0; i <= n - m && j < n; i++) {
            char c[] = s.substring(i, j + 1).toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if (str.equals(pst)) {
                l.add(i);
            }
            j++;
        }
        return l;
    }

    public static List<Integer> optimalFindAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<Integer>();
        if (s.length() == 0 || s == null) {
            return l;
        }
        int freq[] = new int[26];
        for (char x : p.toCharArray()) {
            freq[x - 'a']++;
        }
        
        int i = 0, j = 0, count = p.length();
        while (j < s.length()) {
            if (freq[s.charAt(j++) - 'a']-- >= 1)
                count--;
            if (count == 0)
                l.add(i);
            if (j - i == p.length() && freq[s.charAt(i++) - 'a']++ >= 0)
                count++;
        }
        return l;
    }
}