package Heap;

public class MinHeap<T extends Comparable<T>> {
    private T pq[];
    private int size;

    public MinHeap(int size) {
        pq = (T[]) new Comparable[size + 1];
        this.size = 0;
    }

    public void insert(T value) {//上浮操作
        if (isFull()) return;
        int i = ++this.size;
        for (; i > 1 && pq[i / 2].compareTo(value) > 0; i = i / 2) {
            pq[i] = pq[i / 2];
        }
        pq[i] = value;
    }

    public T delete() {//下沉操作，将最底部的元素换到顶部再逐渐下沉
        if (isEmpty()) {
            System.out.println("heap is empty!");
            return null;
        }
        T min = pq[1];
        T temp = pq[size];
        pq[size--] = null;//防止对象游离
        int parent = 1;
        int child;
        for (; 2 * parent <= size; parent = child) {//与书上相比不需要很多的交换
            child = 2 * parent;
            if ((child != this.size) && less(child + 1, child)) child++;
            if (pq[child].compareTo(temp) >= 0) break;
            else pq[parent] = pq[child];
        }
        pq[parent] = temp;
        return min;
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

//    public static void main(String[] args) {
//        MinHeap<Integer> im = new MinHeap<>(5);
//        im.insert(1);
//        im.insert(5);
//        im.insert(0);
//        im.insert(-1);
//        System.out.println(im.delete());
//    }
}

