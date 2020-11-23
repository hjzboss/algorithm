package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 示例1
 * 输入
 * 复制
 * {1,2}
 * 返回值
 * 复制
 * [[1],[2]]
 * 示例2
 * 输入
 * 复制
 * {1,2,3,4,#,#,5}
 * 返回值
 * 复制
 * [[1],[2,3],[4,5]]
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class LevelOrder {
    /**
     * 二叉树的层次遍历
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                //关键点：先将队列的大小保存
                int size = q.size();
                ArrayList<Integer> tmp = new ArrayList<>();
                //将队列中原来的元素加入一个数组列表中，将其后代节点加入队列
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    tmp.add(node.val);

                    if (node.left != null) {
                        q.offer(node.left);
                    }

                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                result.add(tmp);
            }
        }

        return result;
    }
}
