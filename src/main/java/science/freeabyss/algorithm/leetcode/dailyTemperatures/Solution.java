package science.freeabyss.algorithm.leetcode.dailyTemperatures;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/daily-temperatures/?favorite=2cktkvj
 */
public class Solution {


    public static void main(String[] args) {
        new Solution().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int num = 0;
            int j = i + 1;
            while (true) {
                num++;
                if (j == temperatures.length) {
                    num = 0;
                    break;
                }
                if (temperatures[i] < temperatures[j++]) {
                    break;
                }
            }
            answer[i] = num;
        }
        return answer;
    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])) {
                int preIndex = stack.poll();
                answer[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return answer;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int y = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                answer[i] = 1;
            } else {
                y = answer[i + 1];
                while (temperatures[i] >= temperatures[i + y] && answer[i + y] != 0) {
                    y += answer[i + y];
                }
                if (temperatures[i] < temperatures[i + y]) {
                    answer[i] = y;
                } else {
                    answer[i] = 0;
                }
            }
        }
        return answer;
    }
}
