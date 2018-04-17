package science.freeabyss.algorithm.leetcode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * @author abyss
 * @date 2018/4/13
 */
public class HammingDistance {
    public static int solution(int x, int y) {
        int z = x ^ y;
        int sum = 0;
        while (z > 0) {
            sum += z & 1;
            z = z >> 1;
        }
        return sum;
    }

    public static int solution1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int solution2(int x, int y) {
        int d = 0;
        int bitxor = x ^ y;
        while (bitxor > 0) {
            if (bitxor % 2 == 1) {
                d++;
            }
            bitxor = bitxor >> 1;
        }
        return d;
    }

}
