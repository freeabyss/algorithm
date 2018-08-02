package science.freeabyss.algorithm.leetcode;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * @author abyss
 * @date 2018/4/22
 */
public class ArrayPairSum {

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length % 2; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}
