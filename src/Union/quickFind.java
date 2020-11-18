package Union;

import java.util.Scanner;

public class quickFind {
    private int[] id;//分量id，在相同的分量之中id相同
    private int count;//连通分量的数目

    public quickFind(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
    }

    public boolean connected(int q,int p){
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public int find(int n){//返回节点n所在的连通分量id
        return id[n];
    }

    public void union(int q,int p){//合并
        int pID = find(p);
        int qID = find(q);

        if(qID == pID) return;
        for(int i = 0;i<id.length;i++){
            if(id[i] == pID) id[i] = qID;
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        quickFind qF = new quickFind(N);
        while(!in.hasNext("#")){
            int p = in.nextInt();
            int q = in.nextInt();
            if(qF.connected(q,p)) continue;
            qF.union(p,q);
            System.out.println(p+" "+q);
        }
        System.out.println(qF.count+"componets");
    }
}
