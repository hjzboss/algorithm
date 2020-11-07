package UndirectedGraphs;

import Stack.stack;

public class DepthPaths {
    private boolean marked[];
    private int[] edgeTo;
    private final int s;//起点

    public DepthPaths(graph g, int s){
        this.s = s;
        edgeTo = new int[g.getV()];
        marked = new boolean[g.getV()];
        dfs(g,s);
    }

    private void dfs(graph g,int v){//深度遍历
        marked[v] = true;
        for(int w:g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        stack<Integer> s = new stack<>(100);
        for(int x = v;x != this.s;x = edgeTo[x]){
            s.push(x);
        }
        s.push(this.s);
        return s;
    }
}
