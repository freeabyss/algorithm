package science.freeabyss.algorithm.other;

/**
 * 将阿拉伯数字转化为中文
 * Created by abyss on 3/11/16.
 */
public class NumberToChinese {
    private static String[] mChnNum = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九",};
    private static String[] mChnUnit = {"", "十", "百", "千",};
    private static String[] mChnUnitSection = {"", "万", "亿", "万亿"};


    public static void main(String[] args) {
        long[] testNUm = {20001234, 294967295};
        for (long t : testNUm) {
            System.out.printf(t + " ->");
            System.out.println(NumberToChinese.toChinese(t));
        }
    }

    /**
     * 将数字转换为中文
     */
    public static String toChinese(long number) {
        String result = "";
        int unitPos = 0;
        boolean needZero = false;
        while (number > 0) {
            long section = number % 10000;
            String sectionStr = sectionToChinese(section);
            if (needZero) {
                result = mChnNum[0] + result;
            }
            // 添加节权位
            sectionStr = section == 0 ? sectionStr : sectionStr + mChnUnitSection[unitPos++];
            // 判断需不需要在前方补零
            needZero = (section < 1000) && (section > 0);
            result = sectionStr + result;
            number /= 10000;
        }
        return result;

    }

    /**
     * 小节数字转化为中文
     */
    public static String sectionToChinese(long number) {
        String result = "";
        int unitPos = 0;
        boolean zero = true;
        while (number > 0) {
            int w = (int) (number % 10);

            if (w != 0) {
                zero = false;
                result = mChnUnit[unitPos] + result;
                result = mChnNum[w] + result;
            } else {
                if (number == 0 || !zero) {
                    result = mChnNum[w] + result;
                    zero = true;
                }
            }
            unitPos++;
            number /= 10;
        }
        return result;
    }
}
