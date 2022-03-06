package sort;

public class Insertion implements Sort {
    // 字符串插入排序
    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && Sort.less(a[j], a[j - 1], d); j--) {
                Sort.exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi + 1; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i; j > lo && Sort.less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i; j > 0 && Sort.less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }
}
