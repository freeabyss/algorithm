package science.freeabyss.algorihm.util;

/**
 * 排序工具
 * Created by abyss on 07/17/16.
 */
public final class SortUtil {
    /**
     * @return true:  a < b
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }



    /**
     * 交换 元素
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }



    /**
     * 输出数组
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }
}
