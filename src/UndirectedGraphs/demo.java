package UndirectedGraphs;

public class demo {
    public static void main(String[] args) {
        graph g = new graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,1);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(2,3);
        g.addEdge(3,5);

        DepthPaths ds = new DepthPaths(g, 0);
        Iterable<Integer> path = ds.pathTo(3);
        System.out.print(0+" to "+3+":");
        for(int w:path){
            if(w!=3) System.out.print(w+"->");
            else System.out.print(w);
        }
        System.out.println();
        System.out.print(0+" to "+4+":");
        breadthFirstPaths br = new breadthFirstPaths(g, 0);
        Iterable<Integer> pathTo = br.pathTo(4);
        for(int w:pathTo){
            if(w != 4) System.out.print(w+"->");
            else System.out.print(w);
        }

        CC c = new CC(g);
        System.out.println();
        System.out.println(c.getCount());//连通分量
        System.out.println(new Cycle(g).HasCycle());//有环
        System.out.println(br.distTo(2));
    }
}
