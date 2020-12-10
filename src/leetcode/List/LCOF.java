package leetcode.List;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class LCOF {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */


    /**
     * 我的解法1：遍历，很慢的解法
     * 提交记录
     * 45 / 45 个通过测试用例
     * 状态：通过
     * 执行用时: 779 ms
     * 内存消耗: 41.3 MB
     */
    public class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode t1 = headA;
            ListNode t2;

            for (ListNode temp = t1; temp != null; temp = temp.next) {
                t2 = headB;
                for (; t2 != null; t2 = t2.next) {
                    if (t2 == temp) return t2;
                }
            }

            return null;
        }
    }

    /**
     * 我的解法2：比较长度，长的后移到长度相等。然后两个链表同时向后遍历，相等则返回
     * <p>
     * 提交记录
     * 45 / 45 个通过测试用例
     * 状态：通过
     * 执行用时: 1 ms
     * 内存消耗: 41.1 MB
     * 时间击败100%
     * 空间击败95%
     */
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            int la = getLength(headA);
            int lb = getLength(headB);
            while (la != lb) {
                if (la > lb) {
                    headA = headA.next;
                    la--;
                } else {
                    headB = headB.next;
                    lb--;
                }
            }

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }

        private int getLength(ListNode head) {
            ListNode l = head;
            int length = 0;
            while (head != null) {
                head = head.next;
                length++;
            }
            return length;
        }
    }

    /**
     * 参考解法：双指针循环遍历。用两个指针指向两个链表，同时向后遍历。如果遍历到末尾则重新指向头结点
     * 再进行遍历，直到两个相等。
     * <p>
     * 45 / 45 个通过测试用例
     * 状态：通过
     * 执行用时: 1 ms
     * 内存消耗: 41.1 MB
     */
    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //tempA和tempB我们可以认为是A,B两个指针
            ListNode tempA = headA;
            ListNode tempB = headB;
            while (tempA != tempB) {
                //如果指针tempA不为空，tempA就往后移一步。
                //如果指针tempA为空，就让指针tempA指向headB（注意这里是headB不是tempB）
                tempA = tempA == null ? headB : tempA.next;
                //指针tempB同上
                tempB = tempB == null ? headA : tempB.next;
            }
            //tempA要么是空，要么是两链表的交点
            return tempA;
        }
    }
}
