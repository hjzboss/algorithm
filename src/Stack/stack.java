package Stack;

import java.util.EmptyStackException;
import java.util.Iterator;

//LIFO栈
public class stack<T> implements Iterable<T> {
    private T st[];
    private int top;//栈顶
    private int N;//栈的容量

    public stack(int cap){
        this.N = cap;
        st = (T[]) new Object[cap];
        this.top = -1;
    }

    public int size(){
        return this.top+1;
    }

    public boolean isEmpty(){
        return this.top==-1;
    }

    public T pop(){//保持数组不会浪费很多空间，如果只有1/4，数组容量就减半
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            T temp = st[top];
            st[top--] = null;
            if(this.top+1 == st.length/4) resize(st.length/2);
            return temp;
        }
    }

    public void push(T elem){
        if(++top == st.length) resize(2*st.length);
        st[top] = elem;
    }

    public void resize(int max){//动态数组扩容
        T[] temp = (T[]) new Object[max];
        for(int i = 0;i < N;i++){
            temp[i] = st[i];
        }
        st = temp;
    }

    @Override
    public Iterator<T> iterator() {//返回迭代器,实现Iterable接口
        return new ReverseIterator();
    }

    public class ReverseIterator implements Iterator<T>{//实现一个迭代器，能够使用foreach循环遍历栈（后进先出遍历）
        private int i = top;//内部类可以访问私有字段

        @Override
        public boolean hasNext() {
            return i>-1;
        }

        @Override
        public T next() {
            return st[i--];
        }
    }

    public void foreach(){//正常遍历数组
        for(T a:st){
            if(a!=null)
            System.out.println(a);
            else break;
        }
    }
}
