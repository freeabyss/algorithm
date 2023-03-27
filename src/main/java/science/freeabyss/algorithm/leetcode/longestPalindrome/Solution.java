package science.freeabyss.algorithm.leetcode.longestPalindrome;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?favorite=2cktkvj
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccba"));
        System.out.println(new Solution().longestPalindrome("abcba"));
        System.out.println(new Solution().longestPalindrome1("abccba"));
        System.out.println(new Solution().longestPalindrome1("abcba"));

    }

    /**
     * 中心扩散法
     * 1. 从每个位置出发，向两边扩散，直到两边字符不相等或者越界，然后记录字符的长度。
     * 2. 每次扩展得到len长度，记录最大的字符长度
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int left, right, len = 1, start = 0, maxLen = Integer.MIN_VALUE;
        int strLength = s.length();

        for (int i = 0; i < strLength; i++) {
            left = i - 1;
            right = i + 1;

            while (left > -1 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLength && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }
            while (left > -1 && right < strLength && s.charAt(left) == s.charAt(right)) {
                len += 2;
                right++;
                left--;
            }
            if (maxLen < len) {
                start = left + 1;
                maxLen = len;
            }
            len = 1;

        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 动态规划法
     * 1. 每个回文子串，去掉首尾字符后，依然是回文，因此状态转移方程 f(i,j) = S[i] ==S[j] & f(i-1,j-1)
     * 2. 创建dp， dp[i][j] ==true 表示f(i,j)是回文子串。
     * 3. 记录最大的回文子串
     */
    public String longestPalindrome1(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int strLength = s.length();
        boolean[][] dp = new boolean[strLength][strLength];
        int maxLen = 0, len, start = 0, end = 0;
        for (int i = 0; i < strLength; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;

                    len = i - j + 1;
                    if (maxLen < len) {
                        maxLen = len;
                        start = j;
                        end = i;
                    }

                }


            }
        }
        return s.substring(start, end + 1);
    }


}
