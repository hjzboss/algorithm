package string;

import sort.SortUtils;


/**
 * 字符串三向切分快速排序
 *
 * @author hjz
 * @version 1.0
 * @date 2022/3/7 23:07
 */
public class Quick3Sort {
    /**
     * 返回字符串s的索引为d的字符
     *
     * @param s     索引字符串
     * @param index 索引的下标
     * @return 如果下标小于字符串的长度返回对应下标的字符，否则返回-1
     */
    private static int charAt(String s, int index) {
        return (index >= s.length()) ? -1 : s.charAt(index);
    }

    /**
     * 三向切分排序
     *
     * @param strings 待排序字符串数组
     */
    public static void sort(String[] strings) {
        sort(strings, 0, strings.length - 1, 0);
    }

    /**
     * 递归排序
     *
     * @param strings 待排序数组
     * @param lo      待排序部分左边界
     * @param hi      待排序部分右边界
     * @param d       根据字符串d位置的字符进行排序
     */
    private static void sort(String[] strings, int lo, int hi, int d) {
        if (lo >= hi) return;
        int v = charAt(strings[lo], d);
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            int at = charAt(strings[i], d);
            if (at < v) SortUtils.exch(strings, lt++, i++);
            else if (at > v) SortUtils.exch(strings, i, gt--);
            else i++;
        }
        // 分治排序
        sort(strings, lo, lt - 1, d);
        // 如果v<0,那么=v的部分已完成排序，无需再排
        if (v >= 0) sort(strings, lt, gt, d + 1); // =v的部分d位置的值一样，要比较d+1处的值
        sort(strings, gt + 1, hi, d);
    }

    public static void main(String[] args) {
        String[] str = {"she", "sells", "by", "the", "seashore", "seashells", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        sort(str);
        SortUtils.show(str);
    }
}
