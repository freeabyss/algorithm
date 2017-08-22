package science.freeabyss.algorithm.sort;

import science.freeabyss.algorithm.util.ArrayUtil;

import static science.freeabyss.algorithm.util.SortUtil.exch;
import static science.freeabyss.algorithm.util.SortUtil.less;
import static science.freeabyss.algorithm.util.SortUtil.show;

/**
 * 希尔排序的优化，采用了更有效的递增序列，由 9*4^i-9*2^i+1 和2^(i+2) *(2^(i+2) -3) +1 计算得到
 * <p>
 * 效率比一般的希尔排序，提高了20%左右
 * Created by abyss on 29/07/2017.
 */
public class ShellOp {

    public static void sort(Comparable[] a) {
        int[] increase = new int[a.length];
        int index = -1;
        int i = 0;
        while (true) {
            increase[++index] = (9 * (int) Math.pow(4, i) - 9 * (int) Math.pow(2, i) + 1);
            if (increase[index] > a.length) {
                index--;
                break;
            }
            increase[++index] = (int) Math.pow(2, i + 2) * ((int) Math.pow(2, i + 2) - 3) + 1;
            if (increase[index] > a.length) {
                index--;
                break;
            }
            i++;
        }

        for (int h; index >= 0; index--) {
            h = increase[index];
            for (int k = h; k < a.length; k++) {
                for (int j = k; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }
    }

    public static void main(String[] args) {
        Double[] arr = ArrayUtil.randomDoubleArr(200, 40, 10);
        sort(arr);
        show(arr);
    }
}
