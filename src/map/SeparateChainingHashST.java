package map;

/*
 *基于链表的散列表
 *  */
public class SeparateChainingHashST<Key, Value> {
    private final int M;
    private final SequentialSearchST<Key, Value>[] st;
    private int N;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int cap) {
        this.M = cap;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> s = new SeparateChainingHashST<>();
        s.put("fuck", 1);
        s.put("shit", 2);

        System.out.println(s.get("shit"));
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
}
