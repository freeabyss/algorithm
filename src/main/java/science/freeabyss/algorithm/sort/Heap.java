package science.freeabyss.algorithm.sort;

import science.freeabyss.algorithm.util.io.StdOut;

import static science.freeabyss.algorithm.util.SortUtil.exch;
import static science.freeabyss.algorithm.util.SortUtil.less;

/**
 * 堆排序
 * 堆排序是唯一能够同时最优的利用空间和时间的方法。
 * 堆排序较多用于嵌入式或低成本的设备中，因为它无法利用缓存。数组元素很少和相邻的其他元素进行比较，因此缓存未命中的次数远远高于其他排序。
 * <p>
 * 不过用堆排序实现的优先队列应用场合越来越多。
 * Created by abyss on 11/09/2017.
 */
public class Heap {
    /**
     * 堆排序只需要少于 2NlgM +2N 次比较以及一半次数的交换。
     * 2N项来自堆的构造，2NlgN来自每次下沉操作最大可能需要2lgN次比较。
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
            while (n > 1) {
                exch(a, 1, n--);
                sink(a, 1, n);
            }
        }
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (i * 2 <= n) {
            int j = i * 2;
            if (j < n && less(a[j], a[j + 1])) j++;
            if (!less(a[i], a[j])) break;
            exch(a, i, j);
            i = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 4, 5, 6, 2, 3, 4, 5, 6, 7, 32, 2, 4, 4};
        sort(a);
        StdOut.println(a);

    }
}
