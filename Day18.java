
public class Day18 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String p, String s) {
        if (s.length() == 0 || s == null) {
            return false;
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
                return true;
            if (j - i == p.length() && freq[s.charAt(i++) - 'a']++ >= 0)
                count++;
        }
        return false;
    }
}