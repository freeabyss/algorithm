package science.freeabyss.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author abyss
 * @date 2018/4/12
 */
public class UniqueMorseRepresentations {
    private static String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
            "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    //    Unique Morse Code Words
    public static int solution(String[] words) {
        Set<String> morseStr = new HashSet<>();

        for (String word : words) {
            String morseChar = "";
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                morseChar += morse[index];
            }
            morseStr.add(morseChar);
        }
        return morseStr.size();
    }

}
