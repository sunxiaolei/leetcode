package sun.xiaolei.leetcode;

import sun.xiaolei.leetcode.t.ListNode;
import sun.xiaolei.leetcode.t.Util;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class P206_reverse_linked_list {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {};
        ListNode node = reverseList1(Util.arr2ListNode(arr));
        System.out.println(node == null ? null : node.toString());
        ListNode node2 = reverseList2(Util.arr2ListNode(arr));
        System.out.println(node2 == null ? null : node2.toString());
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return node.next;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nodeNext = head.next;
        head.next = null;
        ListNode node = reverseList2(nodeNext);
        nodeNext.next = head;
        return node;
    }


}
