package science.freeabyss.algorithm.leetcode;

import java.util.stream.IntStream;

/**
 * Given a positive integer, output its complement number. The complement strategy is to
 * flip the bits of its binary representation.
 * <p>
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * @author abyss
 * @date 2018/4/24
 */
public class NumberComplement {
    public static int solution(int num) {
        String binary = Integer.toBinaryString(num);
        char[] c = binary.toCharArray();
        for (int i = 0; i < c.length; i++) {
            c[i] = c[i] == '0' ? '1' : '0';
        }
        return Integer.parseInt(String.valueOf(c), 2);
    }

    public static int solution1(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    public static int solution2(int num) {
        int mask = ~0;
        while ((num & mask) != 0) mask <<= 1;
        return ~mask & ~num;
    }

    public static void main(String[] args) {
        IntStream.range(2, 50).forEach(x -> {
            System.out.println(Integer.toBinaryString(x));
            int a = solution2(x);
            System.out.println(Integer.toBinaryString(a));
        });

    }
}
