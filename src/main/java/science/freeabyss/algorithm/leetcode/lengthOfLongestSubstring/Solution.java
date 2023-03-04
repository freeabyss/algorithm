package science.freeabyss.algorithm.leetcode.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("qrsvbspk");

    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {

            char c = s.charAt(right++);
            while (set.contains(c)) set.remove(s.charAt(left++));
            set.add(c);
            res = Math.max(res, set.size());
        }
        return res;
    }

}
