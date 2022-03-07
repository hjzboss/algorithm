package MST;

import bag.Bag;
import map.LinearProbingHashST;
import queue.queue;

import java.util.HashMap;
import java.util.HashSet;

//加权无向图
public class EdgeWeightedGraph {
    private final int v;
    private int E;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.v = v;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Edge>();
        }
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> getAdj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        HashSet<Edge> edge = new HashSet<>();
        for (int i = 0; i < getV(); i++) {
            for (Edge e : getAdj(i)) {
                edge.add(e);
            }
        }
        return edge;
    }

    public double weight() {//总权重
        double sum = 0.0;
        for (Edge e : edges()) {
            sum += e.getWeight();
        }
        return sum;
    }

//    public static void main(String[] args) {
//        EdgeWeightedGraph g = new EdgeWeightedGraph(5);
//        g.addEdge(new Edge(0,1,1.0));
//        g.addEdge(new Edge(1,2,2.0));
//        g.addEdge(new Edge(2,3,3.0));
//        g.addEdge(new Edge(0,3,1.5));
//        g.addEdge(new Edge(3,4,4.0));
//
//        Iterable<Edge> edges = g.edges();
//        for(Edge e:edges){
//            System.out.println(e.toString());
//        }
//
//        System.out.println(g.weight());
//    }
}
