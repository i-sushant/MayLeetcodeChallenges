class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int total_sum = 0;
        int max_end = 0;
        int min_end = 0;
        int max_sum = Integer.MIN_VALUE;
        int min_sum = Integer.MAX_VALUE;

        for (int x : A) {
            total_sum += x;
            max_end = Math.max(max_end + x, x);
            max_sum = Math.max(max_end, max_sum);
            min_end = Math.min(min_end + x, x);
            min_sum = Math.min(min_end, min_sum);
        }
        if (max_sum > 0) {
            return Math.max(max_sum, total_sum - min_sum);
        }
        return max_sum;
    }
}