package MST;

//带权重的边
public class Edge implements Comparable<Edge> {
    private final int v;            //v,w为边的两个顶点
    private final int w;
    private final double weight;    //权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {//返回其中一个顶点
        return v;
    }

    public int other(int vertex) {//返回另一个顶点
        if (vertex == v) return w;
        if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.getWeight() < edge.getWeight()) return -1;
        else if (this.getWeight() > edge.getWeight()) return 1;
        else return 0;
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
