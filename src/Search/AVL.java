package Search;

import java.util.Iterator;

/**
 * AVL树的实现
 */
public class AVL<T extends Comparable<T>> {
    private static final int ALLOWED_BALANCED = 1;   //左右子树允许的最大高度差
    private AvlNode root;    //根节点

    public static void main(String[] args) {
        AVL<Integer> avl = new AVL<>();
        avl.insert(1);
        avl.insert(3);
        avl.insert(2);
        avl.midTraversal();
        System.out.println(avl.isBalanced());
        avl.insert(-1);
        avl.insert(0);
        avl.midTraversal();
        System.out.println(avl.isBalanced());
        avl.delete(2);
        avl.midTraversal();
        System.out.println(avl.isBalanced());
    }

    /**
     * 中序遍历
     */
    public void midTraversal() {
        midTraversal(root);
    }

    /**
     * 中序遍历递归调用
     *
     * @param t 遍历的节点
     */
    private void midTraversal(AvlNode t) {
        if (t == null) return;
        midTraversal(t.left);
        System.out.print(" " + t.element);
        midTraversal(t.right);
    }

    /**
     * 插入节点
     *
     * @param element 被插入的节点
     */
    public void insert(T element) {
        this.root = insert(root, element);
    }

    /**
     * 删除节点
     *
     * @param element 要删除的元素
     */
    public void delete(T element) {
        this.root = delete(root, element);
    }

    /**
     * 递归调用的插入操作
     *
     * @param t       被插入的节点
     * @param element 待插入的元素
     * @return 插入后的节点
     */
    private AvlNode insert(AvlNode t, T element) {
        if (t == null) return new AvlNode(element);

        int cmp = element.compareTo(t.element);

        if (cmp < 0) {
            t.left = insert(t.left, element);
        } else if (cmp > 0) {
            t.right = insert(t.right, element);
        } else
            ;

        return balance(t);
    }

    /**
     * 递归调用删除节点
     *
     * @param t       被删除元素的节点
     * @param element 要删除的元素
     * @return 删除后的节点
     */
    private AvlNode delete(AvlNode t, T element) {
        if (t == null) return null;

        int cmp = element.compareTo(t.element);

        if (cmp < 0) {
            t.left = delete(t.left, element);
        } else if (cmp > 0) {
            t.right = delete(t.right, element);
        } else {
            if (t.left != null && t.right != null) {
                t.element = findMin(t.right);
                t.right = deleteMin(t.right);
            } else {
                t = (t.left == null) ? t.right : t.left;
            }
        }

        return balance(t);
    }

    /**
     * 查找最小的元素值
     *
     * @param t 要查找的树
     * @return 最小的元素值
     */
    private T findMin(AvlNode t) {
        AvlNode temp = t;
        if (temp.left == null) return t.element;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp.element;
    }

    /**
     * 删除最小元素值的节点
     *
     * @param t 被删除的树
     * @return 被删除后的树
     */
    private AvlNode deleteMin(AvlNode t) {
        if (t == null) return null;

        if (t.left != null) {
            t.left = deleteMin(t.left);
        } else {
            t = t.right;
        }

        return t;
    }

    /**
     * 平衡节点
     *
     * @param t 待平衡的节点
     * @return 平衡后的节点
     */
    private AvlNode balance(AvlNode t) {
        if (t == null) return null;

        if (height(t.left) - height(t.right) > ALLOWED_BALANCED) {
            if (height(t.left.left) > height(t.left.right)) {
                t = rotateWithLeft(t);
            } else {
                t = doubleRotateWithLeftRight(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_BALANCED) {
            if (height(t.right.right) > height(t.right.left)) {
                t = rotateWithRight(t);
            } else {
                t = doubleRotateWithRightLeft(t);
            }
        } else
            ;

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * 求节点的高度
     *
     * @param node 待求高度的节点
     * @return 返回节点的高度
     */
    private int height(AvlNode node) {
        return node == null ? -1 : node.height;
    }

    /**
     * 左单旋
     *
     * @param t 被旋转的节点
     * @return 旋转后的节点
     */
    private AvlNode rotateWithLeft(AvlNode t) {
        AvlNode k = t.left;
        t.left = k.right;
        k.right = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;//该节点的高度比其子树的高度大一
        k.height = Math.max(height(k.left), t.height) + 1;
        return k;
    }

    /**
     * 右单旋
     *
     * @param t 被旋转的节点
     * @return 旋转后的节点
     */
    private AvlNode rotateWithRight(AvlNode t) {
        AvlNode k = t.right;
        t.right = k.left;
        k.left = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;//该节点的高度比其子树的高度大一
        k.height = Math.max(height(k.right), t.height) + 1;
        return k;
    }

    /**
     * 左双旋
     *
     * @param t 待旋转的节点
     * @return 旋转后的节点
     */
    private AvlNode doubleRotateWithLeftRight(AvlNode t) {
        t.left = rotateWithRight(t.left);
        return rotateWithLeft(t);
    }

    /**
     * 右双旋
     *
     * @param t 待旋转的节点
     * @return 旋转后的节点
     */
    private AvlNode doubleRotateWithRightLeft(AvlNode t) {
        t.right = rotateWithLeft(t.right);
        return rotateWithRight(t);
    }

    /**
     * 判断avl树是否平衡
     *
     * @return 平衡
     */
    private boolean isBalanced() {
        return (height(root.left) - height(root.right) <= ALLOWED_BALANCED) ||
                (height(root.right) - height(root.left) <= ALLOWED_BALANCED);
    }

    /**
     * AVL树节点的声明
     */
    private class AvlNode {
        T element;  //值
        private int height; //高度
        private AvlNode left;   //左子树
        private AvlNode right;  //右子树

        public AvlNode(T element) {
            this(element, null, null);
        }

        public AvlNode(T element, AvlNode left, AvlNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
