package science.freeabyss.algorihm.util;

import science.freeabyss.algorihm.util.draw.StdDraw;

/**
 * 排序工具，可视化版本
 * Created by abyss on 25/07/2017.
 */
public class VistualSortUtil {
    public static boolean less(double[] arr, int i, int j) {
        StdDraw.clear();
        StdDraw.filledRectangleArr(arr, i, j);
        CommonUtil.delay(2 * 1000);
        return arr[i] < arr[j];
    }

    public static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
        StdDraw.clear();
        StdDraw.filledRectangleArr(a, new int[]{i, j});
        CommonUtil.delay(2 * 1000);
    }

}
