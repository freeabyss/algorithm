package science.freeabyss.algorihm.sort.visual;

import science.freeabyss.algorihm.util.ArrayUtil;
import science.freeabyss.algorihm.util.draw.StdDraw;

import static science.freeabyss.algorihm.util.VistualSortUtil.exch;
import static science.freeabyss.algorihm.util.VistualSortUtil.less;

/**
 * 选择排序可视化
 * Created by abyss on 25/07/2017.
 */
public class Selection {
    public static void sort(double[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a, j, min)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        double[] array = ArrayUtil.randomArr(100, 5, 20);
        sort(array);
        StdDraw.filledRectangleArr(array);
    }

}
