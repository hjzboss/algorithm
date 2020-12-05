package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 面试题 04.01. 节点间通路
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 示例1:
 *
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 *
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class RouteBetweenNodesLCCI {
    /**
     * 我的解法（很蠢）：dfs
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 34 ms
     * , 在所有 Java 提交中击败了
     * 33.30%
     * 的用户
     * 内存消耗：
     * 78.2 MB
     * , 在所有 Java 提交中击败了
     * 90.62%
     * 的用户
     */
    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            G g = new G(graph,n);
            g.bfs(start);
            return g.isConnected(target);
        }
    }

    class G {
        private final HashMap<Integer, LinkedList> arr;
        private final boolean[] marked;

        public G(int[][] edges, int n) {
            arr = new HashMap<>();
            this.marked = new boolean[100000];
            for (int[] a : edges) {
                if(!arr.containsKey(a[0])){
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(a[1]);
                    arr.put(a[0],list);
                }else{
                    arr.get(a[0]).add(a[1]);
                }
            }
        }

        public void bfs(int start) {
            if(!arr.containsKey(start)) return;
            marked[start] = true;
            f(start);
        }

        private void f(int start){
            for (Object i : arr.get(start)) {
                marked[(Integer) i] = true;
                if (arr.containsKey(i)) bfs((Integer) i);
            }
        }

        public boolean isConnected(int target) {
            return marked[target];
        }
    }
}
