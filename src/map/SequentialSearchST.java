package map;

import queue.queue;

/*
* 基于无序链表的查找表，顺序查找
* */
public class SequentialSearchST<Key,Value> {
    private node first=null;
    private int size = 0;
    private class node{
        Key key;
        Value val;
        node next;

        public node(Key key, Value val, node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(node x = first;x != null;x = x.next){
            if(x.key.equals(key)) return x.val;
        }
        return null;
    }

    public void put(Key key,Value val){
        if(key == null){
            throw new NullPointerException();
        }
        for(node x = first;x != null;x = x.next){
            if(x.key.equals(key)){
                x.val = val;
                return;
            }
        }
        first = new node(key,val,first);//如果没有找到，头插法插入节点
        size++;
    }

    public int size(){
        return this.size;
    }

    public Value delete(Key key){
        node x;
        node temp;
        Value v;
        if(first.key.equals(key)){
            temp = first;
            v = temp.val;
            temp = null;
            first = first.next;
            return v;
        }
        temp = first;
        for(x = temp.next ;x!=null;x = x.next,temp = temp.next){
            if(x.key.equals(key)){
                temp.next = x.next;
                v = x.val;
                x = null;
                return v;
            }
        }
        return null;
    }

    public Iterable<Key> keys(){
        queue<Key> q = new queue<Key>(size);
        for(node x = first;x!=null;x=x.next){
            q.enqueue(x.key);
        }
        return q;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        st.put("fuck",1);
        st.put("fuck",st.get("fuck")+1);
        System.out.println(st.get("fuck"));
        st.put("shit",1);
        System.out.println(st.size());
        System.out.println(st.delete("fuck"));
        System.out.println(st.get("fuck"));
    }
}
