package Path;

import Heap.IndexMinPQ;
import Stack.stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    private final int s;

    public DijkstraSP(EdgeWeightedDigraph g, int s) {
        this.s = s;
        edgeTo = new DirectedEdge[g.getV()];
        distTo = new double[g.getV()];
        pq = new IndexMinPQ<Double>(g.getV());
        for (int i = 0; i < g.getV(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.getAdj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = distTo[v] + e.getWeight();
                edgeTo[w] = e;
                if (!pq.contains(w)) pq.insert(w, distTo[w]);
                else pq.change(w, distTo[w]);
            }
        }
    }

    public double distTo(int v) {
        return this.distTo[v];
    }

    public boolean hasPathTo(int v) {
        return this.distTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        stack<DirectedEdge> path = new stack<>(50);
        for (; v != s; v = edgeTo[v].from()) {
            path.push(edgeTo[v]);
        }
        return path;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(5);
        g.addEdge(new DirectedEdge(0, 1, 10.0));
        g.addEdge(new DirectedEdge(1, 2, 50));
        g.addEdge(new DirectedEdge(0, 4, 100));
        g.addEdge(new DirectedEdge(0, 3, 30));
        g.addEdge(new DirectedEdge(2, 4, 10.0));
        g.addEdge(new DirectedEdge(3, 4, 60));
        g.addEdge(new DirectedEdge(3, 2, 20));
        DijkstraSP dijkstraSP = new DijkstraSP(g, 0);
        System.out.println(dijkstraSP.distTo(3));
        Iterable<DirectedEdge> path = dijkstraSP.pathTo(2);
        for (DirectedEdge e : path) {
            System.out.print(e.toString() + " ");
        }
    }
}
