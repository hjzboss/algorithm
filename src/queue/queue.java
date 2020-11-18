package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

//循环可扩容队列
public class queue<T> implements Iterable<T> {
    private T q[];//队列数组
    private int last;//队尾
    private int first;//队头
    private int n;//元素数目

    public queue(int cap){
        q = (T[])new Object[cap];
        first = 0;
        last = first;
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void enqueue(T item){
        if(n == q.length){ resize(2*q.length);}
        q[last++] = item;
        if(last == q.length) last = 0;//循环
        n++;
    }

    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        T item = q[first];
        q[first++] = null;
        n--;
        if(first == q.length) first = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    private void resize(int capacity) {//重置队列
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];//循环队列
        }
        q = copy;
        first = 0;
        last  = n;
    }

    public int size(){
        return n;
    }

    @Override
    public Iterator<T> iterator() {//实现foreach
        return new queueIterator();
    }

    private class queueIterator implements Iterator<T> {//实现迭代器
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i<n;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T item = q[(first+i) % q.length];
            i++;
            return item;
        }
    }
}
