package directedGraphs;

import Stack.stack;
import queue.queue;

//有向图深度优先遍历
public class DepthFirstOrder {
    private boolean marked[];
    private queue<Integer> pre;//先序
    private queue<Integer> post;//后续
    private stack<Integer> reversePost;//逆后序遍历

    public DepthFirstOrder(directedGraph g) {
        pre = new queue<Integer>(g.getV());
        post = new queue<Integer>(g.getV());
        reversePost = new stack<>(g.getV());
        marked = new boolean[g.getV()];

        for (int v = 0; v < g.getV(); v++){
            if(!marked[v]) dfs(g,v);
        }
    }

    private void dfs(directedGraph g,int s){
        pre.enqueue(s);
        marked[s] = true;
        for(int w:g.adj(s)){
            if(!marked[w]) dfs(g,w);
        }
        post.enqueue(s);
        reversePost.push(s);
    }

    public Iterable<Integer> getPre(){
        return pre;
    }

    public Iterable<Integer> getPost() {
        return post;
    }

    public Iterable<Integer> getReversePost() {
        return reversePost;
    }
}
