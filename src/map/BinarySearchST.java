package map;

import queue.queue;

public class BinarySearchST <Key extends Comparable<Key>,Value>{
    private Key[] keys;
    private Value[] vals;
    int N;

    public BinarySearchST(int Capacity) {
        keys = (Key[]) new Comparable[Capacity];
        vals = (Value[]) new Object[Capacity];
        N = 0;
    }

    private int rank(Key key){//利用二分查找查询小于key的键的数目
        int lo = 0,hi = N - 1;
        int mid,cmp;
        while(lo<=hi){
            mid = (lo + hi) / 2;
            cmp = key.compareTo(keys[mid]);
            if(cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int r = rank(key);
        if(r < N && keys[r] == key) return vals[r];
        else return null;
    }

    public void put(Key k,Value v){
        int i = rank(k);
        if(i < N && keys[i] == k) {
            vals[i] = v;
            return;
        }
        for(int j = N;j > i;j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = k;
        vals[i] = v;
        N++;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key select(int i){
        return keys[i];
    }

    public Key ceiling(Key k){//返回大于等于k的最小键
        int i = rank(k);
        return keys[i];
    }

    public void delete(Key key){
        int i = rank(key);
        if(i < N && keys[i] == key){
            for(int j = i;j < N - 1;j++){
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            N--;
        }
    }

    public Key floor(Key key){//返回小于等于key的最大键
        int i = rank(key);
        if(i < N && keys[i] == key) return keys[i];
        else if(i < N && keys[i] != key) return keys[i-1];
        else return max();
    }

    public boolean contain(Key key){
        int i = rank(key);
        if(i < N && keys[i] == key) return true;
        else return false;
    }

    public Iterable<Key> keys(Key lo,Key hi){
        queue<Key> q = new queue<Key>(N);
        for(int i = rank(lo);i < rank(hi);i++){
            q.enqueue(keys[i]);
        }
        if(contain(hi)) q.enqueue(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys(){//得到键的队列
        queue<Key> q = new queue<Key>(N);
        for(int i = 0;i < N;i++){
            q.enqueue(keys[i]);
        }
        return q;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(20);
        st.put(1,"小瓜");
        st.put(0,"噶");
        st.put(5,"切得");
        st.put(7,"gua");
        st.delete(0);
        System.out.println(st.floor(10));

        Iterable<Integer> keys = st.keys();
        for (int a:keys) {
            System.out.println(a);
        }
    }
}
