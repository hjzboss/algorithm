package Heap;

import java.util.HashMap;
import java.util.NoSuchElementException;

//索引优先队列
public class IndexMPQ<T extends Comparable<T>> {
    private T pq[];
    private HashMap<Integer, T> map;
    private HashMap<T, Integer> reverseMap;
    private int size;

    public IndexMPQ(int size) {
        pq = (T[]) new Comparable[size + 1];
        map = new HashMap<Integer, T>();
        reverseMap = new HashMap<T, Integer>();
        this.size = 0;
    }

    public void insert(int k, T value) {//上浮操作
        if (isFull()) return;
        int i = ++this.size;
        for (; i > 1 && pq[i / 2].compareTo(value) > 0; i = i / 2) {
            pq[i] = pq[i / 2];
        }
        pq[i] = value;
        map.put(k, value);
        reverseMap.put(value, k);
    }

    public int deleteMin() {//下沉操作，将最底部的元素换到顶部再逐渐下沉
        if (isEmpty()) {
            throw new NoSuchElementException("the heap is empty！");
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
        int t = reverseMap.get(min);
        reverseMap.remove(min);
        map.remove(t);
        return t;
    }

    public void change(int k, T value) {
        if (!map.containsKey(k)) throw new NoSuchElementException("no key!");
        T t = map.get(k);
        map.put(k, value);
        reverseMap.put(value, k);
        for (int i = 1; i <= size; i++) {
            if (pq[i].compareTo(t) == 0) {
                pq[i] = value;
                resize(i);
                break;
            }
        }
    }

    //重新调整堆
    private void resize(int i) {
        sink(i);
        swim(i);
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
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

    public int minIndex() {
        return reverseMap.get(pq[1]);
    }

    public T min() {
        return pq[0];
    }

//    public static void main(String[] args) {
//        IndexMPQ<Integer> pq = new IndexMPQ<>(5);
//        pq.insert(1, 5);
//        pq.insert(2, 8);
//        pq.insert(3, -1);
//
//        System.out.println(pq.deleteMin());
//        pq.insert(3, -2);
//        pq.change(1, -4);
//        System.out.println(pq.deleteMin());
//        System.out.println(pq.deleteMin());
//        System.out.println(pq.deleteMin());
//    }
}
