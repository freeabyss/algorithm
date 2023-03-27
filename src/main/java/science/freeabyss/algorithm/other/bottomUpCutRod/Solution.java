package science.freeabyss.algorithm.other.bottomUpCutRod;

public class Solution {

    public static void main(String[] args) {
        int[] p = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        new Solution().bottomUpCutRod(p, 4);
        System.out.println(new Solution().s(6));

    }

    public int bottomUpCutRod(int[] p, int n) {
        int[] temp = new int[n + 1];
        int q;
        for (int i = 1; i < n + 1; i++) {
            q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                q = Math.max(q, p[j] + temp[i - j]);
            }
            temp[i] = q;
        }
        return temp[n];
    }

    /**
     *
     */

    public int s(int n) {
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i < temp.length; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }
}
