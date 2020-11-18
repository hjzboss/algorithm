package MST;

import Heap.MinHeap;
import queue.queue;

//Prim算法延时版本
public class LazyPrimMST {
    private boolean marked[];
    private MinHeap<Edge> pq;
    private queue<Edge> mst;

    public LazyPrimMST(EdgeWeightedGraph g) {
        marked = new boolean[g.getV()];
        pq = new MinHeap<Edge>(1000);
        mst = new queue<Edge>(g.getE());

        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.delete();
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(edge);
            if (!marked[v]) visit(g, v);
            if (!marked[w]) visit(g, w);
        }
    }

    //将顶点添加到树中
    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e : g.getAdj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double sum = 0.0;
        for (Edge e : edges()) {
            sum += e.getWeight();
        }
        return sum;
    }

//    public static void main(String[] args) {
//        EdgeWeightedGraph g = new EdgeWeightedGraph(5);
//        g.addEdge(new Edge(0, 1, 1.0));
//        g.addEdge(new Edge(1, 2, 2.0));
//        g.addEdge(new Edge(2, 3, 3.0));
//        g.addEdge(new Edge(0, 3, 1.5));
//        g.addEdge(new Edge(3, 4, 4.0));
//
//        LazyPrimMST mst = new LazyPrimMST(g);
//        for (Edge e : mst.edges()) {
//            System.out.println(e.toString());
//        }
//        System.out.println(mst.weight());
//    }
}
