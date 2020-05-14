import java.util.*;

class Solution {
    public boolean canConstruct(String r, String m) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        for (int i = 0; i < m.length(); i++) {
            if (!hmap.containsKey(m.charAt(i))) {
                hmap.put(m.charAt(i), 1);
            } else {
                hmap.put(m.charAt(i), hmap.get(m.charAt(i)) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < r.length(); i++) {
            if (hmap.containsKey(r.charAt(i)) || hmap.get(r.charAt(i)) < 1) {
                return false;
            } else {
                hmap.put(r.charAt(i), hmap.get(r.charAt(i)) - 1);
                count++;
            }
        }
        if (count == r.length()) {
            return true;
        }
        return false;
    }
}