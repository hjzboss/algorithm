package leetcode.string;

/**
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * <p>
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * <p>
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 * <p>
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * <p>
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * <p>
 * 输入：s = "spo"
 * 输出："ops"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class IncreasingDecreasingString {
    /**
     *  该题有点类似于z字排序，创建一个26大小的数组，每个位置相当于一个桶
     *  把s中的每个字符分别放到对应的桶里，比如a放到第一个桶里，b放到第2个桶里……。
     * 第1次从左往右遍历26个桶，从每个桶里拿出一个字符(如果没有就不用拿)
     * 第2次从右往左遍历26个桶，从每个桶里拿出一个字符(如果没有就不用拿)
     * ……
     * 一直这样循环下去，直到所有的桶里的元素都拿完为止。
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 87.61%
     * 的用户
     */
    public String sortString(String s) {
        char[] str = s.toCharArray();
        byte[] table = new byte[26];
        char[] nStr = new char[str.length];
        int index = 0;
        for (char c : str) {
            table[c - 'a']++;
        }

        while (index < nStr.length) {
            for (int i = 0; i < 26; i++) {
                if (table[i] != 0) {
                    nStr[index++] = (char) (i + 'a');
                    table[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (table[i] != 0) {
                    nStr[index++] = (char) (i + 'a');
                    table[i]--;
                }
            }
        }

        return new String(nStr);
    }
}
