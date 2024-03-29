package sort;

/**
 * 快速排序
 */
public class QuickSort implements Sort {
    /*
     * 快速排序标准算法
     * */
    public static int partitonNormal(Comparable[] a, int lo, int hi) {
        Comparable t = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (SortUtils.less(a[++i], t)) {
                if (i >= hi) break;
            }
            while (SortUtils.less(t, a[--j])) {
                if (j <= lo) break;
            }
            if (i >= j) break;
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        Comparable temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    public static void qsNormal(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitonNormal(a, lo, hi);
        qsNormal(a, lo, j - 1);
        qsNormal(a, j + 1, hi);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{6, 5, 4, 3, 2, 1};
        QuickSort.qsNormal(a, 0, a.length - 1);
        for (int n : a) {
            System.out.println(n);
        }
    }

    @Override
    public void sort(Comparable[] a) {
        if (a == null) return;
        sort(a, 0, a.length - 1);
    }

    /**
     * 快速排序算法改进版
     *
     * @param a  要排序的数组
     * @param lo 左边界
     * @param hi 右边界
     */
    public void sort(Comparable[] a, int lo, int hi) {
        //元素较少时切换到插入排序
        if (hi <= lo + 3) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 快速排序主过程
     *
     * @param a  被排序的数组
     * @param lo 左边界
     * @param hi 右边界
     * @return 返回切分点的位置
     */
    private int partition(Comparable[] a, int lo, int hi) {
        Comparable v = select(a, lo, hi);
        int i = lo, j = hi - 1;
        while (true) {
            while (SortUtils.less(a[++i], v)) {
            }
            while (SortUtils.less(v, a[--j])) {
            }
            if (i < j) SortUtils.exch(a, i, j);
            else break;
        }
        SortUtils.exch(a, i, hi - 1);
        return i;
    }

    /**
     * 切分点的选择
     * 取数组头、中、尾三个元素，将三个元素排好序后将中位数放在数组的倒数第二个位置充当哨兵
     *
     * @param a  排序的数组
     * @param lo 左边界
     * @param hi 右边界
     * @return 切分点元素
     */
    private Comparable select(Comparable[] a, int lo, int hi) {
        int mid = (hi + lo) / 2;
        if (SortUtils.less(a[mid], a[lo])) {
            SortUtils.exch(a, mid, lo);
        }
        if (SortUtils.less(a[hi], a[lo])) {
            SortUtils.exch(a, hi, lo);
        }
        if (SortUtils.less(a[hi], a[mid])) {
            SortUtils.exch(a, hi, mid);
        }
        SortUtils.exch(a, mid, hi - 1);//将其放置在倒数第二个位置充当哨兵
        return a[hi - 1];
    }
}
