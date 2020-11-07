package map;

public class LinearProbingHashST<Key,Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST(){
        this(16);
    }

    public LinearProbingHashST(int cap){
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        for(int i = hash(key);keys[i] != null;i++){
            if(keys[i].equals(key)) return vals[i];
        }
        return null;
    }

    public void put(Key key,Value val){
        if(N >= M/2) resize(2*M);
        int i;
        for(i = hash(key);keys[i]!=null;i = (i + 1) % M){
            if(keys[i].equals(key)) vals[i] = val;
            return;
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    private void resize(int cap){
        LinearProbingHashST<Key,Value> t;
        t = new LinearProbingHashST<>(cap);
        for(int i = 0;i < M;i++){
            if(keys[i]!=null){
                t.put(keys[i],vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        this.M = t.M;
    }

    public void delete(Key key){
        if(!isContain(key)) return;
        int i = hash(key);
        while(!key.equals(keys[i])) i = (1+i)%M;
        keys[i] = null;
        vals[i] = null;
        for(i = (i+1) % M;keys[i]!=null;i = (i+1) % M){
            Key temp1 = keys[i];
            Value temp2 = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(temp1,temp2);
        }
        N--;
        if(N>0&&N == M/8) resize(M/2);
    }

    public boolean isContain(Key key){
        for(int i = hash(key);keys[i] != null;i++){
            if(keys[i].equals(key)) return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        LinearProbingHashST<Integer, String> hashST = new LinearProbingHashST<>();
//        hashST.put(1,"bode");
//        hashST.put(2,"haga");
//        hashST.put(3,"ma");
//        hashST.put(3,"shit");
//        System.out.println(hashST.get(2));
//        hashST.delete(1);
//        System.out.println(hashST.get(1));
//        for(int i = 1;i<=3;i++){
//            System.out.println(hashST.get(i));
//        }
//    }
}
