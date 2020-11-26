package leetcode.string;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    /**
     * 我的思路：利用栈，遇见左括号入栈，遇见右括号出栈比较
     * <p>
     * 执行结果：通过
     * 显示详情
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.12%的用户
     * 内存消耗：36.5 MB, 在所有 Java 提交中击败了83.81%的用户
     */
    public boolean isValid(String s) {
        if (s.equals("")) return true;

        Stack<Character> opr = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char temp = s.charAt(i);
            switch (temp) {
                case '(':
                case '[':
                case '{': {
                    opr.push(temp);
                    break;
                }
                case ')': {
                    if (opr.isEmpty() || opr.pop() != '(') return false;
                    break;
                }
                case ']': {
                    if (opr.isEmpty() || opr.pop() != '[') return false;
                    break;
                }
                case '}': {
                    if (opr.isEmpty() || opr.pop() != '{') return false;
                    break;
                }
            }
            i++;
        }

        return opr.isEmpty();
    }
}
