package leetcode.string;

/**
 * 1576. 替换所有的问号
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，
 * 请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * 注意：你不能修改非 '?' 字符。
 *
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。
 * 如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * 示例 1：
 * 输入：s = "?zs"
 * 输出："azs"
 * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 *
 * 示例 2：
 * 输入：s = "ubv?w"
 * 输出："ubvaw"
 * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 *
 * 示例 3：
 * 输入：s = "j?qg??b"
 * 输出："jaqgacb"
 *
 * 示例 4：
 * 输入：s = "??yw?ipkj?"
 * 输出："acywaipkja"
 *
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 仅包含小写英文字母和 '?' 字符
 */
public class ReplaceAll {
    /**
     *  我的思路：找到'?'，将其赋值为'a'，找其前后两个字符，如果与之相同，则改赋值为'b'，
     *  直到不相同为止，再寻找下一个字符
     *
     *  执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 72.56%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 52.75%
     * 的用户
     */
    public String modifyString(String s) {
        if(s == null || s.equals("")) return null;
        char[] str = s.toCharArray();
        int i = 0,N = str.length;
        char temp;

        while(i < N-1){
            if(str[i] == '?'){
                temp = 'a';
                if(i == 0){
                    while(temp == str[i+1]){
                        temp++;
                    }
                }else{
                    while(temp == str[i+1] || temp == str[i-1]){
                        temp++;
                    }
                }
                str[i] = temp;
            }
            i++;
        }

        if(str[i] == '?'){
            str[i] = 'a';
            if(i != 0 && str[i] == str[i-1]) str[i] = 'b';
        }

        return new String(str);
    }
}
