package sort;

/**
 * 排序工具类
 *
 * @author hjz
 * @version 1.0
 * @date 2022/3/7 23:17
 */
public class SortUtils {
    /**
     * 判断v是否小于w
     *
     * @return v小于w返回true
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 字符串按位置d比较大小
     *
     * @param d 待比较的位置
     * @return v小于w返回true
     */
    public static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    /**
     * 小于等于判断
     *
     * @return v小于或等于w返回true
     */
    public static boolean lessAndEqual(Comparable v, Comparable w) {
        return ((v.compareTo(w) < 0) || (v.compareTo(w) == 0));
    }

    /**
     * 交换数组a中a[i]和a[j]元素的位置
     *
     * @param a 交换数组
     * @param i 第一个下标
     * @param j 第二个下标
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 输出数组a中所有的元素
     *
     * @param a 待输出数组
     */
    public static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.println(comparable + " ");
            System.out.println();
        }
    }

    /**
     * 判断数组a是否有序
     *
     * @param a    待判断数组
     * @param flag flag = true则判断是否为顺序，否则判断是否为逆序
     * @return 有序返回true
     */
    public static boolean isSorted(Comparable[] a, boolean flag) {
        if (flag) {
            for (int i = 1; i < a.length; i++) {
                if (less(a[i], a[i - 1])) return false;
            }
        } else {
            for (int i = 1; i < a.length; i++) {
                if (less(a[i - 1], a[i])) return false;
            }
        }
        return true;
    }
}
