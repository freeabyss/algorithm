package science.freeabyss.algorithm.sort;

import science.freeabyss.algorithm.util.io.StdRandom;

import static science.freeabyss.algorithm.util.SortUtil.exch;
import static science.freeabyss.algorithm.util.SortUtil.less;

/**
 * 快速排序
 * Created by abyss on 07/08/2017.
 */
public class Quick {
    /**
     * 快速排序算法的效率依赖于用于切分元素的值。快速排序是同为 O(N*lgN)的几种排序中效率最高的。
     * 快速排序平均需要 ~2NlnN次比较，以及1/6的交换。
     * 快速排序最多需要约 N^2/2 次比较，但随机打乱数组可以预防这种情况。
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
