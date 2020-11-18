package sort;

import Heap.MaxHeap;
import Stopwatch.StopWatch;

import java.util.Random;

public class demo1 {
    public static void main(String[] args) {
        Integer[] a = new Integer[1000000];
        Integer[] b = new Integer[1000000];
        Integer[] c = new Integer[1000000];
        Integer[] d = new Integer[1000000];
        Random random = new Random();
        Shell sh = new Shell();
        QuickSort qs = new QuickSort();
        for(int i = 0;i<a.length;i++){
            a[i] = random.nextInt();
            b[i] = random.nextInt();
            c[i] = random.nextInt();
            d[i] = random.nextInt();
        }

        StopWatch s1 = new StopWatch();
        MaxHeap.sort(a);
        System.out.println(s1.elapsedTime());
        System.out.println(Sort.isorted(a));//堆排序略慢与快速排序

        StopWatch s2 = new StopWatch();
        qs.sort(b);
        System.out.println(s2.elapsedTime());
        System.out.println(Sort.isorted(b));//快速排序最快

        StopWatch s3 = new StopWatch();
        sh.sort(c);
        System.out.println(s3.elapsedTime());
        System.out.println(Sort.isorted(c));//希尔排序最次

        StopWatch s4 = new StopWatch();
        Merge.sort2(d);
        System.out.println(s4.elapsedTime());//归并排序次之
        System.out.println(Sort.isorted(d));


    }
}
