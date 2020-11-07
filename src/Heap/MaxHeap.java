package Heap;

/*优先队列--堆*/
public class MaxHeap<T extends Comparable<T>> {
    private T pq[];
    private int size;

    public MaxHeap(int size) {
        pq = (T[]) new Comparable[size + 1];
        this.size = 0;
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
            System.out.println("heap is empty!");
            return null;
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

    public static void sort(Comparable[] a) {//堆排序算法
        int N = a.length - 1;
        for (int i = N / 2; i >= 0; i--) {//建立堆
            sink(a, i, N);
        }
        while (N > 0) {//堆排序，将堆头结点和尾结点换位置，然后再排除尾结点进行循环
            Comparable temp = a[0];
            a[0] = a[N];
            a[N] = temp;
            N--;
            sink(a, 0, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {//将数组建立成堆的下沉操作，从0开始的完全二叉树，左孩子为
        //2k+1而不是2k
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

    public boolean isFull() {
        return size == pq.length - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public static void main(String[] args) {
        MinHeap<Integer> mh = new MinHeap<>(5);
        mh.insert(1);
        mh.insert(6);
        mh.insert(3);
        mh.delete();
        mh.delete();
        System.out.println(mh.delete());
    }
}
