package science.freeabyss.algorihm.sort;

import science.freeabyss.algorihm.util.io.StdRandom;

import static science.freeabyss.algorihm.util.SortUtil.exch;

/**
 * 快速排序的改进，三向切分的快速排序，主要应对包含大量重复的元素的数组。
 * 将数组分为三块，分别是大于、等于和小于
 * Created by abyss on 07/08/2017.
 */
public class Quick3way {
    private static final int M = 15;

    /**
     * 描述：
     * 代码从左往右遍历数组，维护指针lt使得 [lo ~ lt-1] 之间的元素小于v, 指针 gt 使得 [gt+1 ~ hi] 之间的元素大于 v。
     * 指针 i 使得 [lt ~ i-1] 之间的元素等于 v，[i ~ gt] 之间的元素未确定。
     * <p>
     * 过程:
     * a[i] 小于v，将 a[lt]和a[i]交换，将lt和i加一
     * a[i] 大于v，将 a[gt]和a[i]交换，将gt减一
     * a[i] 等于v，将i加一
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
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);

            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }
}
