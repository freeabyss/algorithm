package science.freeabyss.algorihm.sort;

import static science.freeabyss.algorihm.util.SortUtil.*;

/**
 * 选择排序
 * Created by abyss on 07/17/16.
 */
public class Selection {

    /**
     * 按照升序排序
     * 效率: N^2 /2 次比较和N次交换
     * <p>
     * 实现原理：
     * 遍历数组，每次从 i~ length-1 之间找出最小的元素，与i做交换
     * 特点：
     * 1、运行时间与输入无关
     * 2、数据移动是最少的。交换次数和数组的大小是线性关系（其他任何算法都不具备这个特性）
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        String[] a = "a,j,m,b,n,c,d,f,a,e,q,e,r,d,v,q,o,v,y,x,a,x,c".split(",");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
