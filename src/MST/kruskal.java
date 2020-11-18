package MST;

import Heap.MinHeap;
import Union.quickUnion;
import queue.queue;

public class kruskal {
    private queue<Edge> mst;

    public kruskal(EdgeWeightedGraph g) {
        mst = new queue<Edge>(g.getE());
        MinHeap<Edge> pq = new MinHeap<Edge>(g.getE());
        for (Edge e : g.edges()) {
            pq.insert(e);
        }
        quickUnion qu = new quickUnion(g.getV());

        while (!pq.isEmpty() && mst.size() < g.getV() - 1) {
            Edge e = pq.delete();
            int v = e.either();
            int w = e.other(v);
            if (qu.connected(v, w)) continue;
            qu.union(v, w);
            mst.enqueue(e);
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

    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(5);
        g.addEdge(new Edge(0, 1, 1.0));
        g.addEdge(new Edge(1, 2, 2.0));
        g.addEdge(new Edge(2, 3, 3.0));
        g.addEdge(new Edge(0, 3, 1.5));
        g.addEdge(new Edge(3, 4, 4.0));

        Iterable<Edge> edges = g.edges();
        for (Edge e : edges) {
            System.out.println(e.toString());
        }
        System.out.println("-------------");
        kruskal k = new kruskal(g);
        for (Edge e : k.edges()) {
            System.out.println(e.toString());
        }
        System.out.println(k.weight());
    }
}
