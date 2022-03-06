package string;

import sort.Insertion;

import java.util.Arrays;

/**
 * 高位优先的字符串排序
 *
 * @author hjz
 * @version 1.0
 * @date 2022/3/6 22:54
 */
public class MSD {
    private static final int M = 15; // 小数组阈值
    private static final int R = 256; // 基数
    private static String[] aux; // 辅助数组

    /**
     * 返回字符串s的索引为d的字符
     *
     * @param s 索引字符串
     * @param d 索引的下标
     * @return 如果下标小于字符串的长度返回对应下标的字符，否则返回-1
     */
    private static int charAt(String s, int d) {
        return (d > s.length()) ? -1 : s.charAt(d);
    }

    /**
     * 高位优先的字符串排序算法
     *
     * @param a 待排序的字符串数组
     */
    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, d);
            return;
        }
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int i = lo; i <= hi; i++) {
            sort(a, lo + count[i], lo + count[i + 1] - 1, d - 1);
        }
    }

    public static void main(String[] args) {
        String[] str = {"she", "sells", "by", "the", "seashore", "seashells", "the", "shells", "she", "sells", "are", "surely", "seashells"};
        sort(str);
        System.out.println(Arrays.toString(str));//[are, by, seashells, seashells, seashore, sells, sells, she, she, shells, surely, the, the]
    }
}
