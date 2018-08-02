package science.freeabyss.algorithm.leetcode;

/**
 * We are to write the letters of a given string {@code S}, from left to right into lines.
 * Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units,
 * it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a',
 * widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions: how many lines have at least one character from {@code S},
 * and what is the width used by the last such line? Return your answer as an integer list of length 2.
 *
 * @author abyss
 * @date 2018/4/22
 */
public class NumberOfLines {

    public static int[] solution(int[] widths, String S) {
        int line = 0;
        int maxWidth = 0;
        for (char a : S.toCharArray()) {
            int width = widths[a - 'a'];
            if ((maxWidth += width) > 100) {
                maxWidth = width;
                line++;
            }
        }
        return new int[]{line, maxWidth};
    }
}
