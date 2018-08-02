package science.freeabyss.algorithm.leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * @author abyss
 * @date 2018/4/25
 */
public class ReverseString {

    public static String solution(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        return String.valueOf(array);
    }

    public static String solution1(String s) {
        return reverseString(s);
    }

    public static String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }

    public static String solution2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}
