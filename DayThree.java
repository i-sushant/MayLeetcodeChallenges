import java.util.*;
class Solution {
    public boolean canConstruct(String r, String magazine) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        for(int i =0; i<magazine.length();i++){
            if(hmap.get(magazine.charAt(i)) == null){
                hmap.put(magazine.charAt(i),1);
            } else {
                hmap.put(magazine.charAt(i), hmap.get(magazine.charAt(i)) + 1);
            }
        }
        int count = 0;
        for(int i = 0; i<r.length(); i++){
            if(hmap.get(r.charAt(i)) == null || hmap.get(r.charAt(i)) < 1){
                return false;
            } else {
                hmap.put(r.charAt(i) , hmap.get(r.charAt(i)) - 1);
                count++;
            }
        }
        if(count == r.length()){
            return true;
        }
        return false;
    }
}