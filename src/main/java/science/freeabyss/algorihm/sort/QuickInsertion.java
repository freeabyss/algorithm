package science.freeabyss.algorihm.sort;

import science.freeabyss.algorihm.util.io.StdRandom;

/**
 * 快速排序的改进，对小数组使用插入排序
 * Created by abyss on 07/08/2017.
 */
public class QuickInsertion {
    private static int M = 15;

    /**
     * 对于小数组，插入排序要比快速排序快
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = Quick.partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

}
