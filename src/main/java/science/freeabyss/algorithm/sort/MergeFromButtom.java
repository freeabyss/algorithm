package science.freeabyss.algorithm.sort;

import static science.freeabyss.algorithm.util.SortUtil.less;

/**
 * 归并排序，自底而上的排序方式
 * Created by abyss on 01/08/2017.
 */
public class MergeFromButtom {
    private static Comparable[] aux;

    /**
     * 自底而上的排序方式，根据子数组的大小进行两两归并
     * <p>
     * 自底向上的时间复杂度是 1/2NlgN 和 NlgN 次比较，最多访问数组 6NlgN次。
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz + sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                merge(a, lo, lo + sz + 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }


    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
