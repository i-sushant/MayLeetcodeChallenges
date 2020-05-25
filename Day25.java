class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] strg = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    strg[i][j] = 1 + strg[i - 1][j - 1];
                } else {
                    strg[i][j] = Math.max(strg[i][j - 1], strg[i - 1][j]);
                }
            }
        }
        return strg[m][n];
    }
}