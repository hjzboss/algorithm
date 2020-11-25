package leetcode.tree;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */
public class CountCompleteTreeNodes {
    /**
     * 暴力解法，不解释
     */
    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }

    /**
     * 解法二：利用完全二叉树的性质，左边子树的层数大于或等于右子树的层数
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        //计算左右子树的层数
        int left = level(root.left);
        int right = level(root.right);
        int count;
        //如果相等，说明左子树已经是满二叉树，左子树的节点数为2*left - 1，再加上自己这个节点，即使2*left个
        //然后再递归遍历右子树
        if (left == right) {
            count = countNodes(root.right) + (1 << left);
        }
        //如果不相等，说明右子树的上一层已经是满二叉树，其节点数为2*right - 1，再加上自己这个节点，即使2*right个
        //然后再递归遍历左子树
        else {
            count = countNodes(root.left) + (1 << right);
        }

        return count;
    }

    //计算完全二叉树的层数，只需遍历左子树即可
    private int level(TreeNode node) {
        int sum = 0;
        while (node != null) {
            sum += 1;
            node = node.left;
        }
        return sum;
    }
}
