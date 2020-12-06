package Heap;

import java.util.Arrays;

/*优先队列--堆*/
public class MaxHeap<T extends Comparable<T>> {
    private final T[] pq;
    private int size;

    public MaxHeap(int size) {
        pq = (T[]) new Comparable[size + 1];
        this.size = 0;
    }

    /**
     * 堆排序算法
     *
     * @param a 排序的数组(需要实现Comparable接口)
     */
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        buildHeap(a,N);
        //堆排序，将堆头结点和尾结点换位置，然后再排除尾结点进行循环
        while (N > 0) {
            Comparable temp = a[0];
            a[0] = a[N];
            a[N] = temp;
            N--;
            sink(a, 0, N);
        }
    }

    /**
     * 将数组建立成堆的下沉操作，从0开始的完全二叉树，左孩子为2k+1而不是2k，仅适用于堆排序算法
     *
     * @param a 被操作的数组
     * @param k 下沉操作开始的位置
     * @param N 右边界
     */
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k + 1 <= N) {
            int j = 2 * k + 1;
            if (j < N && a[j].compareTo(a[j + 1]) < 0) j++;
            if (a[k].compareTo(a[j]) > 0) break;
            Comparable temp = a[k];
            a[k] = a[j];
            a[j] = temp;
            k = j;
        }
    }

    /**
     * 建立堆
     * @param a 要转换为堆的数组
     * @param N 右边界
     */
    private static void buildHeap(Comparable[] a,int N){
        //建立堆操作，从有子树的节点开始下沉
        for (int i = N / 2; i >= 0; i--) {
            sink(a, i, N);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 8, 0, -1, 3, 6};
        MaxHeap.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insert(T value) {//上浮操作
        if (isFull()) return;
        int i = ++this.size;
        for (; i > 1 && pq[i / 2].compareTo(value) < 0; i = i / 2) {
            pq[i] = pq[i / 2];
        }
        pq[i] = value;
    }

    public T delete() {//下沉操作，将最底部的元素换到顶部再逐渐下沉
        if (isEmpty()) {
            throw new NullPointerException("the heap is empty!");
        }
        T max = pq[1];
        T temp = pq[size];
        pq[size--] = null;//防止对象游离
        int parent = 1;
        int child;
        for (; 2 * parent <= size; parent = child) {//与书上相比不需要很多的交换
            child = 2 * parent;
            if ((child != this.size) && less(child, child + 1)) child++;
            if (pq[child].compareTo(temp) <= 0) break;
            else pq[parent] = pq[child];
        }
        pq[parent] = temp;
        return max;
    }

    public boolean isFull() {
        return size == pq.length - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
