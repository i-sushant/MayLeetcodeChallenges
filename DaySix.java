import java.util.*;

public class DaySix {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < m.length(); i++) {
            if (!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            } else {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hmap.entrySet();
        int maxFreq = nums.length / 2;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;

    }
}