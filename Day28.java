class Solution {
    public int[] countBits(int num) {
        int[] a = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            a[i] = Integer.bitCount(i);
        }
        return a;
    }
}