package bag;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {//背包的链表实现,链栈的实现与其类似
    private node first;
    private class node{
        T value;
        node next;
    }

    public void add(T item){//向背包中添加数据
        node oldfirst = first;
        first = new node();
        first.value = item;
        first.next = oldfirst;
    }

    @Override
    public Iterator<T> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<T>{//foreach循环
        private node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T val = current.value;
            current = current.next;
            return  val;
        }
    }

}
