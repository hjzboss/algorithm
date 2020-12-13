package string;

import java.util.ArrayList;

/**
 * 定长字符串基数排序ArrayList版本
 */
public class RadixSortA {
    /**
     * 定长字符串基数排序ArrayList版本
     *
     * @param arr       要排序的字符串数组
     * @param stringLen 数组中定长字符串的长度
     */
    public static void sort(String[] arr, int stringLen) {
        final int BUCKETS = 256;
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<String>();
        }

        for (int pos = stringLen - 1; pos >= 0; pos--) {
            for (String s : arr) {
                buckets[s.charAt(pos)].add(s);
            }

            int idx = 0;
            for (ArrayList<String> thisBuckets : buckets) {
                for (String s : thisBuckets) {
                    arr[idx++] = s;
                }

                thisBuckets.clear();
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"213", "132", "123", "231"};
        RadixSortA.sort(str, 3);
        for (String s : str) {
            System.out.println(s);
        }
    }
}
