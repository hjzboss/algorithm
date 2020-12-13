package string;

import queue.queue;

import java.util.Queue;

//单词查找树
public class TrieST<Value> {
    private static final int R = 256;
    private Node root;

    public static void main(String[] args) {
        TrieST<Integer> st = new TrieST<>();
        st.put("fuck", 1);
        st.put("shit", 2);

        System.out.println(st.longestPrefixOf("fucker"));
    }

    public Value get(String Key) {
        Node x = get(root, Key, 0);
        if (x == null) return null;
        else return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        return get(x.next[key.charAt(d)], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value v, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = v;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, v, d + 1);
        return x;
    }

    //收集树中的所有单词
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        queue<String> q = new queue<String>(256);
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre, queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.enqueue(pre);
        for (int i = 0; i < R; i++) {
            collect(x.next[i], pre + i, q);
        }
    }

    //删除
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) x.val = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) return x;

        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

    //寻找最长前缀
    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    private static class Node {
        private Object val;
        private final Node[] next = new Node[R];
    }
}
