package science.freeabyss.algorihm.search;

import java.util.Arrays;

/**
 * 二分查找算法，输入的数组必须是有序的。
 * Created by abyss on 07/07/2017.
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key > a[mid]) low = mid + 1;
            else if (key < a[mid]) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 2, 7, 9, 10, 11, 14, 6};
        Arrays.sort(list);
        System.out.println(rank(11, list));
        System.out.println(rank(12, list));
        System.out.println(rank(10, list));
    }
}
