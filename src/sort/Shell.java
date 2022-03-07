package sort;

import java.util.LinkedList;
import java.util.Queue;

public class Shell implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        Comparable temp;
        while (h < N / 3) h = h * 3 + 1;
        while (h >= 1) {
            int i, j;
            for (i = h; i < N; i++) {
                temp = a[i];
                for (j = i; j >= h && SortUtils.less(temp, a[j - h]); j -= h) {
                    a[j] = a[j - h];
                }
                a[j] = temp;
            }
            h = h / 3;
        }
    }
}
