package science.freeabyss.algorihm.sort;

import static science.freeabyss.algorihm.util.SortUtil.exch;
import static science.freeabyss.algorihm.util.SortUtil.less;

/**
 * 插入排序
 * Created by abyss on 21/07/2017.
 */
public class Insertion {
    /**
     * 效率：平均情况下需要 ~N^2/4次比较以及 ~N^2/4次交换；
     * 最坏的情况下需要 ~N^2/2次比较和 ~N^2/2次交换；
     * 最好的情况下需要 N-1次比较和 0次交换。
     * <p>
     * 实现原理：
     * 遍历数组，0 ~ j 范围内的元素是已排好序的，每次将 i 处的元素，从 j 处开始比较，插入到 0~j 内合适的位置。
     * <p>
     * 特点：
     * 插入排序的运行时间取决于输入中元素的顺序。对应已排序的数组，它的效率是线性的。
     * 插入排序适用于以下特点的数组：
     * 1、数组中每个元素距离它的最终位置都不远
     * 2、一个有序的大数组接一个小数组
     * 3、数组中只有几个元素的位置不正确
     * <p>
     * 倒置指的是数组中的两个顺序颠倒的元素。
     * <p>
     * 当倒置的数量很少时，插入排序可能比其他任何算法都要快。
     * <p>
     * 插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加上数组的大小减一。
     */
    public static void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }

}
