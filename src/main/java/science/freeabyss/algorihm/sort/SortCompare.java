package science.freeabyss.algorihm.sort;

import science.freeabyss.algorihm.util.io.StdIn;
import science.freeabyss.algorihm.util.io.StdOut;
import science.freeabyss.algorihm.util.io.StdRandom;
import science.freeabyss.algorihm.util.time.Stopwatch;

/**
 * 排序算法对比
 * Created by abyss on 27/07/2017.
 */
public class SortCompare {
    private static final String INSERTION = "Insertion";
    private static final String SELECTION = "Selection";
    private static final String SHELL = "Shell";
    private static final String SHELLOP = "ShellOp";
    private static final String QUICK = "Quick";
    private static final String MERGE = "Merge";
    private static final String HEAP = "Heap";

    public static void main(String[] args) {
        String alg1, alg2;
        int n, t;
        String[] arguments;
        if (args != null && args.length == 4) {
            arguments = args;
        } else {
            String input = StdIn.readLine();
            arguments = input.split("\\s+");
        }
        alg1 = arguments[0];
        alg2 = arguments[1];
        n = Integer.parseInt(arguments[2]);
        t = Integer.parseInt(arguments[3]);

        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        StdOut.printf("%s elapsed time %.3f\n", alg1, t1);
        StdOut.printf("%s elapsed time %.3f\n", alg2, t2);
        StdOut.printf("For %d random Doubles \n  %s is ", n, alg1);
        StdOut.printf(" %.2f times faster than %s\n", t2 / t1, alg2);
    }

    /**
     * 计算一次排序的耗时
     *
     * @return 返回排序时间，单位秒
     */
    public static double time(String alg, Comparable[] a) {
        Stopwatch stopwatch = new Stopwatch();
        switch (alg) {
            case INSERTION:
                Insertion.sort(a);
                break;
            case SELECTION:
                Selection.sort(a);
                break;
            case SHELL:
                Shell.sort(a);
                break;
            case SHELLOP:
                ShellOp.sort(a);
                break;
            case QUICK:
            case MERGE:
                MergeFromTop.sort(a);
                break;
            case HEAP:
            default:
        }
        return stopwatch.elapsedTime();
    }

    /**
     * 排序t个长度为n的数组,并计算其耗时
     *
     * @return 返回排序时间，单位秒
     */
    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
}
