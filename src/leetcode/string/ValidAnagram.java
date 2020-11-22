package leetcode.string;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class ValidAnagram {

    /**
     *  数组映射：字符串中字符所对应的数组下标即是将该字符减去'a'所得到的值，第一个字符串遍历都会使其数组中对应值的值加一，
     *             第二个字符串的遍历会使其值减一
     *  最后判断数组中的值是否都为0
     *
     *  执行结果：通过
     *
     * 显示详情
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.91%的用户
     *
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了82.33%的用户
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < s1.length; i++) {
            table[s1[i] - 'a']++;
            table[t1[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (table[i] != 0) return false;
        }

        return true;
    }
}
