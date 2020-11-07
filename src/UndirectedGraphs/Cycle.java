package UndirectedGraphs;

/*判断是否有环路*/
public class Cycle {
    private boolean marked[];
    private boolean hasCycle = false;

    public Cycle(graph g){
        marked = new boolean[g.getV()];
        for(int i = 0;i<g.getV();i++){
            if(!marked[i]){
                dfs(g,i,i);
            }
        }
    }

    public void dfs(graph g,int w,int v){//第二个参数为上一个节点
        marked[v] = true;
        for(int i:g.adj(v)){
            if(!marked[i]){
                dfs(g,v,i);
            }
            else if(i != w) this.hasCycle = true;
        }
    }

    public boolean HasCycle(){
        return hasCycle;
    }
}
