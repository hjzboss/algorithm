package directedGraphs;

/*
 * 计算有向图的强连通分量
 * */
public class kosarajuSCC {
    private boolean marked[];
    private int id[];//连通分量id
    private int count;//连通分量的数目

    //具体理解参考博客园收藏
    public kosarajuSCC(directedGraph g) {
        marked = new boolean[g.getV()];
        id = new int[g.getV()];
        count = 0;
        DepthFirstOrder bfo = new DepthFirstOrder(g.reverse());

        for (int w : bfo.getReversePost()) {
            if (!marked[w]) {
                dfs(g, w);
                count++;
            }
        }
    }

    private void dfs(directedGraph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) dfs(g, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {//是否强连通
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int getCount() {
        return count;
    }
}
