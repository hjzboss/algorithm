package directedGraphs;

import bag.Bag;

//有向图
public class directedGraph {
    private final int V;//顶点数
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public directedGraph(int v) {
        V = v;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public directedGraph reverse() {
        directedGraph rg = new directedGraph(this.V);
        for (int v = 0; v < this.V; v++) {
            for (int w : adj[v]) {
                rg.addEdge(w, v);
            }
        }
        return rg;
    }
}
