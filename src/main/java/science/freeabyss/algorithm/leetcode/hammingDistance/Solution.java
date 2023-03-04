package science.freeabyss.algorithm.leetcode.hammingDistance;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 *
 * https://leetcode.cn/problems/hamming-distance/solutions/?favorite=2cktkvj
 */
public class Solution {
    /**
     * Brian Kernighan 算法，每循环一次 去除最右侧的 1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int result = 0;
        while (temp != 0) {

            temp = temp & (temp - 1);
            result++;
        }
        return result;
    }
}
