package science.freeabyss.algorithm.util;

import science.freeabyss.algorithm.util.io.StdRandom;

/**
 * 数组相关的操作
 * Created by abyss on 25/07/2017.
 */
public class ArrayUtil {
    /**
     * 生成随机double 数组
     *
     * @param max    最大值
     * @param min    最小值
     * @param length 长度
     * @return
     */
    public static double[] randomArr(double max, double min, int length) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = StdRandom.nextDouble(max, min);
        }
        return array;
    }

    public static Double[] randomDoubleArr(double max, double min, int length) {
        Double[] array = new Double[length];
        for (int i = 0; i < length; i++) {
            array[i] = StdRandom.nextDouble(max, min);
        }
        return array;
    }

    public static Integer[] randomIntegerArr(int max, int min, int length) {
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = StdRandom.nextInt(max, min);
        }
        return array;
    }
}
