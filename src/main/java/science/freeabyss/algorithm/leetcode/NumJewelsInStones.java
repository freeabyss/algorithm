package science.freeabyss.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author abyss
 * @date 2018/4/12
 */
public class NumJewelsInStones {

    public static int solution(String J, String S) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            String key = String.valueOf(S.charAt(i));
            int value = map.getOrDefault(key, 0) + 1;
            map.put(key, value);
        }
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            sum += map.getOrDefault(String.valueOf(J.charAt(i)), 0);
        }
        return sum;
    }

    public static int solution2(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public static int solution3(String J, String S) {
        int res = 0;
        Set<String> setJ = new HashSet<>();
        for (char j : J.toCharArray()) setJ.add(String.valueOf(j));
        for (char s : S.toCharArray()) if (setJ.contains(String.valueOf(s))) res++;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("aA", "aAAbbbb"));
        System.out.println(solution2("aA", "aAAbbbb"));
        System.out.println(solution3("aA", "aAAbbbb"));
    }
}
