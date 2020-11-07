package UndirectedGraphs;

import Stack.stack;

import queue.queue;
/*
* 图的广度遍历
* */
public class breadthFirstPaths {
    private boolean marked[];
    private int[] edgeTo;
    private final int s;//起点

    public breadthFirstPaths(graph g, int s) {
        this.s = s;
        edgeTo = new int[g.getV()];
        marked = new boolean[g.getV()];
        dfs(g, s);
    }

    private void dfs(graph g, int v) {//广度遍历
        marked[v] = true;
        queue<Integer> q = new queue<Integer>(100);
        q.enqueue(v);
        while (!q.isEmpty()) {
            int w = q.dequeue();
            for (int a : g.adj(w)) {
                if(!marked[a]){
                    edgeTo[a] = w;
                    marked[a] = true;
                    q.enqueue(a);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        stack<Integer> s = new stack<>(100);
        for (int x = v; x != this.s; x = edgeTo[x]) {
            s.push(x);
        }
        s.push(this.s);
        return s;
    }

    public int distTo(int v){
        if(!hasPathTo(v)) return 0;
        int path = 0;
        for(int i = v;i != s;i = edgeTo[i]){
            path++;
        }
        return path;
    }
}
