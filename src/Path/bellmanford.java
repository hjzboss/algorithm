package Path;

import java.util.Arrays;

/**
 * 贝尔曼佛德算法
 */
public class bellmanford {
    private final double[] distTo;
    private final DirectedEdge[] edgeTo;
    private final int start;

    public bellmanford(EdgeWeightedDigraph g, int start) {
        distTo = new double[g.getV()];
        edgeTo = new DirectedEdge[g.getV()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.start = start;
        distTo[start] = 0;
        for (int pass = 0; pass < g.getV(); pass++) {
            for (int i = 0; i < g.getV(); i++) {
                relax(g, i);
            }
        }

        for (int pass = 0; pass < g.getV(); pass++) {
            for (int i = 0; i < g.getV(); i++) {
                NegativeCycle(g, i);
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(5);
        g.addEdge(new DirectedEdge(0, 1, -1));
        g.addEdge(new DirectedEdge(0, 2, 10));
        g.addEdge(new DirectedEdge(1, 4, 2));
        g.addEdge(new DirectedEdge(1, 2, 10));
        g.addEdge(new DirectedEdge(1, 3, 2));
        g.addEdge(new DirectedEdge(4, 3, -3));
        g.addEdge(new DirectedEdge(3, 1, 2));
        g.addEdge(new DirectedEdge(3, 2, 5));

        bellmanford bellmanford = new bellmanford(g, 0);
        bellmanford.pathTo(2);

    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.getAdj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = distTo[v] + e.getWeight();
                edgeTo[w] = e;
            }
        }
    }

    private void NegativeCycle(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.getAdj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = Double.NEGATIVE_INFINITY;
            }
        }
    }

    public double getDistTo(int v) {
        return distTo[v];
    }

    public void pathTo(int v) {
        if (distTo[v] == Double.NEGATIVE_INFINITY) {
            System.out.println("There is no min path to node " + v + "!");
        } else {
            double sum = 0.0;
            System.out.print("path:");
            for (int i = v; i != this.start; i = edgeTo[i].from()) {
                System.out.print(edgeTo[i] + " ");
                sum += edgeTo[i].getWeight();
            }
            System.out.print(" weight:" + sum);
        }
    }
}
