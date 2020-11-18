package directedGraphs;

//拓扑排序
public class Topological {
    private Iterable<Integer> order;

    public Topological(directedGraph g) {
        directedCycle dc = new directedCycle(g);
        if (!dc.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(g);
            this.order = dfo.getReversePost();
        }
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

    public boolean isDAG() {//判断是否为有向无环图
        return order != null;
    }
}
