package science.freeabyss.algorihm.sort.visual;

import science.freeabyss.algorihm.util.ArrayUtil;
import science.freeabyss.algorihm.util.draw.StdDraw;

import static science.freeabyss.algorihm.util.VistualSortUtil.exch;
import static science.freeabyss.algorihm.util.VistualSortUtil.less;

/**
 * 可视化插入排序
 * Created by abyss on 25/07/2017.
 */
public class Insertion {

    public static void sort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array, j, j - 1); j--) {
                exch(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        double[] array = ArrayUtil.randomArr(100, 20, 10);
        sort(array);
        StdDraw.filledRectangleArr(array, null);
    }
}
