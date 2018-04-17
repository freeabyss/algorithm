package science.freeabyss.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abyss
 * @date 2018/4/17
 */
public class SelfDividingNumbers {
    public static List<Integer> solution(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (isSelfDividing(i)) resultList.add(i);
        }
        return resultList;
    }

    public static boolean isSelfDividing(int n) {
        for (char a : String.valueOf(n).toCharArray()) {
            if (a == '0' || n % (a - '0') > 0) {
                return false;
            }
        }
        return true;
    }
}
