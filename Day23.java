import java.util.*;

public class Day23 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[1] < b[0])
                i++;
            else if (b[1] < a[0])
                j++;
            else {
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);

                result.add(new int[] { start, end });
                if (a[1] < b[1])
                    i++;
                else
                    j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}