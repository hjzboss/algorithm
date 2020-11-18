package UndirectedGraphs;

/*
* 利用深度遍历求连通分量
* */
public class CC {
    private int count;//连通分量标号
    private boolean marked[];
    private int id[];//每个节点所属连通分量的标号

    public CC(graph g){
        this.count = 0;
        marked = new boolean[g.getV()];
        id = new int[g.getV()];
        for(int i = 0;i < g.getV();i++){
            if(!marked[i]){
                dfs(g,i);
                count++;
            }
        }
    }

    private void dfs(graph g,int s){
        marked[s] = true;
        id[s] = count;
        for(int w:g.adj(s)){
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    public boolean isConnected(int v,int w){
        return id[v] == id[w];
    }

    public int getCount() {
        return count;
    }

    public int getId(int v){
        return id[v];
    }
}
