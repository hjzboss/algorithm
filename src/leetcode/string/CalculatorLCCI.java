package leetcode.string;

import java.util.Stack;

/**
 * 面试题 16.26. 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 示例 2:
 * 输入: " 3/2 "
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * <p>
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class CalculatorLCCI {
    /**
     * 思路：遇见数字则入栈，遇见符号则判断符号并寻找下一个数字
     * <p>
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 91.96%
     * 的用户
     * 内存消耗：
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 86.98%
     * 的用户
     */
    public int calculate(String s) {
        if (s == null || s.equals("")) return 0;
        Stack<Integer> str = new Stack<>();
        //消除头尾空字符并转换为字符数组
        char[] c = s.trim().toCharArray();
        int i = 0, N = c.length, sum = 0;

        while (i < N) {
            //判断是否为空格
            if (c[i] == ' ') {
                i++;
                continue;
            }

            //保存运算符
            char temp = c[i];
            int num = 0;

            //判断是否为运算符
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                i++;
                //查找第二个运算数
                while (i < N && c[i] == ' ') i++;
            }

            //判断是否为数字
            while (i < N && Character.isDigit(c[i])) {
                //操作数可能不是一位
                num = num * 10 + c[i] - '0';
                i++;
            }

            //如果temp为加号或者操作数，直接将数字入栈。
            switch (temp) {
                case '-': {
                    num = -num;
                    break;
                }
                case '*': {
                    num = str.pop() * num;
                    break;
                }
                case '/': {
                    num = str.pop() / num;
                    break;
                }
                default: {
                    break;
                }
            }
            str.push(num);
        }

        //出栈相加
        while (!str.isEmpty()) {
            sum += str.pop();
        }

        return sum;
    }
}
