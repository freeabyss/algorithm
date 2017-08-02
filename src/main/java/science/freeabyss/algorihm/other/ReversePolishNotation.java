package science.freeabyss.algorihm.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达法
 * 逆波兰表达式的生成和计算机
 * Created by abyss on 04/25/16.
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(calcRPN(toRPN("2*3+3+4+6+7+23")));
    }

    /**
     * 计算逆波兰表达式
     */
    public static String calcRPN(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String exp : list) {
            if (isNumber(exp)) {
                stack.push(exp);
            } else {
                String second = stack.pop();
                String first = stack.pop();
                stack.push(calc(first, exp, second));
            }
        }

        return stack.pop();
    }

    /**
     * 将普通的四则运算表达式转化为逆波兰表达式
     */
    public static List<String> toRPN(String exp) {
        List<String> out = new ArrayList<>();
        if (exp == null || exp.length() == 0) {
            return out;
        }
        Stack<String> stack = new Stack<>();
        String num = "";
        for (int i = 0; i < exp.length(); i++) {
            String cur = exp.charAt(i) + "";
            if (isNumber(cur)) {
                num += cur;
            } else {
                if (!num.equals("")) {
                    out.add(num);
                }
                num = "";
                String top = stack.isEmpty() ? null : stack.peek();
                // 如果当前运算符是右括号或者优先级低于栈顶元素(括号除外),则将栈顶元素依次出栈并输出.
                if (isOut(top, cur)) {
                    // 依次输出直到遇到左括号为止
                    while (true) {
                        if ((top = stack.pop()).equals("(")) {
                            break;
                        }
                        out.add(top);
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }
                if (!cur.equals(")")) {
                    stack.push(cur);
                }
            }
        }
        if (!num.equals("")) {
            out.add(num);
        }
        while (!stack.isEmpty()) {
            out.add(stack.pop());
        }
        return out;
    }

    private static boolean isNumber(String s) {
        return s.matches("\\d+.?\\d*");
    }

    /**
     * 计算
     *
     * @param num1  第一个操作数
     * @param opera 操作符
     * @param num2  第二个操作数
     * @return 返回计算结果
     */
    private static String calc(String num1, String opera, String num2) {
        double res = 0;
        switch (opera) {
            case "*":
                res = Double.valueOf(num1) * Double.valueOf(num2);
                break;
            case "/":
                res = Double.valueOf(num1) / Double.valueOf(num2);
                break;
            case "+":
                res = Double.valueOf(num1) + Double.valueOf(num2);
                break;
            case "-":
                res = Double.valueOf(num1) - Double.valueOf(num2);
                break;
            default:
                break;
        }
        return res + "";
    }

    /**
     * 判断是否需要将栈内符号输出
     * cur为右括号或者优先级低于top时返回true
     *
     * @param top 栈顶符号
     * @param cur 当前符号
     * @return true:输出栈内符号,false:不需要输出
     */
    public static boolean isOut(String top, String cur) {
        if (top == null) {
            return false;
        }
        if (cur.equals(")")) {
            return true;
        }
        if (top.equals("(")) {
            return false;
        }

        int topPri = priority(top);
        int curPri = priority(cur);
        return curPri < topPri;
    }

    /**
     * 获得运算符号的优先级
     */
    private static int priority(String opera) {
        int level = 0;
        switch (opera) {
            case "*":
            case "/":
                level = 2;
                break;
            case "+":
            case "-":
                level = 1;
                break;
            default:
                break;
        }
        return level;
    }
}
