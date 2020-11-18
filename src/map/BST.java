package map;

import queue.queue;

public class BST<Key extends Comparable<Key>, Value> {
    private node root;//根节点

    public static void main(String[] args) {
        BST<Integer, String> b = new BST<>();
        b.put(1, "fuck");
        b.put(5, "s");
        b.put(2, "f");

        Iterable<Integer> k = b.keys();
        for (int ke : k) {
            System.out.println(ke);
        }
        System.out.println(b.floor(3));
        System.out.println(b.floor(7));
    }

    public int size() {
        return size(root);
    }

    private int size(node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //    public Value get(Key key){递归实现
//        return get(root,key);
//    }
//
//    private Value get(node x,Key key){
//        if(x == null) return null;
//        if(key.compareTo(x.key)<0) return get(x.left,key);
//        else if(key.compareTo(x.key)>0) return get(x.right,key);
//        else return x.val;
//    }
    public Value get(Key key) {//非递归实现
        node t = root;
        while (t != null) {
            int cmp = key.compareTo(t.key);
            if (cmp < 0) t = t.left;
            else if (cmp > 0) t = t.right;
            else return t.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private node put(node x, Key key, Value val) {
        if (x == null) {
            return new node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max() {//找最大键
        return max(root).key;
    }

    private node max(node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    public Key min() {//找最小键
        return min(root).key;
    }

    private node min(node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public Key floor(Key key) {//寻找小于等于key的最大键
        node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private node floor(node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        else if (cmp == 0) return x;
        else {
            node t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }
    }

    public Key select(int k) {//选择排名为k的键
        node x = select(root, k);
        if (x == null) return null;
        else return x.key;
    }

    private node select(node x, int k) {
        if (x == null) return null;
        if (k < size(x.left)) return select(x.left, k);
        else if (k > size(x.left)) return select(x.right, k - x.left.N - 1);
        else return x;
    }

    public int rank(Key key) {//查找键key的排名
        return rank(root, key);
    }

    public int rank(node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public void deletemin() {
        root = deletemin(root);
    }

    private node deletemin(node x) {
        if (x.left == null) return x.right;
        x.left = deletemin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private node delete(node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            node t = x;
            x = min(x.right);
            x.right = deletemin(x.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        queue<Key> q = new queue<Key>(size());
        keys(root, q, lo, hi);
        return q;
    }

    private void keys(node x, queue<Key> q, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, q, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) q.enqueue(x.key);
        if (cmphi > 0) keys(x.right, q, lo, hi);
    }

    private class node {//节点类
        Key key;
        Value val;
        node left, right;
        int N;

        public node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
}

