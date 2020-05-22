class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> q = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        q.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.remove();
            for (int i = 0; i < map.get(curr); i++) {
                sb.append(curr);
            }
        }
        return sb.toString();

    }
}
