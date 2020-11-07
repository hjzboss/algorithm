package directedGraphs;

import Stack.stack;

/*判断是否有环*/
public class directedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;//
    private stack<Integer> cycle;//有向环中的所有顶点

    public directedCycle(directedGraph g) {
        marked = new boolean[g.getV()];
        edgeTo = new int[g.getV()];
        onStack = new boolean[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            if (!marked[v]) dfs(g, v);
        }
    }

    private void dfs(directedGraph g, int s) {
        marked[s] = true;
        onStack[s] = true;
        for (int w : g.adj(s)) {
            if (hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = s;
                dfs(g, w);
            } else if(onStack[w]){
                cycle = new stack<>(g.getV());
                for(int x = s;x != w;x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(s);
            }
        }
        onStack[s] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return this.cycle;
    }
}
