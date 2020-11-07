package Path;

import bag.Bag;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int v) {
        V = v;
        E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<DirectedEdge>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> getAdj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < getV(); v++) {
            for (DirectedEdge e : getAdj(v)) {
                bag.add(e);
            }
        }
        return bag;
    }
}
