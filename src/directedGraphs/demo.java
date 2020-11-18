package directedGraphs;

import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        directedGraph dg = new directedGraph(4);
        dg.addEdge(0,1);
        dg.addEdge(1,2);
        dg.addEdge(2,3);
        dg.addEdge(3,1);

        directedCycle dc = new directedCycle(dg);
        System.out.println(dc.hasCycle());

        kosarajuSCC scc = new kosarajuSCC(dg);
        System.out.println(scc.stronglyConnected(1,0));

    }
}
