package leetcode.string;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 */
public class CompressStringLCCI {
    /**
     * 我的解法：遍历字符串中的字符，维护一个计数器，遇到不同的字符就恢复1，比官方题解快
     * <p>
     * 执行结果：通过
     * 显示详情
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.21%的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了88.63%的用户
     */
    public String compressString(String S) {
        if (S == null || S.length() == 0 || S.length() == 1) return S;

        char[] str = S.toCharArray();
        StringBuilder builder = new StringBuilder();
        char pre = str[0];
        short num = 0;
        builder.append(pre);
        for (char i : str) {
            if (pre == i) num++;
            else {
                builder.append(num).append(i);
                num = 1;
                pre = i;
            }
        }

        builder.append(num);
        return str.length <= builder.length() ? S : builder.toString();
    }
}
