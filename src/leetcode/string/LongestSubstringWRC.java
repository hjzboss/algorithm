package leetcode.string;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWRC {
    /**
     * 思路：将遍历的字符都加入set中，如果有重复就退出，计算最大长度
     * 如果在j处发生重复，说明i与j之间是不重复的，下次比较可以直接从j开始，无须从i开始
     * 所以j定义在循环外
     * <p>
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 82.22%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 61.92%
     * 的用户
     */
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int i = 0, N = str.length, j = 0;
        int max = 0;

        while (i < N) {
            while (j < N) {
                if (set.contains(str[j])) {
                    break;
                }
                set.add(str[j]);
                j++;
            }

            //在下次开始查找前移除第一项
            set.remove(str[i]);
            max = (j - i) > max ? j - i : max;
            i++;
        }

        return max;
    }

    /**
     * 第一次尝试的方法：使用一个boolean数组来表示字符是否已存在，在内部循环每次结束时都重新初始化数组
     * <p>
     * 执行用时：
     * 13 ms
     * , 在所有 Java 提交中击败了
     * 25.93%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 98.73%
     * 的用户
     */
    public int lengthOfLongestSubstring1(String s) {
        char[] str = s.toCharArray();
        boolean[] alp = new boolean[127];

        int i = 0, N = str.length;
        int max = 0;

        while (i < N) {
            int len = 1;
            alp[(int) str[i]] = true;
            int j = i + 1;
            while (j < N) {
                if (alp[(int) str[j]]) break;
                alp[(int) str[j]] = true;
                len++;
                j++;
            }
            max = len > max ? len : max;
            i++;
            Arrays.fill(alp, false);
        }

        return max;
    }

    /**
     * 滑动窗口：滑动窗口的有边界逐渐右移，将无重复的元素添加进来，
     * 如果是重复元素，将窗口的左边界移动至重复元素的右边一位，窗口向右移动（窗口就是最长子串）
     * <p>
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 82.22%
     * 的用户
     * 内存消耗：
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 97.01%
     * 的用户
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        //键为字符，值为下标
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //左边界右移
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
