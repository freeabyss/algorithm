package science.freeabyss.algorithm.sort.visual;

import science.freeabyss.algorithm.util.ArrayUtil;
import science.freeabyss.algorithm.util.draw.StdDraw;

import static science.freeabyss.algorithm.util.VistualSortUtil.exch;
import static science.freeabyss.algorithm.util.VistualSortUtil.less;

/**
 * 希尔排序可视化操作
 * Created by abyss on 27/07/2017.
 */
public class Shell {

    public static void sort(double[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a, j, j - h); j -= h) {

                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        double[] array = ArrayUtil.randomArr(90, 40, 20);
        sort(array);
        StdDraw.filledRectangleArr(array);
    }
}
