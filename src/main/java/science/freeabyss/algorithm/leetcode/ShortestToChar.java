package science.freeabyss.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 *
 * @author abyss
 * @date 2018/4/26
 */
public class ShortestToChar {


    public static int[] solution(String S, char C) {
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int d1 = S.lastIndexOf(C, i);
            int d2 = S.indexOf(C, i);
            if (d1 == -1) {
                result[i] = d2 - i;
                continue;
            }
            if (d2 == -1) {
                result[i] = i - d1;
                continue;
            }
            result[i] = Math.min(i - d1, d2 - i);
        }
        return result;
    }

    /**
     * 记录 C 在 S 中的索引，通过索引计算 C 与 S 中每个 char 的距离。
     */
    public static int[] solution1(String S, char C) {
        List<Integer> list = new ArrayList<>();
        // create a list with location indices of character
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] answer = new int[S.length()];
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            // increment the count if the distance proves to be bigger compared
            // with the next one
            if ((count + 1) != list.size() &&
                    Math.abs(i - list.get(count)) > Math.abs(i - list.get(count + 1))) {
                count++;
            }
            answer[i] = Math.abs(i - list.get(count));
        }
        return answer;
    }

    /**
     * 第一次从前向后遍历， 计算 i 处char 与 前面 C的距离。
     * 第二次从后向前遍历，计算 i 处 char 与 后面 C的距离。
     */
    public static int[] solution2(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C) pos = i;
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }

    /**
     *  与上一个思路类似。
     */
    public static int[] solution3(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i) res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i) res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] ints = solution3("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));

    }
}
