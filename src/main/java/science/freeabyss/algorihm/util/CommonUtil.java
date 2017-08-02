package science.freeabyss.algorihm.util;

/**
 * 通用的工具函数
 * Created by abyss on 25/07/2017.
 */
public class CommonUtil {
    /**
     * 延时函数
     * @param millis 毫秒
     */
    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
