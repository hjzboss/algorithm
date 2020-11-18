package UndirectedGraphs;

public class demo1 {
    public static void main(String[] args) {
        graph g = new graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,3);
        g.addEdge(4,5);
        g.addEdge(5,6);

        CC c = new CC(g);
        System.out.println(c.getCount());
        System.out.println(c.isConnected(0,4));
        System.out.println(c.getId(1));

        DepthPaths dp = new DepthPaths(g, 0);
        System.out.println(dp.hasPathTo(4));

        Iterable<Integer> iterable = dp.pathTo(3);
        for(int w:iterable){
            if(w != 3) System.out.print(w+"->");
            else System.out.print(w);
        }

        System.out.println(new Cycle(g).HasCycle());
    }
}
