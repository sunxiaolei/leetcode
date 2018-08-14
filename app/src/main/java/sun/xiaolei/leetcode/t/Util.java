package sun.xiaolei.leetcode.t;

import sun.xiaolei.leetcode.P206_reverse_linked_list;

/**
 * @author sun
 * @emil xiaoleisun92@gmail.com
 * description:
 */
public class Util {

    public static ListNode arr2ListNode(int[] arr) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return node.next;
    }
}
