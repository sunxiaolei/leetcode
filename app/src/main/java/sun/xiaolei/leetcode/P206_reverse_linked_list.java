package sun.xiaolei.leetcode;

import java.util.ArrayList;
import java.util.List;

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

    public static ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        list.add(head.val);
        while (temp.next != null) {
            list.add(temp.next.val);
            temp = temp.next;
        }
        temp = node;
        for (int i = 0; i < list.size(); i++) {
            temp.next = new ListNode(list.get(list.size() - 1 - i));
            temp = temp.next;
        }
        return node.next;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nodeNext = head.next;
        head.next = null;
        ListNode node = reverseList2(nodeNext);
        nodeNext.next = head;
        return node;
    }


}
