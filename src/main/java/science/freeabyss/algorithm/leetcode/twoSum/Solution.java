package science.freeabyss.algorithm.leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution().twoSum(new int[]{3, 3}, 6);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (result.containsKey(temp) && result.get(temp) != i) {
                return new int[]{result.get(temp), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }
}
