package Union;

public class quickUnion {
    private int[] id;//指向同一连通分量中的一个节点（可能指向它自己）
    private int count;//连通分量的数目
    private int[] size;

    public quickUnion(int N){
        count = N;
        id = new int[N];
        size = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int q,int p){
        return root(p) == root(q);
    }

    public int getCount() {
        return count;
    }

    public int root(int n){//返回节点n所在的连通分量的根节点
        while(id[n] != n) n = id[n];
        return n;
    }

    public void union(int q,int p){//合并
        int pID = root(p);
        int qID = root(q);
        if(qID == pID) return;
        if(size[pID]<size[qID]){
            id[pID] = qID;
            size[qID]+=size[pID];
        }
        else{
            id[qID] = pID;
            size[pID]+=size[qID];
        }
        count--;
    }
}
