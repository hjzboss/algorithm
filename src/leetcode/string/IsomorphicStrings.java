package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 * 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * 输入: s = "egg", t = "add"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "paper", t = "title"
 * 输出: true
 * <p>
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsomorphicStrings {
    /**
     * 使用hash表，将两个字符串位置相同的字符建立起映射，每次遍历都会检查对应是否相等。
     * 因此需要两个表，互相映射
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        int i = 0;
        while (i < s1.length) {
            if ((s2t.containsKey(s1[i]) && s2t.get(s1[i]) != t1[i]) || t2s.containsKey(t1[i]) && t2s.get(t1[i]) != s1[i])
                return false;
            s2t.put(s1[i], t1[i]);
            t2s.put(t1[i], s1[i]);
            i++;
        }

        return true;
    }
}
