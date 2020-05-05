import java.util.*;

public class DayFive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(firstUniqChar(sc.nextLine()));
        sc.close();
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), 1);
            } else {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i)) + 1);
            }
        }
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (hmap.get(s.charAt(i)) == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}