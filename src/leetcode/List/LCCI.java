package leetcode.List;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 */
public class LCCI {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //旧方法，双指针遍历，直到找到k个元素
    public int kthToLast(ListNode head, int k) {
        int flag = 0;
        ListNode t, temp;
        for (t = head; t != null; t = t.next) {
            temp = t;
            flag = 0;
            while (temp != null) {
                temp = temp.next;
                flag++;
            }
            if (flag == k) {
                return t.val;
            }
        }
        return 0;
    }

    //改进后的方法，双指针，第二个指针先遍历k个元素，再一起移动
    public int kthToLast1(ListNode head, int k) {
        ListNode first, second;
        first = head;
        second = head;
        while (k != 0) {
            second = second.next;
            k--;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first.val;
    }
}
