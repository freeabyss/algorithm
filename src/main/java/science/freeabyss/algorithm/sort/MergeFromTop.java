package science.freeabyss.algorithm.sort;

import science.freeabyss.algorithm.util.io.StdOut;

import static science.freeabyss.algorithm.util.SortUtil.less;

/**
 * 归并排序 自顶而下的排序方式
 * Created by abyss on 07/20/16.
 */
public class MergeFromTop {


    private static Comparable[] aux;

    /**
     * 自顶向下的排序方式 (lg 是指以2为底的对数)
     * 长度为N的数组需要 1/2NlgN 至 NlgN次比较
     * 对于长度为N的任意数组，自顶向下的归并排序最多需要访问数组 6NlgN 次。
     * <p>
     * 对于归并排序，它的时间复杂度度和 NlgN成正比，空间复杂度和N成正比。
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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

    public static void main(String[] args) {
        double mergeTime = SortCompare.timeRandomInput("Merge", 100000, 100);
        StdOut.println("Merge Time : " + mergeTime);
    }
}
