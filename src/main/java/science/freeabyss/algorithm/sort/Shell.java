package science.freeabyss.algorithm.sort;

import science.freeabyss.algorithm.util.ArrayUtil;

import static science.freeabyss.algorithm.util.SortUtil.*;

/**
 * 希尔排序
 * Created by abyss on 27/07/2017.
 */
public class Shell {
    /**
     * 希尔排序是基于插入排序的快速排序。 插入排序是对间隔为1的元素进行交换，而希尔排序是对间隔为h的元素进线交换。
     * 希尔排序的思想是使数组中任意间隔为h的元素都是有序的。这样的数组被称为h有序数组。
     * <p>
     * 希尔排序的重点在于h增序序列的选择。
     * <p>
     * 目前无法准确的描述希尔排序的性能，可以确定的是，它的运行时间达不到平方级别。
     * <p>
     * 希尔排序是个性价比很高的排序方式，代码量少，不需要额外的内存空间。其他更加高效的排序方式，也只可能比希尔排序快两倍。
     */
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] array = ArrayUtil.randomIntegerArr(90, 40, 30);
        sort(array);
        assert isSorted(array);
        show(array);
    }
}
