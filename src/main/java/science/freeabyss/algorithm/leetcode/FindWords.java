package science.freeabyss.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * @author abyss
 * @date 2018/4/25
 */
public class FindWords {
    static int[] wordsOfWeight = {
            1, 2, 2, 1, 0, 1, 1, // ABCDEFG
            1, 0, 1, 1, 1, 2, 2, // HIJKLMN
            0, 0, 0, 0, 1, 0,  // OPQ RST
            0, 2, 0, 2, 0, 2,  // UVW XYZ

            3, 3, 3, 3, 3, 3, // [ \]^_`

            1, 2, 2, 1, 0, 1, 1, // abcdefg
            1, 0, 1, 1, 1, 2, 2, // hijklmn
            0, 0, 0, 0, 1, 0,  // opq rst
            0, 2, 0, 2, 0, 2,  // uvw xyz
    };

    public static String[] solution(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isOnOneLine(word)) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    public static String[] solution1(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    private static boolean isOnOneLine(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (wordsOfWeight[word.charAt(i) - 'A'] != wordsOfWeight[word.charAt(i + 1) - 'A']) {
                return false;
            }
        }
        return true;
    }
}
